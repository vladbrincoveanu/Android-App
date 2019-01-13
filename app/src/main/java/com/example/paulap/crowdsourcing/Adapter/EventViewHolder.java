package com.example.paulap.crowdsourcing.Adapter;

import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.paulap.crowdsourcing.R;

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static ClickListener clickListener;
    public TextView title;
    public TextView description;
    public TextView dateview;
    public Location location;
    public TextView category;

    public EventViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.titleEvent);
        description = itemView.findViewById(R.id.descriptionEvent);
    }

    @Override
    public void onClick(View v) {
        clickListener.onItemClick(getAdapterPosition(), v);
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
