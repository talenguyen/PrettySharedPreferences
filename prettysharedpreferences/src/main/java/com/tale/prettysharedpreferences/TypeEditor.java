package com.tale.prettysharedpreferences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

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
     * @return Returns a reference to the same object, so you can chain put calls together.
     */
    public T put(ValueType value) {
        putValue(target.editor(), key, value);
        return target;
    }

    /**
     * Set and apply value immediately in preferences. Calls apply() right after put.
     *
     * @param value The value to be saved.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void save(ValueType value) {
        putValue(target.editor(), key, value);
        target.apply();
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
     * @return Returns a reference to the same object, so you can chain put calls together.
     */
    public T remove() {
        target.editor().remove(key);
        return target;
    }

}
