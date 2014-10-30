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

    /**
     * Set a value in preferences, to be written back once apply() are called.
     *
     * @param value The value to be stored.
     * @return Returns a reference to the same {@link com.tale.prettysharedpreferences.PrettySharedPreferences}
     * object, so you can chain put calls together.
     */
    public T put(ValueType value) {
        if (target.editing == null) {
            target.editing = sharedPreferences.edit();
        }
        putValue(target.editing, key, value);
        return target;
    }

    protected abstract void putValue(SharedPreferences.Editor editor, String key, ValueType value);

    protected abstract ValueType getValue(SharedPreferences sharedPreferences, String key, ValueType def);

    /**
     * Retrieve a value from the preferences.
     *
     * @param def Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     */
    public ValueType getOr(ValueType def) {
        return getValue(sharedPreferences, key, def);
    }

    /**
     * Mark in the editor that a preference value should be removed, which will be done in the
     * actual preferences once commit() is called. Note that when committing back to the
     * preferences, all removals are done first, regardless of whether you called remove before
     * or after put methods on this editor.
     * @return Returns a reference to the same
     * {@link com.tale.prettysharedpreferences.PrettySharedPreferences} object, so you can chain
     * put calls together.
     */
    public T remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        return target;
    }

}
