package com.example.paulap.crowdsourcing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.home.HomeActivity;
import com.example.paulap.crowdsourcing.issue.IssueActivity;
import com.example.paulap.crowdsourcing.event.ActivityEvents;
import com.example.paulap.crowdsourcing.profile.ProfileActivity;
import com.example.paulap.crowdsourcing.report.PdfReportsActivity;
import com.example.paulap.crowdsourcing.util.AppUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActvityHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


        TextView issueTextView = findViewById(R.id.home2_issues_description);
        Issue issue = AppUtil.issueList.get(AppUtil.issueList.size()-1);
        issueTextView.setText(issue.getDescription());

        TextView eventTextView = findViewById(R.id.home2_events_description);
        Event event = AppUtil.eventList.get(AppUtil.eventList.size()-1);
        eventTextView.setText(event.getTitle() + "\n" +event.getL() + "\n" + event.getData());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Ha ha ha no settings!",Toast.LENGTH_SHORT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent	=	new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent	=	new Intent(this, IssueActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent	=	new Intent(this, ActivityEvents.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent	=	new Intent(this,PdfReportsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent intent	=	new Intent(this,ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        TextView usermail = findViewById(R.id.userMail);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        usermail.setText(user.getEmail());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void seeAllIssues(View view) {
        Intent intent	=	new Intent(this, IssueActivity.class);
        startActivity(intent);
    }

    public void seeAllEvents(View view) {
        Intent intent	=	new Intent(this, ActivityEvents.class);
        startActivity(intent);
    }
}
