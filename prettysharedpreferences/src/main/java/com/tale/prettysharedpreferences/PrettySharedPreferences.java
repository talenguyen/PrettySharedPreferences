package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by TALE on 9/11/2014.
 */
public class PrettySharedPreferences {

    private SharedPreferences sharedPreferences;
    private static Map<String, TypeEditor> typeEditorMap;

    public PrettySharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        typeEditorMap = new Hashtable<String, TypeEditor>();
    }

    public StringEditor getStringEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new StringEditor(this, sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof StringEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (StringEditor) typeEditor;
    }

    public void apply() {
        sharedPreferences.edit().apply();
    }

}
