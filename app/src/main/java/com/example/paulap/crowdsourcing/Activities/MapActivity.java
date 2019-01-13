package com.example.paulap.crowdsourcing.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulap.crowdsourcing.Models.LocatedIssue;
import com.example.paulap.crowdsourcing.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {




    private GoogleMap mMap;
    private ArrayList<LocatedIssue> locatedIssues = new ArrayList<>();
    private EditText issueSummary;
    private SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        issueSummary = (EditText) findViewById(R.id.locate_issue);
        mapFragment.getMapAsync(this);

        if((ArrayList<LocatedIssue>)getIntent().getSerializableExtra("List") !=null){
           locatedIssues = (ArrayList<LocatedIssue>)getIntent().getSerializableExtra("List");
       }




    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(locatedIssues != null){
            for(LocatedIssue locatedIssue:locatedIssues){
                MarkerOptions markerOptions = new MarkerOptions();
                LatLng latLng = new LatLng(locatedIssue.getLatitude(),locatedIssue.getLongitude());

                markerOptions.position(latLng);

                markerOptions.title(locatedIssue.getSummary());
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));


                // Placing a marker on the touched position
                mMap.addMarker(markerOptions);
                System.out.println(locatedIssue.getSummary());
            }
        }

        mMap.setOnMapClickListener(new OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {

                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Setting the position for the marker
                markerOptions.position(latLng);

                // Setting the title for the marker.
                // This will be displayed on taping the marker
                markerOptions.title(issueSummary.getText().toString());

                // Clears the previously touched position
                //mMap.clear();
                LocatedIssue locatedIssue = new LocatedIssue(issueSummary.getText().toString(),latLng.longitude,latLng.latitude);

                locatedIssues.add(locatedIssue);

                // Animating to the touched position
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                // Placing a marker on the touched position
                mMap.addMarker(markerOptions);
            }
        });

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(MapActivity.this,IssueActivity.class);
        intent.putExtra("List",locatedIssues);
        startActivity(intent);
    }

}
