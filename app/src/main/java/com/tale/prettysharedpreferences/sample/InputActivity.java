package com.tale.prettysharedpreferences.sample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.tale.prettysharedpreferences.StringEditor;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by TALE on 10/28/2014.
 */
public class InputActivity extends ActionBarActivity {
    @InjectView(R.id.etString)
    EditText etString;
    @InjectView(R.id.etBoolean)
    EditText etBoolean;
    @InjectView(R.id.etInteger)
    EditText etInteger;
    @InjectView(R.id.etLong)
    EditText etLong;
    @InjectView(R.id.etFloat)
    EditText etFloat;
    @InjectView(R.id.etDouble)
    EditText etDouble;
    @InjectView(R.id.etString1)
    EditText etString1;
    @InjectView(R.id.etString2)
    EditText etString2;

    PrefManager prefManager;

    public static class StringEditTask extends AsyncTask<String, Void, Void> {
        final StringEditor stringEditor;

        public StringEditTask(StringEditor stringEditor) {
            this.stringEditor = stringEditor;
        }

        @Override
        protected Void doInBackground(String... params) {
            SystemClock.sleep(1000);
            stringEditor.put(params[0]).apply();
            return null;
        }
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = App.get(this).getPrefManager();
        setContentView(R.layout.activity_input);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btSaveString)
    public void saveString() {
        final String stringVal = getStringValue();
        prefManager.stringValue().put(stringVal).apply();
        Toast.makeText(this, "String value is saved!", Toast.LENGTH_SHORT).show();
        startActivity(DisplayActivity.class);
    }

    @OnClick(R.id.btSaveBoolean)
    public void saveBoolean() {
        try {
            final boolean val = getBooleanValue();
            prefManager.booleanValue().put(val).apply();
            Toast.makeText(this, "Boolean value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a booleaneger", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btSaveInteger)
    public void saveInteger() {
        try {
            final int intVal = getIntValue();
            prefManager.integerValue().put(intVal).apply();
            Toast.makeText(this, "Integer value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a integer", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btSaveLong)
    public void saveLong() {
        try {
            final long longVal = getLongValue();
            prefManager.longValue().put(longVal).apply();
            Toast.makeText(this, "Long value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a integer", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btSaveFloat)
    public void saveFloat() {
        try {
            final float val = getFloatValue();
            prefManager.floatValue().put(val).apply();
            Toast.makeText(this, "Float value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a float", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btSaveDouble)
    public void saveDouble() {
        try {
            final double doubleVal = getDoubleValue();
            prefManager.doubleValue().put(doubleVal).apply();
            Toast.makeText(this, "Double value is saved!", Toast.LENGTH_SHORT).show();
            startActivity(DisplayActivity.class);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Not a double", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btClear)
    public void clearValue() {
        prefManager.clear().apply();
        Toast.makeText(this, "Value is clear!", Toast.LENGTH_SHORT).show();
        startActivity(DisplayActivity.class);
    }

    @OnClick(R.id.btSaveAll)
    public void saveAll() {
        String stringVal = getStringValue();
        boolean booleanVal = getBooleanValue();
        int intVal;
        try {
            intVal = getIntValue();
        } catch (NumberFormatException ex) {
            intVal = 0;
        }
        long longVal;
        try {
            longVal = getLongValue();
        } catch (NumberFormatException ex) {
            longVal = 0l;
        }
        float floatVal;
        try {
            floatVal = getFloatValue();
        } catch (NumberFormatException ex) {
            floatVal = 0.0f;
        }
        double doubleVal;
        try {
            doubleVal = getDoubleValue();
        } catch (NumberFormatException ex) {
            doubleVal = 0.0d;
        }
        prefManager.stringValue().put(stringVal)
                .booleanValue().put(booleanVal)
                .integerValue().put(intVal)
                .longValue().put(longVal)
                .floatValue().put(floatVal)
                .doubleValue().put(doubleVal)
                .apply();
        startActivity(DisplayActivity.class);
    }

    @OnClick(R.id.btOpenDisplay)
    public void openDisplayActivity() {
        startActivity(DisplayActivity.class);
    }

    int editingCount = 0;

    public void saveOnThread(EditText editText, String key) {
        final String value = editText.getText().toString();
        if (TextUtils.isEmpty(value)) {
            editText.setError(getString(R.string.error_empty));
            return;
        }

        new StringEditTask(prefManager.string(key)) {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                editingCount--;
                if (editingCount == 0) {
                    startActivity(DisplayActivity.class);
                }
            }
        }.execute(value);
        editingCount++;
    }

    @OnClick(R.id.btSaveStringOnThread)
    public void saveStringOnThread() {
        saveOnThread(etString1, "string1");
        saveOnThread(etString2, "string2");
    }

    private String getStringValue() {
        return etString.getText().toString();
    }

    private boolean getBooleanValue() {
        final String booleanVal = etBoolean.getText().toString();
        return Boolean.parseBoolean(booleanVal);
    }

    private int getIntValue() throws NumberFormatException {
        final String booleanVal = etInteger.getText().toString();
        return Integer.parseInt(booleanVal);
    }

    private long getLongValue() throws NumberFormatException {
        final String longVal = etLong.getText().toString();
        return Long.parseLong(longVal);
    }

    private float getFloatValue() throws NumberFormatException {
        final String floatVal = etFloat.getText().toString();
        return Float.parseFloat(floatVal);
    }

    private double getDoubleValue() throws NumberFormatException {
        final String doubleVal = etDouble.getText().toString();
        return Double.parseDouble(doubleVal);
    }

    private void startActivity(Class<DisplayActivity> targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }
}
