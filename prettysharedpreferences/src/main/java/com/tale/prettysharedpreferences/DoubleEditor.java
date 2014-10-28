package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class DoubleEditor<T extends PrettySharedPreferences> extends TypeEditor<Double, T> {
    protected DoubleEditor(T target, SharedPreferences sharedPreferences, String key) {
        super(target, sharedPreferences, key);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, Double value) {
        editor.putLong(key, Double.doubleToRawLongBits(value));
    }

    @Override
    protected Double getValue(SharedPreferences sharedPreferences, String key, Double def) {
        if (!sharedPreferences.contains(key))
            return def;

        return Double.longBitsToDouble(sharedPreferences.getLong(key, 0l));
    }
}
