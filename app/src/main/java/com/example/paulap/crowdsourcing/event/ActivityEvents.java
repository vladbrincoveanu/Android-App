package com.example.paulap.crowdsourcing;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.paulap.crowdsourcing.Adapter.EventViewHolder;
import com.example.paulap.crowdsourcing.Models.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.example.paulap.crowdsourcing.Adapter.EventAdapter;

public class ActivityEvents extends AppCompatActivity {
    EventAdapter eventAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_events);

        ListView msgRecyclerView = findViewById(R.id.recView);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        msgRecyclerView.setLayoutManager(linearLayoutManager);

        final List<Event> events = new ArrayList<>();
        Event msg = new Event("Strangere fonduri", new Date(), new Location(""), "Se vor colecta fundri ptr copii nevoiasi", "Fonduri");
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        events.add(msg);
        eventAdapter = new EventAdapter(this, events);



//        msgRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.i("debug", "item click: " + String.valueOf(i));
//                Toast.makeText(ActivityEvents.this,
//                        "Item in position " + String.valueOf(i) + " clicked", Toast.LENGTH_LONG).show();
//                intent.putExtra("titlu", eventAdapter.getItem(i).getTitle());
//                intent.putExtra("descriere", eventAdapter.getItem(i).getGoal());
//                intent.putExtra("data", eventAdapter.getItem(i).getData().toString());
//                intent.putExtra("location", eventAdapter.getItem(i).getL());
//                intent.putExtra("category",eventAdapter.getItem(i).getCategory());
//                startActivityForResult(intent,i);
//                }
//            });

        eventAdapter.notifyDataSetChanged();
        msgRecyclerView.setAdapter(eventAdapter);
        registerForContextMenu(msgRecyclerView);
    }

    public	void	onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo	menuInfo) {

        super.onCreateContextMenu(menu,	v,	menuInfo);
        //	verificăm	dacă	meniul	este	creat	pentru	lista	vizată
        if	(v.getId()==R.id.recView)
        {
            //	identificăm	elementul	selectat	din	listă
            AdapterView.AdapterContextMenuInfo	info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            int index = info.position;
            EventAdapter adapter = (EventAdapter) ((ListView) v).getAdapter();
            menu.setHeaderTitle(Objects.requireNonNull(adapter.getItem(index)).getTitle());
            //	încărcăm	structura	vizuală	a	meniului
            getMenuInflater().inflate(R.menu.menu,	menu);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void Join(View v) {
        final Intent intent = new Intent(ActivityEvents.this,ActivityEventJoin.class);
        View parentRow = (View) v.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int i = listView.getPositionForView(parentRow);
        Toast.makeText(ActivityEvents.this,
              "Item in position " + String.valueOf(i) + " clicked", Toast.LENGTH_LONG).show();
        intent.putExtra("titlu", eventAdapter.getItem(i).getTitle());
        intent.putExtra("descriere", eventAdapter.getItem(i).getGoal());
        intent.putExtra("data", eventAdapter.getItem(i).getData().toString());
        intent.putExtra("location", eventAdapter.getItem(i).getL());
        intent.putExtra("category",eventAdapter.getItem(i).getCategory());
        startActivityForResult(intent,i);
    }

    public void Invite(View view) {
        final Intent intent = new Intent(ActivityEvents.this,ActivityEventInvite.class);
        
    }
}