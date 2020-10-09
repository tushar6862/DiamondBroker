package com.example.diamondbroker;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class registration_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.regi_toolbar));
        findViewById(R.id.btn_Registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(registration_activity.this,login_activity.class);
                startActivity(mainIntent);
            }
        });
    }
}