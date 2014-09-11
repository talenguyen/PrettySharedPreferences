package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by TALE on 9/11/2014.
 */
public class PrettySharedPreferences {

    private SharedPreferences sharedPreferences;
    private Map<String, TypeEditor> typeEditorMap;

    public PrettySharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        typeEditorMap = new Hashtable<String, TypeEditor>();
    }

    public StringEditor getStringEditor(String key, boolean autoCommit) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new StringEditor(sharedPreferences, key, autoCommit);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof StringEditor)) {
            throw new IllegalArgumentException(String.format("key is already exists for other %s type", typeEditor.getClass().getName()));
        }

        return (StringEditor) typeEditor;
    }

    public LongEditor getLongEditor(String key, boolean autoCommit) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new LongEditor(sharedPreferences, key, autoCommit);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof LongEditor)) {
            throw new IllegalArgumentException(String.format("key is already exists for other %s type", typeEditor.getClass().getName()));
        }

        return (LongEditor) typeEditor;
    }

}
