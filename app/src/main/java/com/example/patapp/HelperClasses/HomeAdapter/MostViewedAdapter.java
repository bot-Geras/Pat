package com.example.patapp.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patapp.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewed;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewed) {
        this.mostViewed = mostViewed;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);

        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);

        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {

        MostViewedHelperClass mostViewedHelperClass = mostViewed.get(position);

        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.review.setText(mostViewedHelperClass.getReview());

    }

    @Override
    public int getItemCount() {
        return mostViewed.size();
    }


    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, review;


        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            review = itemView.findViewById(R.id.mv_desc);
        }
    }


}
