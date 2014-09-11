package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18, manifest = "sharepref/src/main/AndroidManifest.xml")
public class StringEditorTest {
    private final String STRING_KEY = "string";
    @Mock
    SharedPreferences mockSharedPref;
    @Mock
    SharedPreferences.Editor mockEditor;

    private StringEditor stringEditor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockSharedPref.edit()).thenReturn(mockEditor);
        stringEditor = new StringEditor(mockSharedPref, STRING_KEY, true);
    }

    @Test
    public void testPutValue() {
        String mockValue = "Giang";
        stringEditor.put(mockValue);
        verify(mockEditor).putString(STRING_KEY, mockValue);
        verify(mockEditor).apply(); // Make sure apply() is called to commit data.
    }

    @Test
    public void testGetValue() {
        String mockValue = "Giang";
        stringEditor.getOr(mockValue);
        verify(mockSharedPref).getString(STRING_KEY, mockValue);
    }


}
