package hr.nas2skupa.eleventhhour;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_sign_in)
public class SignInActivity extends AppCompatActivity {
    public static final String ACTION_SIGN_OUT = "hr.nas2skupa.eleventhhour.SIGN_OUT";

    private static final long ANIMATION_DELAY = 1000;
    private static final long ANIMATION_DURATION = 500;

    @ViewById(R.id.layout_main) FrameLayout layoutMain;
    @ViewById(R.id.layout_content) RelativeLayout layoutContent;
    @ViewById(R.id.image_splash_background) ImageView imageSplashBackground;
    @ViewById(R.id.image_splash_overlay) ImageView imageSplashOverlay;
    @ViewById(R.id.text_sign_in_message) TextView textSignInMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getAction() == ACTION_SIGN_OUT)
            Backendless.UserService.logout();
    }

    @AfterViews
    public void afterViews() {
        layoutMain.post(new Runnable() {
            @Override
            public void run() {
                onLayoutMainReady();
            }
        });
    }

    @MainThread
    public void onLayoutMainReady() {
        setImageViewTopCrop(imageSplashBackground);
        setImageViewTopCrop(imageSplashOverlay);

        Backendless.UserService.isValidLogin(new IsValidLoginCallback());
    }

    /**
     * Sets the ImageView scale type to crop top
     *
     * @param view
     */
    private void setImageViewTopCrop(ImageView view) {
        float scaleX = ((float) view.getWidth()) / view.getDrawable().getIntrinsicWidth();
        float scaleY = ((float) view.getHeight()) / view.getDrawable().getIntrinsicHeight();
        float scale = Math.max(scaleX, scaleY);
        Matrix matrix = view.getImageMatrix();
        matrix.setScale(scale, scale, 0, 0);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setImageMatrix(matrix);
    }

    private void animateHeader() {
        // Splash overlay image image is 50% longer so it can be animated up
        final float scaleX = ((float) layoutMain.getWidth()) / imageSplashOverlay.getDrawable().getIntrinsicWidth();
        final float scaleY = ((float) layoutMain.getHeight()) / imageSplashOverlay.getDrawable().getIntrinsicHeight();
        final float scale = Math.max(scaleX, scaleY);

        final int imageMainHeight = (int) (imageSplashOverlay.getDrawable().getIntrinsicHeight() * (2f / 3) * scale);
        final float headerHeight = getResources().getDimension(R.dimen.sign_in_header_hight);
        final int initialHeight = imageSplashOverlay.getHeight();

        ValueAnimator valueAnimator = ObjectAnimator.ofInt(0, (int) ((imageMainHeight - headerHeight) / 2));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageSplashOverlay.getLayoutParams();
                layoutParams.height = initialHeight + val;
                imageSplashOverlay.setTranslationY(-val);
                imageSplashOverlay.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setStartDelay(ANIMATION_DELAY);
        valueAnimator.setDuration(ANIMATION_DURATION);
        valueAnimator.start();
    }

    private void showSignInFragment() {
        if (getSupportFragmentManager().findFragmentByTag("SignInFragment_") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SignInFragment_(), "SignInFragment_")
                    .commit();

        textSignInMessage.animate()
                .alpha(0)
                .setStartDelay(ANIMATION_DELAY)
                .setDuration(0)
                .start();

        animateHeader();

        layoutContent.animate()
                .alpha(1)
                .setStartDelay(ANIMATION_DELAY + ANIMATION_DURATION)
                .setDuration(ANIMATION_DURATION)
                .start();
    }

    private class IsValidLoginCallback implements AsyncCallback<Boolean> {
        @Override
        public void handleResponse(Boolean isValidLogin) {
            if (isValidLogin && Backendless.UserService.CurrentUser() == null) {
                String currentUserId = Backendless.UserService.loggedInUser();

                if (!currentUserId.equals("")) {
                    Backendless.UserService.findById(currentUserId, new FindByIdCallback());
                }
            } else
                showSignInFragment();
        }

        @Override
        public void handleFault(BackendlessFault fault) {
            Snackbar.make(layoutMain, fault.getMessage(), Snackbar.LENGTH_LONG).show();
            showSignInFragment();
        }
    }

    private class FindByIdCallback implements AsyncCallback<BackendlessUser> {
        @Override
        public void handleResponse(BackendlessUser currentUser) {
            Backendless.UserService.setCurrentUser(currentUser);
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }

        @Override
        public void handleFault(BackendlessFault fault) {
            Snackbar.make(layoutMain, fault.getMessage(), Snackbar.LENGTH_LONG).show();
            showSignInFragment();
        }
    }
}
