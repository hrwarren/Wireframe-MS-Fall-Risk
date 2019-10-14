package com.example.mhealth_wireframe.ui.about;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhealth_wireframe.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.AboutViewHolder> {
    private static final String TAG = "AboutAdapter";

    // The list of strings for the headers, as well as the context
    private ArrayList<String> mAboutHeaders;
    private Context mContext;

    // Populate that array, I think??
    public AboutAdapter(ArrayList<String> aboutHeaders, Context context) {
        mAboutHeaders = aboutHeaders;
        mContext = context;
    }



    @NonNull
    @Override
    // Create and inflate the About page's viewholder
    public AboutAdapter.AboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_headercard, parent, false);
        //View headerView = LayoutInflater.inflate(R.layout.about_headercard, parent, false);

        AboutViewHolder holder = new AboutViewHolder(view); //possibly AboutViewHolder(headerView)
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AboutAdapter.AboutViewHolder holder, final int position) {

        // Create a log for debugging
        Log.d(TAG, "onMindViewHolder: called.");

        holder.aboutHeader.setText(mAboutHeaders.get(position));

        // Set the listener to detect when a header is clicked on
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mAboutHeaders.get(position));

                Toast.makeText(mContext, mAboutHeaders.get(position), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mAboutHeaders.size();
    }

    public class AboutViewHolder extends RecyclerView.ViewHolder {

        TextView aboutHeader;
        LinearLayout parentLayout;


        public AboutViewHolder(View itemView) {
            super(itemView);
            aboutHeader = itemView.findViewById(R.id.about_header);
            parentLayout = itemView.findViewById(R.id.about_parentlayout);


        }
    }

}

