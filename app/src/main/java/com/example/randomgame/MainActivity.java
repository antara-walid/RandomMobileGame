package com.example.randomgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonGuess;
    private EditText editTextNumber;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGuess = findViewById(R.id.buttonGuess);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewMessage = findViewById(R.id.textViewMessage);

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(editTextNumber.getText().toString());
                int result = number *2;
                textViewMessage.setText(String.valueOf(result ) );
            }
        });
    }
}