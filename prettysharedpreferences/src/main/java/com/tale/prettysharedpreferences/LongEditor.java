package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

/**
 * Created by TALE on 9/11/2014.
 */
public class LongEditor extends TypeEditor<Long> {
    protected LongEditor(SharedPreferences sharedPreferences, String key, boolean autoCommit) {
        super(sharedPreferences, key, autoCommit);
    }

    @Override
    protected void putValue(SharedPreferences.Editor editor, String key, Long value) {
        editor.putLong(key, value);
    }

    @Override
    protected Long getValue(SharedPreferences sharedPreferences, String key, Long def) {
        return sharedPreferences.getLong(key, def);
    }
}
