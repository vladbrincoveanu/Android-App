package com.example.paulap.crowdsourcing.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.Adapters.IssueAdapter;
import com.example.paulap.crowdsourcing.R;
import com.example.paulap.crowdsourcing.drawer_menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignInClick(View view) {

        // Text Fields: username & pass
        TextView username = findViewById(R.id.usernameField);
        TextView password = findViewById(R.id.passwordField);
        TextView status = findViewById(R.id.loginStatus);


        if (username.getText().toString().equals("")) {
            status.setTextColor(getResources().getColor(R.color.colorAccent));
            status.setText(getString(R.string.empty_username));
        }

        if (password.getText().toString().equals("")) {
            status.setTextColor(getResources().getColor(R.color.colorAccent));
            status.setText(getString(R.string.empty_password));
        }


        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {

            // Successful login -> Redirect
            status.setTextColor(getResources().getColor(R.color.colorPrimary));
            status.setText(getString(R.string.successful_login));
            Intent	intent	=	new Intent(this,IssueActivity.class);
            startActivity(intent);
        }
        else {
            status.setTextColor(getResources().getColor(R.color.colorAccent));
            status.setText(getString(R.string.wrong_credentials));
        }

    }
}
