package com.example.paulap.crowdsourcing.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.R;

import java.io.Serializable;
import java.util.ArrayList;

public class IssueAdapter extends BaseAdapter implements Serializable {
    private ArrayList<Issue> issues;
    private Context context;

    public IssueAdapter(ArrayList<Issue> issues,Context context){
        this.issues = issues;
        this.context = context;
    }
    @Override
    public int getCount() {
        return issues.size();
    }

    @Override
    public Object getItem(int position) {
        return issues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Issue issue = (Issue) getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.issue,parent,false);
        }

        TextView issueTitle = (TextView) convertView.findViewById(R.id.issue_title);
        TextView issueCategory = (TextView) convertView.findViewById(R.id.issue_cateogry);
        TextView issueDescription = (TextView) convertView.findViewById(R.id.issue_description);
        ImageView issueImage = (ImageView) convertView.findViewById(R.id.issue_image);
        TextView issueSolution = (TextView) convertView.findViewById(R.id.issue_solution) ;
        TextView issueVotes = (TextView) convertView.findViewById(R.id.votes);

        Button upvotes = (Button) convertView.findViewById(R.id.upvote_button);
        Button downvote = (Button) convertView.findViewById(R.id.downvote_button);

        upvotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issue.setVotes(issue.getVotes() + 1);
                notifyDataSetChanged();
            }
        });

        downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issue.setVotes(issue.getVotes() - 1);
                notifyDataSetChanged();
            }
        });

        issueTitle.setText(issue.getTitle());
        issueCategory.setText(issue.getCategory());
        issueDescription.setText(issue.getDescription());
        issueImage.setImageResource(issue.getImgRes());
        issueSolution.setText(issue.getSolution());
        issueVotes.setText(Integer.toString(issue.getVotes()));

        return convertView;
    }
}
