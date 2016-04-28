package hr.nas2skupa.eleventhhour;

import android.app.Application;

import com.backendless.Backendless;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by nas2skupa on 22/03/16.
 */
public class App extends Application {
    public static String BACKENDLESS_APP_ID = "FB50BB27-7C44-6362-FFF3-94862BC27200";
    public static String BACKENDLESS_SECRET_ID = "716ABAC4-C956-5B16-FF8F-F1B26D516C00";
    public static String BACKENDLESS_VERSION = "v1";

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        Backendless.initApp(getApplicationContext(), BACKENDLESS_APP_ID, BACKENDLESS_SECRET_ID, BACKENDLESS_VERSION);
    }
}
