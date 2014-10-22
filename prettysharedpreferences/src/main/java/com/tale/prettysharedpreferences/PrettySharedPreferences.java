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
            typeEditor = new StringEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof StringEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (StringEditor) typeEditor;
    }

    public LongEditor getLongEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new LongEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof LongEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (LongEditor) typeEditor;
    }

    public IntegerEditor getIntegerEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new IntegerEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof IntegerEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (IntegerEditor) typeEditor;
    }

    public BooleanEditor getBooleanEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new BooleanEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof BooleanEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (BooleanEditor) typeEditor;
    }

    public FloatEditor getFloatEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new FloatEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof FloatEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (FloatEditor) typeEditor;
    }

    public DoubleEditor getDoubleEditor(String key) {
        TypeEditor typeEditor = typeEditorMap.get(key);
        if (typeEditor == null) {
            typeEditor = new DoubleEditor(sharedPreferences, key);
            typeEditorMap.put(key, typeEditor);
        } else if (!(typeEditor instanceof DoubleEditor)) {
            throw new IllegalArgumentException(String.format("key %s is duplicated", key));
        }

        return (DoubleEditor) typeEditor;
    }

}
