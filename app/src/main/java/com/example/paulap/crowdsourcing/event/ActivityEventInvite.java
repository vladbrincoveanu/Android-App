package com.example.paulap.crowdsourcing.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import com.example.paulap.crowdsourcing.Adapter.InviteAdapter;
import com.example.paulap.crowdsourcing.Models.User;
import com.example.paulap.crowdsourcing.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityEventInvite extends AppCompatActivity {
    List<User> users;
    String title;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_invite);
        ListView listFriends = findViewById(R.id.listFriends);
        users = new ArrayList<>();

        InviteAdapter inviteAdapter = new InviteAdapter(this,users);
        User user = new User("Vlad","12345","gg.vladbrincoveanu@gmail.com",false);
        User user1 = new User("Paula","12345","paltinisanu.paula@gmail.com",false);
        User user2 = new User("Victor","12345","almasan.victor29@gmail.com",false);
        User user3 = new User("Andrei","12345","koszorus.andrei@gmail.com",false);
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user);

        inviteAdapter.notifyDataSetChanged();
        listFriends.setAdapter(inviteAdapter);

        Intent myIntent =   getIntent();
        title = myIntent.getStringExtra("title");
        description =myIntent.getStringExtra("description");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void ItemClicked(View v) {
        //code to check if this checkbox is checked!
        View parentRow = (View) v.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int i = listView.getPositionForView(parentRow);
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            this.users.get(i).setAdmin(true);
        }else{
            this.users.get(i).setAdmin(false);
        }
    }

    public void InviteAllFriends(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user:this.users) {
            stringBuilder.append(user.getEmail()).append(",");
        }
        String [] emailList = stringBuilder.toString().split(",");
        Intent i = new Intent(Intent.ACTION_SEND_MULTIPLE);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , emailList);
        i.putExtra(Intent.EXTRA_SUBJECT, "you have been invited to "+ title + " event !");
        i.putExtra(Intent.EXTRA_TEXT   , "A short description\n" + description);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ActivityEventInvite.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
        super.onBackPressed();
        finish();
    }
}
