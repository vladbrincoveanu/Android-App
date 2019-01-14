package com.example.paulap.crowdsourcing.event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.paulap.crowdsourcing.R;

public class ActivityEventJoin extends AppCompatActivity {
    boolean isShowing=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_joined);

        //  referință la  componenta Intent
        Intent myIntent =   getIntent();

        //  extragere valoare asociată cu "nume_cheie”
        TextView titlu = (TextView) findViewById(R.id.titleEventJoined);
        titlu.setText(myIntent.getStringExtra("titlu"));
        TextView pret = (TextView) findViewById(R.id.descriptionEventJoined);
        pret.setText(myIntent.getStringExtra("descriere"));
        TextView descriere = (TextView) findViewById(R.id.dateEventJoined);
        descriere.setText(myIntent.getStringExtra("data"));
        TextView category = (TextView) findViewById(R.id.categoryEventJoined);
        category.setText(myIntent.getStringExtra("category"));
        TextView location = (TextView) findViewById(R.id.locationEventJoined);
        location.setText(myIntent.getStringExtra("location"));

        final Toast toast = Toast.makeText(this, "You have joined the event",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
