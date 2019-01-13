package com.example.paulap.crowdsourcing.event;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.paulap.crowdsourcing.Models.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.example.paulap.crowdsourcing.Adapter.EventAdapter;
import com.example.paulap.crowdsourcing.R;

public class ActivityEvents extends AppCompatActivity {
    EventAdapter eventAdapter;
    List<Event> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_events);

        ListView msgRecyclerView = findViewById(R.id.recView);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        msgRecyclerView.setLayoutManager(linearLayoutManager);

        events = new ArrayList<>();
        eventAdapter = new EventAdapter(this, events);
        Event msg = new Event("Strangere fonduri", new Date().toString(), new Location(""), "Se vor colecta fundri ptr copii nevoiasi", "Fonduri");
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);

        eventAdapter.notifyDataSetChanged();
        msgRecyclerView.setAdapter(eventAdapter);
//        registerForContextMenu(msgRecyclerView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected void onActivityResult(int	requestCode,	int	resultCode,	Intent	data)
    {
        if(resultCode	==	Activity.RESULT_OK){
            String	title = data.getStringExtra("titlu");
            String	descriere = data.getStringExtra("descriere");
            String	date = data.getStringExtra("date");
            String	category = data.getStringExtra("category");
            Event event = new Event(title,date,new Location(""),descriere,category);
            events.add(event);
            eventAdapter.notifyDataSetChanged();
        }else if(resultCode == Activity.RESULT_CANCELED){

        }
    }

    public void Join(View v) {
        final Intent intent = new Intent(ActivityEvents.this, ActivityEventJoin.class);
        View parentRow = (View) v.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int i = listView.getPositionForView(parentRow);
        intent.putExtra("titlu", eventAdapter.getItem(i).getTitle());
        intent.putExtra("descriere", eventAdapter.getItem(i).getGoal());
        intent.putExtra("data", eventAdapter.getItem(i).getData());
        intent.putExtra("location", eventAdapter.getItem(i).getL());
        intent.putExtra("category",eventAdapter.getItem(i).getCategory());
        startActivityForResult(intent,i);
    }

    public void Invite(View v) {
        View parentRow = (View) v.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int i = listView.getPositionForView(parentRow);
        final Intent intent = new Intent(ActivityEvents.this,ActivityEventInvite.class);
        intent.putExtra("title",eventAdapter.getItem(i).getTitle());
        intent.putExtra("description",eventAdapter.getItem(i).getGoal());
        startActivityForResult(intent,2);

    }

    public void CreateEvent(View view) {
        final Intent intent = new Intent(ActivityEvents.this,ActivityCreateEvent.class);
        startActivityForResult(intent,1);
    }
}