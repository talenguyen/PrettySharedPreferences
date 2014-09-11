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

/**
 * Created by TALE on 9/11/2014.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18, manifest = "sharepref/src/main/AndroidManifest.xml")
public class TestPrettySharedPreferences {

    private static final String TEST_KEY = "string";
    PrettySharedPreferences prettySharedPreferences;
    @Mock
    SharedPreferences mockSharedPref;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        prettySharedPreferences = new PrettySharedPreferences(mockSharedPref);
    }

    @Test
    public void testGetStringEditor() {
        StringEditor stringEditor = prettySharedPreferences.getStringEditor(TEST_KEY, true);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
    }

    @Test
    public void testGetStringEditorWithSameKey() {
        StringEditor stringEditor = prettySharedPreferences.getStringEditor(TEST_KEY, true);
        assertThat(stringEditor).isInstanceOf(StringEditor.class);
        StringEditor stringEditor1 = prettySharedPreferences.getStringEditor(TEST_KEY, true);
        assertThat(stringEditor1).isEqualTo(stringEditor); // Should return same object when same key.
    }
}
