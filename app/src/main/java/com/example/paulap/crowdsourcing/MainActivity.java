package paulap.calatour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.paulap.crowdsourcing.R;

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

        System.out.println("[DEBUG] Has been clicked");

//        username.setText("");
//        password.setText("");

        System.out.println("[DEBUG] User: " + username.getText());

        if (username.getText().toString().equals("")) {
            System.out.println("[DEBUG] User is emtpy ");
        }


        if (username.getText().toString() == "") {
            System.out.println("[DEBUG] User if empty");
            status.setTextColor(getResources().getColor(R.color.colorAccent));
            status.setText(getString(R.string.empty_username));
        }

        System.out.println("[DEBUG] Password: " + password.getText());
        if (password.getText().toString() == "") {
            System.out.println("[DEBUG] Password if empty");
            status.setTextColor(getResources().getColor(R.color.colorAccent));
            status.setText(getString(R.string.empty_password));
        }

        System.out.println("[DEBUG] Has checked if are not empty");

        if (username.getText().toString() == "user" && password.getText().toString() == "pass") {
            status.setTextColor(getResources().getColor(R.color.colorPrimary));
            status.setText(getString(R.string.successful_login));
        }

    }
}
