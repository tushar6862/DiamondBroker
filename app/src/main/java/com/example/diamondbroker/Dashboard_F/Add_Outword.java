package com.example.diamondbroker.Dashboard_F;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.diamondbroker.Loan_Activity;
import com.example.diamondbroker.R;

public class Add_Outword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__outword);
        findViewById(R.id.loan_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Loan_Activity.class));
            }
        });
    }
}