package com.example.prm392_group5_project_hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prm392_group5_project_hotelmanagement.connections.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Run to start App Inspection
        AppDatabase.getInstance(this).type_roomDao().getAll();
    }

}