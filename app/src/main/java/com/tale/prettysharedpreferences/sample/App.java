package com.tale.prettysharedpreferences.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by tale on 10/30/14.
 */
public class App extends Application {

    private PrefManager prefManager;

    @Override
    public void onCreate() {
        super.onCreate();
        prefManager = new PrefManager(getSharedPreferences("App", MODE_PRIVATE));
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public PrefManager getPrefManager() {
        return prefManager;
    }
}
