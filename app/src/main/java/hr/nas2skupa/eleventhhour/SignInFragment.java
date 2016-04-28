package hr.nas2skupa.eleventhhour;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.ViewById;

import hr.nas2skupa.eleventhhour.utils.NetworkUtils;

/**
 * Created by nas2skupa on 26/04/16.
 */
@EFragment(R.layout.fragment_sign_in)
public class SignInFragment extends Fragment {
    @ViewById ViewGroup layoutMain;
    @ViewById(R.id.layout_email) TextInputLayout layoutEmail;

    @ViewById(R.id.layout_password) TextInputLayout layoutPassword;
    @ViewById(R.id.text_email) EditText textEmail;
    @ViewById(R.id.text_password) EditText textPassword;
    @ViewById(R.id.button_sign_in) Button buttonSignIn;

    @ViewById(R.id.progress_bar) ProgressBar progressBar;
    @ViewById(R.id.text_error) TextView textError;

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
        textError.setVisibility(View.GONE);
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
            textError.setVisibility(View.VISIBLE);
            textError.setText(R.string.msg_sign_in_no_network);
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

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(layoutMain.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private class LoginCallback implements AsyncCallback<BackendlessUser> {
        @Override
        public void handleResponse(BackendlessUser currentUser) {
            progressBar.setVisibility(View.GONE);
            Backendless.UserService.setCurrentUser(currentUser);
            startActivity(new Intent(getContext(), MainActivity.class));
        }

        @Override
        public void handleFault(BackendlessFault fault) {
            progressBar.setVisibility(View.GONE);
            Snackbar.make(layoutMain, fault.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }
}