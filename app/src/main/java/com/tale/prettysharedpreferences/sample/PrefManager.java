package com.tale.prettysharedpreferences.sample;

import android.content.SharedPreferences;

import com.tale.prettysharedpreferences.BooleanEditor;
import com.tale.prettysharedpreferences.DoubleEditor;
import com.tale.prettysharedpreferences.FloatEditor;
import com.tale.prettysharedpreferences.IntegerEditor;
import com.tale.prettysharedpreferences.LongEditor;
import com.tale.prettysharedpreferences.PrettySharedPreferences;
import com.tale.prettysharedpreferences.StringEditor;

/**
 * Created by TALE on 10/28/2014.
 */
public class PrefManager extends PrettySharedPreferences {

    public PrefManager(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public StringEditor<PrefManager> stringValue() {
        return getStringEditor("stringValue");
    }

    public BooleanEditor<PrefManager> booleanValue() {
        return getBooleanEditor("booleanValue");
    }
    public IntegerEditor<PrefManager> integerValue() {
        return getIntegerEditor("integerValue");
    }

    public LongEditor<PrefManager> longValue() {
        return getLongEditor("longValue");
    }

    public FloatEditor<PrefManager> floatValue() {
        return getFloatEditor("floatValue");
    }

    public DoubleEditor<PrefManager> doubleValue() {
        return getDoubleEditor("doubleValue");
    }
}
