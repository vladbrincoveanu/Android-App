package com.example.paulap.crowdsourcing.issue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.paulap.crowdsourcing.ActvityHome;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import com.example.paulap.crowdsourcing.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
       List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                        .setLogo(R.drawable.cs)
                        .build(),
                133);

//        AuthUI.getInstance()
//                .signOut(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
//
//        AuthUI.getInstance()
//                .delete(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 133) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Intent	intent	=	new Intent(this, ActvityHome.class);
                startActivity(intent);
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                Intent	intent	=	new Intent(this, ActvityHome.class);
                startActivity(intent);

            }
        }
    }

    public void SignInClick(View view) {

//            // Text Fields: username & pass
//        TextView username = findViewById(R.id.usernameField);
//        TextView password = findViewById(R.id.passwordField);
//        TextView status = findViewById(R.id.loginStatus);
//
//
//        if (username.getText().toString().equals("")) {
//            status.setTextColor(getResources().getColor(R.color.colorAccent));
//            status.setText(getString(R.string.empty_username));
//        }
//
//        if (password.getText().toString().equals("")) {
//            status.setTextColor(getResources().getColor(R.color.colorAccent));
//            status.setText(getString(R.string.empty_password));
//        }
//
//
//        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
//
//            // Successful login -> Redirect
//            status.setTextColor(getResources().getColor(R.color.colorPrimary));
//            status.setText(getString(R.string.successful_login));
//            Intent	intent	=	new Intent(this,ActvityHome.class);
//            startActivity(intent);
//        }
//        else {
//            status.setTextColor(getResources().getColor(R.color.colorAccent));
//            status.setText(getString(R.string.wrong_credentials));
//        }

    }
}
