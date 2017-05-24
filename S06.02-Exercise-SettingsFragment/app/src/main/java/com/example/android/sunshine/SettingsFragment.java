package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by Oluwatimilehin on 24/05/2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences preferences = getPreferenceScreen().getSharedPreferences();
        int prefsCount = getPreferenceScreen().getPreferenceCount();

        for (int i = 0; i < prefsCount; i++) {
            android.support.v7.preference.Preference preference = getPreferenceScreen().getPreference(i);
            String value = preferences.getString(preference.getKey(), "");
            setPreferenceSummary(preference, value);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences preferences = getPreferenceScreen().getSharedPreferences();
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = getPreferenceScreen().getSharedPreferences();
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    private void setPreferenceSummary(android.support.v7.preference.Preference preference, Object
            value) {
        SharedPreferences preferences = getPreferenceScreen().getSharedPreferences();
        if (!(preference instanceof CheckBoxPreference)) {
            if (!(preference instanceof ListPreference)) {
                preference.setSummary(preferences.getString(preference.getKey(), ""));
            }
            if(preference instanceof  ListPreference){
                ListPreference listPreference = (ListPreference) preference;
                String stringValue = value.toString();
                preference.setSummary(listPreference.getEntries()[listPreference.findIndexOfValue
                        (stringValue)]);
            }

        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        android.support.v7.preference.Preference preference = findPreference(key);
        String value = sharedPreferences.getString(key, "");
        setPreferenceSummary(preference,value);

    }
}
