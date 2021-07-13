package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {
    private EditText user_input;
    private EditText user_input1;
    private Button Button;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_input = findViewById(R.id.user_input);
        Button = findViewById(R.id.Button);
        result = findViewById(R.id.result);
        user_input1 = findViewById(R.id.user_input1);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_input.getText().toString().trim().equals("")&&user_input1.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, "Введите хотя бы 2 варианта", Toast.LENGTH_LONG).show();
                else{
                    //creating method for randomly choosing one of the user inputs
                    Random rand = new Random();
                    EditText[] userInputs = {user_input, user_input1};
                    int randomAnswer = rand.nextInt(userInputs.length);
                    result = userInputs[randomAnswer];
                    result.setText(result.getText().toString().trim());

                    Log.v("EditText", result.getText().toString());
            }}
        });
    }
    private class getResult extends AsyncTask<String, String, TextView> {

        @Override
        protected TextView doInBackground(String... strings) {

            return result;
        }
    }
    }