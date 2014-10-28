package com.tale.prettysharedpreferences;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 9/11/2014.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18, manifest = "prettysharedpreferences/src/main/AndroidManifest.xml")
public class TestPrettySharedPreferences {

    private static final String TEST_KEY = "string";
    SharedPref sharedPref;
    @Mock
    SharedPreferences mockSharedPref;
    @Mock
    android.content.SharedPreferences.Editor mockEditor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(mockSharedPref.edit()).thenReturn(mockEditor);
        sharedPref = new SharedPref(mockSharedPref);
    }

    @Test
    public void testGetStringEditor() {
        StringEditor stringEditor = sharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
    }

    @Test
    public void testGetStringEditorWithSameKey() {
        StringEditor stringEditor = sharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
        StringEditor stringEditor1 = sharedPref.getStringEditor(TEST_KEY);
        assertThat(stringEditor1).isEqualTo(stringEditor); // Should return same object when same key.
    }

    @Test
    public void testGetStringEditorWithSameKey2() {
        final StringEditor<SharedPref> string11 = sharedPref.string1();
        final StringEditor<SharedPref> string12 = sharedPref.string1();
        assertThat(string11).isEqualTo(string12); // same editor with same key must return same object.

        final StringEditor<SharedPref> string21 = sharedPref.string2();
        assertThat(string11).isNotEqualTo(string21); // Different editor with different key must return different object.
        final StringEditor<SharedPref> string22 = sharedPref.string2();
        assertThat(string22).isEqualTo(string21); // Ensure same editor with same key must return same object.
    }

    @Test
    public void testChainCall() {
        final SharedPref giang = sharedPref.string1().put("Giang");
        final SharedPref giang1 = sharedPref.string2().put("Giang1");
        assertThat(giang).isEqualTo(giang1);
        final SharedPref giang12 = sharedPref.string1().put("Giang").string2().put("Giang2");
        assertThat(giang).isEqualTo(giang12);
    }
}
