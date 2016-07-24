package hr.nas2skupa.eleventhhour.ui.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.facebook.CallbackManager;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hr.nas2skupa.eleventhhour.R;
import hr.nas2skupa.eleventhhour.ui.MainActivity;
import hr.nas2skupa.eleventhhour.utils.NetworkUtils;

/**
 * Created by nas2skupa on 26/04/16.
 */
@EFragment(R.layout.fragment_sign_in)
public class SignInFragment extends Fragment implements
        GoogleApiClient.OnConnectionFailedListener {
    @ViewById ViewGroup layoutMain;
    @ViewById(R.id.layout_email) TextInputLayout layoutEmail;

    @ViewById(R.id.layout_password) TextInputLayout layoutPassword;
    @ViewById(R.id.text_email) EditText textEmail;
    @ViewById(R.id.text_password) EditText textPassword;
    @ViewById(R.id.button_sign_in) Button buttonSignIn;
    @ViewById(R.id.button_google_plus) ImageView buttonGooglePlus;

    @ViewById(R.id.progress_bar) ProgressBar progressBar;

    private static final int RC_GET_TOKEN_GOOGLE = 9002;
    private static final int RC_GET_TOKEN_FACEBOOK = 9003;

    private GoogleApiClient googleApiClient;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Google Plus login
        String serverClientId = getString(hr.nas2skupa.eleventhhour.R.string.google_server_client_id);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .requestId()
                .requestIdToken(serverClientId)
                .build();

        // Build GoogleAPIClient with the Google Sign-In API and the above options.
        googleApiClient = new GoogleApiClient.Builder(getContext())
                .enableAutoManage(getActivity() /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        // Facebook login
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        buttonGooglePlus.setVisibility(View.GONE);
    }

    @EditorAction(R.id.text_password)
    public boolean signInKeyboard() {
        buttonSignIn.callOnClick();
        return true;
    }

    @TextChange({R.id.text_email, R.id.text_password})
    public void clearErrors() {
        layoutEmail.setError(null);
        layoutEmail.setErrorEnabled(false);
        layoutPassword.setError(null);
        layoutPassword.setErrorEnabled(false);
    }

    @Click(R.id.button_sign_in)
    public void signIn() {
        hideKeyboard();

        clearErrors();

        final String email = textEmail.getText().toString();
        final String password = this.textPassword.getText().toString();
        final boolean isValidEmail = email.matches("^[\\p{L}\\p{N}\\._%+-]+@[\\p{L}\\p{N}\\.\\-]+\\.[\\p{L}]{2,}$");

        if (!isValidEmail) {
            layoutEmail.setError("Please enter valid email address.");
            layoutEmail.setErrorEnabled(true);
            textEmail.requestFocus();
            return;
        } else if (password.length() < 6) {
            layoutPassword.setError("Password must be at least 6 characters long");
            layoutPassword.setErrorEnabled(true);
            textPassword.requestFocus();
            return;
        }

        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            Snackbar.make(layoutMain, R.string.msg_sign_in_no_network, Snackbar.LENGTH_LONG).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        Backendless.UserService.login(email, password, new LoginCallback(), true);
    }

    @Click(R.id.button_register)
    public void register() {
        hideKeyboard();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new RegisterFragment_(), "RegisterFragment")
                .addToBackStack("RegisterFragment")
                .commit();
    }

    @Click(R.id.button_forgot_password)
    public void forgotPassword() {
        hideKeyboard();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ForgotPasswordFragment_(), "ForgotPasswordFragment")
                .addToBackStack("ForgotPasswordFragment")
                .commit();
    }

    @Click(R.id.button_google_plus)
    public void signInGoogle() {
//        progressBar.setVisibility(View.VISIBLE);
//        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
//        startActivityForResult(signInIntent, RC_GET_TOKEN_GOOGLE);


        Map<String, String> googlePlusFieldsMapping = new HashMap<String, String>();
        googlePlusFieldsMapping.put("given_name", "first_name");
        googlePlusFieldsMapping.put("family_name", "last_name");
        googlePlusFieldsMapping.put("gender", "gender");
        googlePlusFieldsMapping.put("email", "email");
        List<String> permissions = new ArrayList<String>();
        Backendless.UserService.loginWithGooglePlus(getActivity(), new WebView(getContext()), googlePlusFieldsMapping, permissions, new LoginCallback());

    }

    @Click(R.id.button_facebook)
    public void signInFacebook() {
        progressBar.setVisibility(View.VISIBLE);
        Map<String, String> facebookFieldMappings = new HashMap<String, String>();
        facebookFieldMappings.put("email", "fb_email");

        List<String> permissions = new ArrayList<String>();
        permissions.add("email");

        Backendless.UserService.loginWithFacebookSdk(getActivity(),
                facebookFieldMappings,
                permissions,
                callbackManager,
                new LoginCallback());
    }

    @Click(R.id.button_twitter)
    public void signInTwitter() {
        progressBar.setVisibility(View.VISIBLE);

        Map<String, String> twitterFieldsMappings = new HashMap<String, String>();
        twitterFieldsMappings.put("name", "twitter_name");

        Backendless.UserService.loginWithTwitter(getActivity(), twitterFieldsMappings, new LoginCallback());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RC_GET_TOKEN_GOOGLE:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

                if (result.isSuccess()) {
                    getGoogleTokens(result);
                } else {
                    Snackbar.make(layoutMain, "Sorry, there was a problem signing you in with your Google account. Please try again later or use email sign in.", Snackbar.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case RC_GET_TOKEN_FACEBOOK:
                callbackManager.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    @Background
    public void getGoogleTokens(GoogleSignInResult result) {
        try {
            final String scopes = "oauth2:" + Scopes.PLUS_LOGIN + " " + Scopes.PLUS_ME + " " + Scopes.PROFILE + " " + Scopes.EMAIL;
            GoogleSignInAccount acct = result.getSignInAccount();
            String idToken = acct.getIdToken();
            String token = GoogleAuthUtil.getToken(getContext(), acct.getEmail(), scopes);
            GoogleAuthUtil.invalidateToken(getContext(), token);

            handleGoogleAccessTokenInBackendless(idToken, token);
        } catch (IOException | GoogleAuthException e) {
            handleGoogleAccessTokenInBackendless(null, null);
        }
    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    public void handleGoogleAccessTokenInBackendless(String idToken, String accessToken) {
        if (idToken == null || accessToken == null) {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(layoutMain, R.string.msg_sign_in_google_failed, Snackbar.LENGTH_LONG).show();
            return;
        }

        Map<String, String> googlePlusFieldsMapping = new HashMap<String, String>();
        googlePlusFieldsMapping.put("given_name", "first_name");
        googlePlusFieldsMapping.put("family_name", "last_name");
        googlePlusFieldsMapping.put("gender", "gender");
        googlePlusFieldsMapping.put("email", "email");
        List<String> permissions = new ArrayList<>();
        Backendless.UserService.loginWithGooglePlusSdk(idToken, accessToken, googlePlusFieldsMapping, permissions, new LoginCallback());
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(layoutMain.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private class LoginCallback implements AsyncCallback<BackendlessUser> {
        @Override
        public void handleResponse(BackendlessUser currentUser) {
            progressBar.setVisibility(View.GONE);
            Backendless.UserService.setCurrentUser(currentUser);
            startActivity(new Intent(getContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        }

        @Override
        public void handleFault(BackendlessFault fault) {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(layoutMain, fault.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }
}