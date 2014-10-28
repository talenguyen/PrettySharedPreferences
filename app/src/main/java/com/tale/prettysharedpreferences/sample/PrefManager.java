package com.tale.prettysharedpreferences.sample;

import android.content.SharedPreferences;

import com.tale.prettysharedpreferences.StringEditor;

/**
 * Created by TALE on 10/28/2014.
 */
public class PrefManager extends com.tale.prettysharedpreferences.PrettySharedPreferences {

    public PrefManager(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public StringEditor<PrefManager> username() {
        return getStringEditor("username");
    }
}
