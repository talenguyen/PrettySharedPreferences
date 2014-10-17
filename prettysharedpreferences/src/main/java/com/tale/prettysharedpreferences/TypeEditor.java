package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/10/2014.
 */
public abstract class TypeEditor<ValueType> {

    SharedPreferences sharedPreferences;
    String key;

    protected TypeEditor(SharedPreferences sharedPreferences, String key) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
    }

    public void put(ValueType value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        putValue(editor, key, value);
        editor.apply();
    }

    protected abstract void putValue(SharedPreferences.Editor editor, String key, ValueType value);

    protected abstract ValueType getValue(SharedPreferences sharedPreferences, String key, ValueType def);

    public ValueType getOr(ValueType def) {
        return getValue(sharedPreferences, key, def);
    }

    public void remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

}
