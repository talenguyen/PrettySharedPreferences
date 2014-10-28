package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18, manifest = "prettysharedpreferences/src/main/AndroidManifest.xml")
public class TypeEditorTest {
    private final String STRING_KEY = "string";
    @Mock
    SharedPreferences mockSharedPref;
    @Mock
    SharedPreferences.Editor mockEditor;

    private TypeEditor autoCommitTypeEditor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockSharedPref.edit()).thenReturn(mockEditor);
        autoCommitTypeEditor = new TypeEditor(new PrettySharedPreferences(mockSharedPref) {
        }, mockSharedPref, STRING_KEY) {
            @Override
            protected void putValue(SharedPreferences.Editor editor, String key, Object value) {

            }

            @Override
            protected Object getValue(SharedPreferences sharedPreferences, String key, Object def) {
                return null;
            }
        };
    }

    @Test
    public void testPutAutocommit() {
        String mockValue = "Giang";
        autoCommitTypeEditor.put(mockValue);
        verify(mockEditor, never()).apply(); // Make sure apply() is not called if not apply.
        autoCommitTypeEditor.put(mockValue).apply();
        verify(mockEditor).apply(); // Make sure apply() is called to commit data.
    }

    @Test
    public void testRemoveAutocommit() {
        autoCommitTypeEditor.remove();
        verify(mockEditor, never()).apply(); // Make sure apply() is not called if not apply.
        autoCommitTypeEditor.remove().apply();
        verify(mockEditor).apply(); // Make sure apply() is called to commit data.
    }

}
