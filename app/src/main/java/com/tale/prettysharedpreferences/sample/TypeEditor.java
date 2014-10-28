package com.tale.prettysharedpreferences.sample;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/10/2014.
 */
public abstract class TypeEditor<ValueType> {

    SharedPreferences sharedPreferences;
    String key;
    boolean autoCommit;

    protected TypeEditor(SharedPreferences sharedPreferences, String key, boolean autoCommit) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.autoCommit = autoCommit;
    }

    public void put(ValueType value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        putValue(editor, key, value);
        if (autoCommit) {
            editor.apply();
        }
    }

    protected abstract void putValue(SharedPreferences.Editor editor, String key, ValueType value);

    protected abstract ValueType getValue(SharedPreferences sharedPreferences, String key, ValueType def);

    public ValueType getOr(ValueType def) {
        return getValue(sharedPreferences, key, def);
    }

    public void remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        if (autoCommit) {
            editor.apply();
        }
    }

}
