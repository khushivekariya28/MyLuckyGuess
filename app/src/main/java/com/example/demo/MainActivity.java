package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText user_name;
    Button wishMeLuckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.nameEditTextView);
        wishMeLuckBtn = findViewById(R.id.wishButton);

        wishMeLuckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_name.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter your Name.", Toast.LENGTH_SHORT).show();
                } else {

                    int luckyNumber = new Random().nextInt(101);

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("USERNAME", name);
                    intent.putExtra("LUCKY_NUMBER", luckyNumber);
                    startActivity(intent);
                }
            }
        });

    }
}