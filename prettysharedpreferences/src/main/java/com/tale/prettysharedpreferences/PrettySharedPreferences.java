package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by TALE on 9/11/2014.
 */
public abstract class PrettySharedPreferences {

    private SharedPreferences sharedPreferences;
    private static final Map<String, TypeEditor> TYPE_EDITOR_MAP = new Hashtable<String, TypeEditor>();

    public PrettySharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public StringEditor getStringEditor(String key) {
        try {
            final StringEditor stringEditor = (StringEditor) getInCache(key);
            return stringEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    public void apply() {
        sharedPreferences.edit().apply();
    }

    private TypeEditor getInCache(String key) throws ClassCastException {
        TypeEditor typeEditor = TYPE_EDITOR_MAP.get(key);
        if (typeEditor == null) {
            typeEditor = new StringEditor(this, sharedPreferences, key);
            TYPE_EDITOR_MAP.put(key, typeEditor);
        }

        return typeEditor;
    }



}
