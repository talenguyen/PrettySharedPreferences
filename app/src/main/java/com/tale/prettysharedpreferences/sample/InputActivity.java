package com.tale.prettysharedpreferences.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by TALE on 10/28/2014.
 */
public class InputActivity extends ActionBarActivity {
    PrefManager prefManager;
    @InjectView(R.id.etInteger)
    EditText etInteger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(getSharedPreferences("PrefManager", MODE_PRIVATE));
        setContentView(R.layout.activity_input);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btSaveInteger)
    public void saveInteger() {
        final String integer = etInteger.getText().toString();
        try {
            final int intVal = Integer.parseInt(integer);
            prefManager.integerValue().put(intVal).apply();
            Toast.makeText(this, "Integer value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a integer", Toast.LENGTH_SHORT).show();
        }
    }

    private void startActivity(Class<DisplayActivity> targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }
}
