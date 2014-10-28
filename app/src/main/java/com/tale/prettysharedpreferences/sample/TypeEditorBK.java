package com.tale.prettysharedpreferences.sample;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/10/2014.
 */
public abstract class TypeEditorBK<Provider, ValueType> implements Cloneable {

    private final String key;
    private final boolean autoCommit;
    private final SharedPreferences sharedPreferences;
    private final Provider provider;

    protected TypeEditorBK(Provider provider, SharedPreferences sharedPreferences, String key, boolean autoCommit) {
        this.provider = provider;
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.autoCommit = autoCommit;
    }

    public Provider put(ValueType value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        putValue(editor, key, value);
        if (autoCommit) {
            apply(editor);
        }
        return provider;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return newInstance(provider, sharedPreferences, key, autoCommit);
    }

    public ValueType get() {
        return get(sharedPreferences, key);
    }

    public ValueType getOr(ValueType def) {
        return getOr(sharedPreferences, key, def);
    }

    protected abstract Object newInstance(Provider provider, SharedPreferences sharedPreferences, String key, boolean autoCommit);

    protected abstract ValueType get(SharedPreferences sharedPreferences, String key);

    protected abstract ValueType getOr(SharedPreferences sharedPreferences, String key, ValueType def);

    protected abstract void putValue(SharedPreferences.Editor editor, String key, ValueType value);

    public void remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        if (autoCommit) {
            apply(editor);
        }
    }

    void apply(SharedPreferences.Editor editor) {
        editor.apply();
    }
}
