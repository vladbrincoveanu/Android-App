package com.example.paulap.crowdsourcing.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.paulap.crowdsourcing.Adapter.IssueAdapter;
import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.Models.LocatedIssue;
import com.example.paulap.crowdsourcing.R;

import java.util.ArrayList;

public class IssueActivity extends AppCompatActivity {
private ArrayList<Issue> issues = new ArrayList<>();
private IssueAdapter issueAdapter;
private ArrayList<LocatedIssue> locatedIssues = new ArrayList<>();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_list_layout);
        ListView listView = (ListView) findViewById(R.id.list_view) ;
        final Issue issue = new Issue();

        this.issues = initIssues();
        this.issueAdapter = new IssueAdapter(issues,this);
        Button createIssue = findViewById(R.id.reportIssue);
        Button localizeIssue = findViewById(R.id.localizeIssue);
        Button follow = findViewById(R.id.follow_button);

        createIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent	= new Intent(IssueActivity.this,CreateIssue.class);

                startActivity(intent);

            }
        });

        localizeIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IssueActivity.this,MapActivity.class);
                intent.putExtra("List",locatedIssues);

                startActivity(intent);
            }
        });

        /*follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(FirebaseAuth.getInstance().getCurrentUser().getEmail());

            }
        });*/


        listView.setAdapter(issueAdapter);

        Issue issue1 = (Issue) getIntent().getSerializableExtra("Issue");
        if(issue1!=null){
            issues.add(issue1);
            issueAdapter.notifyDataSetChanged();
        }

        locatedIssues = (ArrayList<LocatedIssue>)getIntent().getSerializableExtra("List");


    }

    public ArrayList<Issue> initIssues(){
        ArrayList<Issue> issues = new ArrayList<>();
        issues.add(new Issue("Groapa","Multe gropi pe strazi","Sa se asfalteze","Rutier",0,R.drawable.issue1));
        issues.add(new Issue("Mijloc de transport","Autobuzele intarzie foarte multe","Mai multe autobuze","Transport",0,R.drawable.issue2));
        issues.add(new Issue("Spatii verzi","Prea putine spatii verzi","Sa se faca mai multe parcuri","Agrement",0,R.drawable.mountain));
        return issues;
    }

}
