package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class StringEditor<T extends PrettySharedPreferences> extends TypeEditor<String, T> {
    protected StringEditor(T target, SharedPreferences sharedPreferences, String key) {
        super(target, sharedPreferences, key);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, String value) {
        editor.putString(key, value);
    }

    @Override
    protected String getValue(SharedPreferences sharedPreferences, String key, String def) {
        return sharedPreferences.getString(key, def);
    }
}
