package com.example.paulap.crowdsourcing.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.example.paulap.crowdsourcing.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ActivityCreateEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String category = paths[0];
    private Spinner spinner;
    private Date date;
    private static final String[] paths = {"Voluntariat", "Donatii", "Strangere de founduri"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        spinner = (Spinner)findViewById(R.id.categoryCreateEvent);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ActivityCreateEvent.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final CalendarView calendarView = findViewById(R.id.dateCreateEvent);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,int dayOfMonth) {
//                if(calendarView.getDate() != date[0]){
                    date = new GregorianCalendar(year, month, dayOfMonth).getTime();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent returnIntent	=	new	Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }

    public void CancelFromCreateEvent(View v) {
        Intent returnIntent	=	new	Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                this.category = paths[0];
                break;
            case 1:
                this.category = paths[1];
                break;
            case 2:
                this.category = paths[2];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public void CreateEvent(View view) {
        String titlu = ((EditText) findViewById(R.id.titleCreateEvent)).getText().toString();
        String descriere = ((EditText) findViewById(R.id.descriptionCreateEvent)).getText().toString();
        final CalendarView calendarView = findViewById(R.id.dateCreateEvent);
        Toast.makeText(getApplicationContext(), calendarView.toString(), Toast.LENGTH_LONG).show();
        final String date = this.date.toString();
        String category = this.category;

        if(titlu.matches("") || descriere.matches("")||
              date.matches("") || category.matches("")){
            Toast.makeText(this, "Every field is required before save!", Toast.LENGTH_SHORT).show();
        }else{
            Intent returnIntent	=	new	Intent();
            returnIntent.putExtra("titlu",titlu);
            returnIntent.putExtra("descriere",descriere);
            returnIntent.putExtra("date", date);
            returnIntent.putExtra("category",category);
//            returnIntent.putExtra("titlu",((TextView) findViewById(R.id.titleCreateEvent)).getText());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }
}
