package com.example.auvik.womensafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    DatabaseHelperUser helperUser = new DatabaseHelperUser(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button SignUp = (Button)findViewById(R.id.SignUp1);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup1(v);
            }
        });
    }

    public void signup1(View view) {
        EditText username1 = (EditText) findViewById(R.id.TFusername);
        EditText email1 = (EditText) findViewById(R.id.TFemail);
        EditText pass1 = (EditText) findViewById(R.id.TFpass);
        EditText pass2 = (EditText) findViewById(R.id.TFConpass);
        EditText mobileno1 = (EditText) findViewById(R.id.TFMobileNo);
        EditText emmobileno1 = (EditText) findViewById(R.id.TFEmMobileNo);
        EditText message1 = (EditText) findViewById(R.id.TFMessage);
        EditText birthdate1 = (EditText) findViewById(R.id.TFBirthDate);

        String usernamest = username1.getText().toString();
        String emailst = email1.getText().toString();
        String pass1st = pass1.getText().toString();
        String pass2st = pass2.getText().toString();
        String mobilenost = mobileno1.getText().toString();
        String emmobilenost = emmobileno1.getText().toString();
        String messagest = message1.getText().toString();
        String birthdatest = birthdate1.getText().toString();

        if (!pass1st.equals(pass2st)) {
            Toast pass = Toast.makeText(SignUpActivity.this, "Password don't match!!", Toast.LENGTH_SHORT);
            pass.show();
        } else {

            User c = new User();
            c.setUsername(usernamest);
            c.setEmail(emailst);
            c.setPassword(pass1st);
            c.setMobileno(mobilenost);
            c.setEmmobileno(emmobilenost);
            c.setMessage(messagest);
            c.setBirthdate(birthdatest);

            helperUser.insertUser(c);
            Intent intent=new Intent(SignUpActivity.this,LogInActivity.class);
            startActivity(intent);
        }

    }
}
