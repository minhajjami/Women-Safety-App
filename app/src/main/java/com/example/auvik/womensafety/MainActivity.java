package com.example.auvik.womensafety;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.SupportActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperUser databaseHelperUser = new DatabaseHelperUser(this);

    int MY_PERMISSIONS_REQUEST_SEND_SMS=1;
    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    PendingIntent sentPI, deliveredPI;
    BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;
    String email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras!=null)
            email2= extras.getString("fahim");

        Button police = (Button)findViewById(R.id.policebtn);

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PoliceActivity.class));
            }
        });


        Button tips = (Button) findViewById(R.id.tipsbtn);

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, TipsActivity.class));

            }


        });







        Button alert = (Button)findViewById(R.id.alertbtn);

        final String myMsg = databaseHelperUser.searchmessage(email2);
        final String number1 = databaseHelperUser.searchemergencymob(email2);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg(number1,myMsg);
            }
        });
    }

    public void sendMsg(String number1, String myMsg){
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number1,null,myMsg,null,null);
        Toast.makeText(MainActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
    }
}
