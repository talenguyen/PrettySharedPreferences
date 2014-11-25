package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
public class TypeEditorTest extends TestCase {
    private final String STRING_KEY = "string";
    @Mock
    SharedPreferences mMockSharedPref;
    @Mock
    SharedPreferences.Editor mMockEditor;

    private TypeEditor mTypeEditor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        when(mMockSharedPref.edit()).thenReturn(mMockEditor);
        mTypeEditor = new TypeEditor(new PrettySharedPreferences(mMockSharedPref) {
        }, mMockSharedPref, STRING_KEY) {
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
    public void testPutApply() {
        String mockValue = "Giang";
        mTypeEditor.put(mockValue);
        verify(mMockEditor, never()).apply(); // Make sure apply() is not called if not apply.
        mTypeEditor.put(mockValue).apply();
        verify(mMockEditor).apply(); // Make sure apply() is called to commit data.
    }

    @Test
    public void testPutCommit() {
        String mockValue = "Giang";
        mTypeEditor.put(mockValue);
        verify(mMockEditor, never()).commit(); // Make sure commit() is not called if not apply.
        mTypeEditor.put(mockValue).commit();
        verify(mMockEditor).commit(); // Make sure commit() is called to commit data.
    }

    @Test
    public void testRemoveApply() {
        mTypeEditor.remove();
        verify(mMockEditor, never()).apply(); // Make sure apply() is not called if not apply.
        mTypeEditor.remove().apply();
        verify(mMockEditor).apply(); // Make sure apply() is called to commit data.
    }

    @Test
    public void testRemoveCommit() {
        mTypeEditor.remove();
        verify(mMockEditor, never()).commit(); // Make sure commit() is not called if not apply.
        mTypeEditor.remove().commit();
        verify(mMockEditor).commit(); // Make sure commit() is called to commit data.
    }

}
