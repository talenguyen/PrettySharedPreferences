package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/10/2014.
 */
class StringEditorBK<Provider> extends TypeEditorBK<Provider, String> {

    protected StringEditorBK(Provider provider, SharedPreferences sharedPreferences, String key, boolean autoCommit) {
        super(provider, sharedPreferences, key, autoCommit);
    }

    @Override
    protected Object newInstance(Provider provider, SharedPreferences sharedPreferences, String key, boolean autoCommit) {
        return new StringEditorBK<Provider>(provider, sharedPreferences, key, autoCommit);
    }

    @Override
    protected String get(SharedPreferences sharedPreferences, String key) {
        return getOr(sharedPreferences, key, null);
    }

    @Override
    protected String getOr(SharedPreferences sharedPreferences, String key, String def) {
        return sharedPreferences.getString(key, def);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, String value) {
        editor.putString(key, value);
    }
}

