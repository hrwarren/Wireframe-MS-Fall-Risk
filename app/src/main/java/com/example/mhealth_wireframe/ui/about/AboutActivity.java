package com.example.mhealth_wireframe.ui.about;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhealth_wireframe.R;
import com.example.mhealth_wireframe.ui.dashboard.DashboardAdapter;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    // At some point I'll figure out why all these logs are useful
    private static final String TAG = "MainActivity";

    // Variables
    private ArrayList<String> aboutHeaders = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);
        Log.d(TAG, "onCreate started.");

    }

    // Initializing the recycler view
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");
        RecyclerView aboutRecyclerView = findViewById(R.id.about_recyclerView);
        DashboardAdapter adapter = new DashboardAdapter(aboutHeaders, this);
        aboutRecyclerView.setAdapter(adapter);
        aboutRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

//Testing to see if github counts this as a change