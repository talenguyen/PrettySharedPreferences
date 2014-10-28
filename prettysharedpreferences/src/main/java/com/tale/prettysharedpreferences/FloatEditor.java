package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class FloatEditor<T extends PrettySharedPreferences> extends TypeEditor<Float, T> {
    protected FloatEditor(T target, SharedPreferences sharedPreferences, String key) {
        super(target, sharedPreferences, key);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, Float value) {
        editor.putFloat(key, value);
    }

    @Override
    protected Float getValue(SharedPreferences sharedPreferences, String key, Float def) {
        return sharedPreferences.getFloat(key, def);
    }
}
