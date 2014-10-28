package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/10/2014.
 */
public abstract class TypeEditor<ValueType, T extends PrettySharedPreferences> {

    private final T target;
    private final SharedPreferences sharedPreferences;
    private final String key;

    protected TypeEditor(T target, SharedPreferences sharedPreferences, String key) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.target = target;
    }

    public T put(ValueType value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        putValue(editor, key, value);
        return target;
    }

    protected abstract void putValue(SharedPreferences.Editor editor, String key, ValueType value);

    protected abstract ValueType getValue(SharedPreferences sharedPreferences, String key, ValueType def);

    public ValueType getOr(ValueType def) {
        return getValue(sharedPreferences, key, def);
    }

    public T remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        return target;
    }

}
