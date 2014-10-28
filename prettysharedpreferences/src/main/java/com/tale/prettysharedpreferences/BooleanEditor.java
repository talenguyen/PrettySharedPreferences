package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class BooleanEditor<T extends PrettySharedPreferences> extends TypeEditor<Boolean, T> {
    protected BooleanEditor(T target, SharedPreferences sharedPreferences, String key) {
        super(target, sharedPreferences, key);
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
