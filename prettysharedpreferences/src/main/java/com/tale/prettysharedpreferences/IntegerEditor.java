package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class IntegerEditor extends TypeEditor<Integer> {
    protected IntegerEditor(SharedPreferences sharedPreferences, String key) {
        super(sharedPreferences, key);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, Integer value) {
        editor.putInt(key, value);
    }

    @Override
    protected Integer getValue(SharedPreferences sharedPreferences, String key, Integer def) {
        return sharedPreferences.getInt(key, def);
    }
}
