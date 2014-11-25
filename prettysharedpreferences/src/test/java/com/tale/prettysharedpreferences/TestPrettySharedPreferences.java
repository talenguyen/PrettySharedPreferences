package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
public class TestPrettySharedPreferences extends TestCase {

    private static final String TEST_KEY = "string";
    SharedPref mSharedPref;
    @Mock
    SharedPreferences mMockSharedPref;
    @Mock
    android.content.SharedPreferences.Editor mMockEditor;

    @Before
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        when(mMockSharedPref.edit()).thenReturn(mMockEditor);
        mSharedPref = new SharedPref(mMockSharedPref);
    }

    @Test
    public void testGetStringEditor() throws Exception {
        StringEditor stringEditor = mSharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
    }
    @Test
    public void testGetStringEditorWithSameKey() throws Exception {
        StringEditor stringEditor = mSharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
        StringEditor stringEditor1 = mSharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor1).isEqualTo(stringEditor); // Should return same object when same key.
    }
    @Test
    public void testGetStringEditorWithSameKey2() throws Exception {
        final StringEditor<SharedPref> string11 = mSharedPref.string1();
        final StringEditor<SharedPref> string12 = mSharedPref.string1();
        assertThat(string11).isEqualTo(string12); // same editor with same key must return same object.

        final StringEditor<SharedPref> string21 = mSharedPref.string2();
        assertThat(string11).isNotEqualTo(string21); // Different editor with different key must return different object.
        final StringEditor<SharedPref> string22 = mSharedPref.string2();
        assertThat(string22).isEqualTo(string21); // Ensure same editor with same key must return same object.
    }

    @Test
    public void testChainCall() throws Exception{
        final SharedPref giang = mSharedPref.string1().put("Giang");
        final SharedPref giang1 = mSharedPref.string2().put("Giang1");
        assertThat(giang).isEqualTo(giang1);
        final SharedPref giang12 = mSharedPref.string1().put("Giang").string2().put("Giang2");
        assertThat(giang).isEqualTo(giang12);
    }

}
