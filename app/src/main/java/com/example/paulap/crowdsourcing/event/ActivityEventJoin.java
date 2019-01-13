package com.example.paulap.crowdsourcing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityEventJoin extends AppCompatActivity {
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
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
