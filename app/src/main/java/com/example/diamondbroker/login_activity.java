package com.example.diamondbroker;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.login_toolbar));
        findViewById(R.id.btn_Registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(login_activity.this,registration_activity.class);
                startActivity(mainIntent);
            }
        });
        findViewById(R.id.btn_Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(login_activity.this,Dashboard_activity.class);
                startActivity(mainIntent);
            }
        });
    }
}