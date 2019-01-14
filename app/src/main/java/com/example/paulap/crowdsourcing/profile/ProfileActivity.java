package com.example.paulap.crowdsourcing.profile;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private static String username = "username";
    private static String password = "password";
    private static String emailAddress = "emailAddress@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText usernameEdit = findViewById(R.id.profile_username_edit);
        EditText passwordEdit = findViewById(R.id.profile_password_edit);
        EditText emailEdit = findViewById(R.id.profile_email_edit);
        TextView usernameTextView = findViewById(R.id.profile_username);

//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            usernameEdit.setText(currentUser.getDisplayName());
//            emailEdit.setText(currentUser.getEmail());
//        } else {
//        }

        usernameEdit.setText(username);
        passwordEdit.setText(password);
        emailEdit.setText(emailAddress);
        usernameTextView.setText(username);

        CheckBox newsletterCheckBox = findViewById(R.id.profile_newsletter_checkbox);


        newsletterCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked ) {
                    final AlertDialog.Builder	myDialog =	new	AlertDialog.Builder(ProfileActivity.this);
                    myDialog
                            .setTitle("NEWSLETTER")
                            .setMessage("You have been successfully subscribed to our newsletter!")
                            .setPositiveButton("OK",	new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                } else {
                    final AlertDialog.Builder	myDialog =	new	AlertDialog.Builder(ProfileActivity.this);
                    myDialog
                            .setTitle("NEWSLETTER")
                            .setMessage("You have been successfully unsubscribed to our newsletter!")
                            .setPositiveButton("OK",	new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }

            }
        });

    }

    public void onSave(View view) {

        EditText usernameEdit = findViewById(R.id.profile_username_edit);
        EditText passwordEdit = findViewById(R.id.profile_password_edit);
        EditText emailEdit = findViewById(R.id.profile_email_edit);
        TextView usernameTextView = findViewById(R.id.profile_username);

        username = usernameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        emailAddress = emailEdit.getText().toString();

        usernameEdit.setText(usernameEdit.getText());
        passwordEdit.setText(passwordEdit.getText());
        emailEdit.setText(emailEdit.getText());
        usernameTextView.setText(usernameEdit.getText());

        this.finish();
    }
}