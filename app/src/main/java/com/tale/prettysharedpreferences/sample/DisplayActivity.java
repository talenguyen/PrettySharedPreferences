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
    @InjectView(R.id.tvIntegerVal)
    TextView tvIntegerVal;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.inject(this);
        prefManager = new PrefManager(getSharedPreferences("PrefManager", MODE_PRIVATE));
        final Integer integer = prefManager.integerValue().getOr(Integer.MIN_VALUE);
        if (integer != Integer.MIN_VALUE) {
            tvIntegerVal.setText(String.valueOf(integer));
        }
    }
}
