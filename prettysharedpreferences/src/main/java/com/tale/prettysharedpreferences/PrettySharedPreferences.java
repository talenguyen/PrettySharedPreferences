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

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.StringEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     *
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.StringEditor} object to be store or retrieve
     * a {@link java.lang.String} value.
     */
    protected StringEditor getStringEditor(String key) {
        try {
            final StringEditor stringEditor = (StringEditor) getInCache(key);
            return stringEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.IntegerEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     *
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.IntegerEditor} object to be store or retrieve
     * a {@link java.lang.Integer} value.
     */
    protected IntegerEditor getIntegerEditor(String key) {
        try {
            final IntegerEditor integerEditor = (IntegerEditor) getInCache(key);
            return integerEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.BooleanEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.BooleanEditor} object to be store or retrieve
     * a {@link java.lang.Boolean} value.
     */
    protected BooleanEditor getBooleanEditor(String key) {
        try {
            final BooleanEditor booleanEditor = (BooleanEditor) getInCache(key);
            return booleanEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.LongEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.LongEditor} object to be store or retrieve
     * a {@link java.lang.Long} value.
     */
    protected LongEditor getLongEditor(String key) {
        try {
            final LongEditor longEditor = (LongEditor) getInCache(key);
            return longEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.FloatEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.FloatEditor} object to be store or retrieve
     * a {@link java.lang.Float} value.
     */
    protected FloatEditor getFloatEditor(String key) {
        try {
            final FloatEditor floatEditor = (FloatEditor) getInCache(key);
            return floatEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to get a {@link com.tale.prettysharedpreferences.DoubleEditor} object for the specific
     * key. <code>NOTE:</code> There is a unique {@link com.tale.prettysharedpreferences.TypeEditor}
     * object for a unique key.
     * @param key The name of the preference.
     * @return {@link com.tale.prettysharedpreferences.DoubleEditor} object to be store or retrieve
     * a {@link java.lang.Double} value.
     */
    protected DoubleEditor getDoubleEditor(String key) {
        try {
            final DoubleEditor doubleEditor = (DoubleEditor) getInCache(key);
            return doubleEditor;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", key));
        }

    }

    /**
     * Call to commit the change.
     * @see android.content.SharedPreferences.Editor#apply()
     */
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
