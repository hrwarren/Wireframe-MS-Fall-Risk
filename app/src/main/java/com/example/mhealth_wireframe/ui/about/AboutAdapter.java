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
        AboutViewHolder holder = new AboutViewHolder(view);
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













//
//private class AboutAdapter extends RecyclerView.Adapter {
//    List<AboutHeaderItems> list = Collections.emptyList();
//    Context context;
//
//
//    public AboutAdapter(List<AboutHeaderItems> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public AboutViewHolder
//    onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        //Inflate the layout
//        View textView = inflater.inflate(R.layout.about_headercard, parent, false);
//
//        AboutViewHolder viewHolder = new AboutViewHolder(textView);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AboutViewHolder viewHolder, int position) {
//        viewHolder.aboutHeader.setText(list.get(position).header);
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    // Should there be an override notation here?
//    private List<AboutHeaderItems> getData() {
//        List<AboutHeaderItems> list = new ArrayList<>();
//        list.add(new AboutHeaderItems("@strings/falling_biomechanics"));
//        list.add(new AboutHeaderItems("@strings/msense_group"));
//        return list;
//
//    }
//}
