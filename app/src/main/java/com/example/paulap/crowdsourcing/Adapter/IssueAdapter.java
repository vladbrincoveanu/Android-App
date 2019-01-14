package com.example.paulap.crowdsourcing.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulap.crowdsourcing.Models.Issue;
import com.example.paulap.crowdsourcing.Models.User;
import com.example.paulap.crowdsourcing.R;
import com.example.paulap.crowdsourcing.Service.GMailSender;
import com.example.paulap.crowdsourcing.Service.SendEmailTask;
import com.example.paulap.crowdsourcing.event.ActivityEventInvite;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class IssueAdapter extends BaseAdapter implements Serializable {
    private ArrayList<Issue> issues;
    private Context context;
    private ArrayList<String> followers = new ArrayList<>();
    private GMailSender gMailSender;

    private String issueTitle;

    public IssueAdapter(ArrayList<Issue> issues,Context context){
        this.issues = issues;
        this.context = context;
        this.gMailSender = new GMailSender("sd.proiect.3.2@gmail.com","proiect_3");
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

        final TextView issueTitle = (TextView) convertView.findViewById(R.id.issue_title);
        TextView issueCategory = (TextView) convertView.findViewById(R.id.issue_cateogry);
        TextView issueDescription = (TextView) convertView.findViewById(R.id.issue_description);
        ImageView issueImage = (ImageView) convertView.findViewById(R.id.issue_image);
        TextView issueSolution = (TextView) convertView.findViewById(R.id.issue_solution) ;
        TextView issueVotes = (TextView) convertView.findViewById(R.id.votes);

        Button upvotes = (Button) convertView.findViewById(R.id.upvote_button);
        Button downvote = (Button) convertView.findViewById(R.id.downvote_button);
        final Button follow = (Button) convertView.findViewById(R.id.follow_button);

        this.issueTitle = issueTitle.getText().toString();

        upvotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issue.setVotes(issue.getVotes() + 1);
                NotifyUsers(getArrayList(issueTitle.getText().toString()));
                notifyDataSetChanged();
            }
        });

        downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issue.setVotes(issue.getVotes() - 1);
                NotifyUsers(getArrayList(issueTitle.getText().toString()));
                notifyDataSetChanged();
            }
        });

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(follow.getText().equals("FOLLOW")) {

                    if (getArrayList(issueTitle.getText().toString()) == null) {
                        followers.add(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                    } else {
                        followers = getArrayList(issueTitle.getText().toString());
                        if(followers.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                            followers.add(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                        }
                    }
                    follow.setText("UNFOLLOW");
                }
                else{

                        followers = getArrayList(issueTitle.getText().toString());
                        followers.remove(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                        follow.setText("FOLLOW");
                }
                saveArrayList(followers,issueTitle.getText().toString());



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
    private void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }
   private ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void NotifyUsers(ArrayList<String> followers) {
        if(followers!=null) {
            if(followers.size() > 0) {
                for (String mail : followers) {
                    new SendEmailTask(mail, "An issue changed", this.issueTitle).execute();
                }
            }
        }

    }
}
