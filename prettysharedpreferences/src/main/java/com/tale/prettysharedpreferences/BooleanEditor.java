package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class BooleanEditor extends TypeEditor<Boolean> {
    protected BooleanEditor(SharedPreferences sharedPreferences, String key) {
        super(sharedPreferences, key);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, Boolean value) {
        editor.putBoolean(key, value);
    }

    @Override
    protected Boolean getValue(SharedPreferences sharedPreferences, String key, Boolean def) {
        return sharedPreferences.getBoolean(key, def);
    }
}
