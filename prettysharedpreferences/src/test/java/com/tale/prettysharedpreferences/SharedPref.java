package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

public class SharedPref extends PrettySharedPreferences {

    public SharedPref(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public StringEditor<SharedPref> string1() {
        return getStringEditor("string1");
    }

    public StringEditor<SharedPref> string2() {
        return getStringEditor("string2");
    }

}