package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import junit.framework.TestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
public class StringEditorTest extends TestCase {
    private final String STRING_KEY = "string";
    @Mock
    SharedPreferences mockSharedPref;
    @Mock
    SharedPreferences.Editor mockEditor;

    private StringEditor stringEditor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        when(mockSharedPref.edit()).thenReturn(mockEditor);
        stringEditor = new StringEditor(new PrettySharedPreferences(mockSharedPref) {
        }, mockSharedPref, STRING_KEY);
    }

    public void testPutValue() {
        String mockValue = "Giang";
        stringEditor.put(mockValue).apply();
        verify(mockEditor).putString(STRING_KEY, mockValue);
        verify(mockEditor).apply();
    }

    public void testGetValue() {
        String mockValue = "Giang";
        stringEditor.getOr(mockValue);
        verify(mockSharedPref).getString(STRING_KEY, mockValue);
    }


}
