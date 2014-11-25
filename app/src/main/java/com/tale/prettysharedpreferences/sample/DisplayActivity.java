package com.tale.prettysharedpreferences.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by TALE on 10/30/2014.
 */
public class DisplayActivity extends ActionBarActivity {
    @InjectView(R.id.tvStringVal)
    TextView tvStringVal;

    @InjectView(R.id.tvBooleanVal)
    TextView tvBooleanVal;

    @InjectView(R.id.tvIntegerVal)
    TextView tvIntegerVal;

    @InjectView(R.id.tvLongVal)
    TextView tvLongVal;

    @InjectView(R.id.tvFloatVal)
    TextView tvFloatVal;

    @InjectView(R.id.tvDoubleVal)
    TextView tvDoubleVal;

    @InjectView(R.id.tvString1Val)
    TextView tvString1Val;

    @InjectView(R.id.tvString2Val)
    TextView tvString2Val;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.inject(this);
        ButterKnife.inject(this);
        prefManager = App.get(this).getPrefManager();

        final String string = prefManager.stringValue().getOr(null);
        if (string != null) {
            tvStringVal.setText(String.valueOf(string));
        }

        final String string1 = prefManager.string("string1").getOr(null);
        if (string1 != null) {
            tvString1Val.setText(String.valueOf(string1));
        }

        final String string2 = prefManager.string("string2").getOr(null);
        if (string2 != null) {
            tvString2Val.setText(String.valueOf(string2));
        }

        final boolean booleanVal = prefManager.booleanValue().getOr(false);
        tvBooleanVal.setText(String.valueOf(booleanVal));

        final Integer integer = prefManager.integerValue().getOr(Integer.MIN_VALUE);
        if (integer != Integer.MIN_VALUE) {
            tvIntegerVal.setText(String.valueOf(integer));
        }

        final long longVal = prefManager.longValue().getOr(Long.MIN_VALUE);
        if (longVal != Long.MIN_VALUE) {
            tvLongVal.setText(String.valueOf(longVal));
        }

        final float floatVal = prefManager.floatValue().getOr(Float.MIN_VALUE);
        if (floatVal != Float.MIN_VALUE) {
            tvFloatVal.setText(String.format("%f", floatVal));
        }

        final double doubleVal = prefManager.doubleValue().getOr(Double.MIN_VALUE);
        if (doubleVal != Double.MIN_VALUE) {
            tvDoubleVal.setText(String.format("%f", doubleVal));
        }
    }
}
