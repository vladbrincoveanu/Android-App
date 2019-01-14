package com.example.paulap.crowdsourcing.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.R;
import com.example.paulap.crowdsourcing.event.ActivityEvents;
import com.example.paulap.crowdsourcing.issue.IssueActivity;
import com.example.paulap.crowdsourcing.util.AppUtil;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView issueTextView = findViewById(R.id.home_issues_description);
        Issue issue = AppUtil.issueList.get(AppUtil.issueList.size()-1);
        issueTextView.setText(issue.getDescription());

        TextView eventTextView = findViewById(R.id.home_events_description);
        Event event = AppUtil.eventList.get(AppUtil.eventList.size()-1);
        eventTextView.setText(event.getTitle() + "\n" +event.getL() + "\n" + event.getData());
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
