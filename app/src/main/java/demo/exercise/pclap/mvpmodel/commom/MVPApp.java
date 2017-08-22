package demo.exercise.pclap.mvpmodel.commom;

import android.app.Application;
import android.content.Context;

/**
 * Created by PC Lap on 8/22/2017.
 */
public class MVPApp extends Application {

    private static Context mContentApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mContentApp = this;
    }

    public static Context getContentApp() {
        return mContentApp;
    }

}
