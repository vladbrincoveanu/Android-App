package com.example.paulap.crowdsourcing.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.paulap.crowdsourcing.Adapter.EventViewHolder;
import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventAdapter extends ArrayAdapter<Event> {
    private List<Event> events;
    private Context context;
    public EventAdapter(Context context, List<Event> events) {
        super(context, 0, events);
        this.context = context;
        this.events = events;
    }

    public View getView(int	position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater	= (LayoutInflater)	context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myRow	=	(convertView	==	null)	? Objects.requireNonNull(inflater).inflate(R.layout.event_item,	parent,	false)	:	convertView;

        TextView titlu = myRow.findViewById(R.id.titleEvent);
        titlu.setText(events.get(position).getTitle());
        TextView descriere = myRow.findViewById(R.id.descriptionEvent);
        descriere.setText(events.get(position).getGoal());
        return	myRow;
    }

//    @Override
//    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
//        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        return new EventViewHolder(layoutInflater.inflate(R.layout.event_item, viewGroup, false)); // returns the view holder which is created from the view
//    }
//
//    public Event getItem(int position) {
//        return events.get(position);
//    }
//
//    @Override
//    public void onBindViewHolder(EventViewHolder viewHolder, int position) {
//        Event message = events.get(position);
//        viewHolder.title.setText(message.getTitle());
//        viewHolder.description.setText(message.getGoal());
//    }
//    public void setOnItemClickListener(EventViewHolder.ClickListener clickListener) {
//        EventViewHolder.clickListener = clickListener;
//    }


}

