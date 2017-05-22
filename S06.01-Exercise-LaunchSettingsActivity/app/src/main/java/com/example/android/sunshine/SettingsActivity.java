package com.example.android.sunshine;

import android.app.ActionBar;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by Oluwatimilehin on 22/05/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    ComponentName activity;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        activity = getCallingActivity();
        Log.d("Settings", activity + " ");
        ActionBar actionBar = this.getActionBar();

        if (actionBar != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Settings", activity + " ");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
