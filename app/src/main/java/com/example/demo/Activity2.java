package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Activity2 extends AppCompatActivity {

    TextView usernameTV, numberTV;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        usernameTV = findViewById(R.id.usernameText);
        numberTV = findViewById(R.id.numberTextView);
        shareBtn = findViewById(R.id.shareButton);


        String username = getIntent().getStringExtra("USERNAME");
        int luckyNumber = getIntent().getIntExtra("LUCKY_NUMBER", 0);

        usernameTV.setText(username + "'s Lucky Number");
        numberTV.setText(luckyNumber + "");


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent();

               intent.setAction(Intent.ACTION_SEND);
               String shareMsg = username + "'s lucky Number is " + luckyNumber;
               intent.putExtra(Intent.EXTRA_TEXT,
                        shareMsg);
               intent.setType("text/plain");


               String title = username + " lucky number is: " + luckyNumber;

               startActivity(Intent.createChooser(intent, title));


            }
        });
    }
}