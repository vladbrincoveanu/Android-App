package com.example.paulap.crowdsourcing.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.R;

public class CreateIssue extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_issue);


        final Spinner categories = (Spinner) findViewById(R.id.newIssue_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.issue_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories.setAdapter(adapter);
        Button submitButton = findViewById(R.id.submit_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        final EditText issueTitle = findViewById(R.id.newIssue_title);
        final EditText issueSolution = findViewById(R.id.newIssue_solution);
        final EditText issueDescription = findViewById(R.id.newIssue_description);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateIssue.this,IssueActivity.class);
                String category = categories.getSelectedItem().toString();

                intent.putExtra("Issue",new Issue(issueTitle.getText().toString(),issueDescription.getText().toString(),issueSolution.getText().toString(),category,0,R.drawable.mountain));
                startActivity(intent);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateIssue.this,IssueActivity.class);
                startActivity(intent);
            }
        });




    }
}
