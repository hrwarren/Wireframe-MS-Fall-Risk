package com.example.mhealth_wireframe.ui.about;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhealth_wireframe.R;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    // At some point I'll figure out why all these logs are useful
    private static final String TAG = "MainActivityNav";

    // Variables
    private ArrayList<String> aboutHeaders = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);
        Log.d(TAG, "onCreate started.");

        initHeaderNames();

    }

    private void initHeaderNames() {
        aboutHeaders.add("@string/falling_biomechanics");
        aboutHeaders.add("@string/multiple_sclerosis");
        aboutHeaders.add("@string/about_the_app");
        aboutHeaders.add("@string/msense_group");
    }



    // Initializing the recycler view
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");
        RecyclerView aboutRecyclerView = findViewById(R.id.about_recyclerView);
        AboutAdapter adapter = new AboutAdapter(aboutHeaders, this);
        aboutRecyclerView.setAdapter(adapter);
        aboutRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}