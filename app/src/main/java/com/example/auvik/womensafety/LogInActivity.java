package com.example.auvik.womensafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    DatabaseHelperUser helperUser = new DatabaseHelperUser(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button LogIn = (Button)findViewById(R.id.LogIn);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
        Button SignUp = (Button)findViewById(R.id.SignUp);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup(v);
            }
        });
    }

    public void login(View view){
        EditText a= (EditText)findViewById(R.id.ETemail);
        String st = a.getText().toString();

        EditText b = (EditText)findViewById(R.id.ETpass);
        String stpass = b.getText().toString();

        String password = helperUser.searchPass(st);
        if(stpass.equals(password)){
            Intent intent = new Intent(LogInActivity.this,MainActivity.class);
            intent.putExtra("fahim",st);
            startActivity(intent);
        }
        else{
            Toast temp = Toast.makeText(LogInActivity.this,"Email and Password don't match!!",Toast.LENGTH_SHORT);
            temp.show();
        }
    }
    public void signup(View view){
        Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}
