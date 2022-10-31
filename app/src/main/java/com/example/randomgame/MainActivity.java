package com.example.randomgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonGuess;
    private EditText editTextNumber;
    private TextView textViewScoreNumber;
    private TextView textViewMessage;
    private ProgressBar progressBarAttempt;
    private TextView textViewAttempt;
    private ListView listViewAttempts;

    private int secretNumber;
    private int counter;
    private int score;
    private List<String> listOfAttempts = new ArrayList<>();
    private int maxAttempts = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGuess = findViewById(R.id.buttonGuess);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewScoreNumber = findViewById(R.id.textViewScoreNumber);
        textViewMessage = findViewById(R.id.textViewMessage);

        progressBarAttempt = findViewById(R.id.progressBarAttempt);
        textViewAttempt = findViewById(R.id.textViewAttempt);
        listViewAttempts = findViewById(R.id.listViewAttempts);

        init();


        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int number = Integer.parseInt(editTextNumber.getText().toString());

                // check if nbr is bigger or smaller or equals secret nbr
                if (number > secretNumber) {
                    textViewMessage.setText(R.string.bigger_value);
                } else if (number < secretNumber) {
                    textViewMessage.setText(R.string.smaller_value);
                } else {
                    textViewMessage.setText(R.string.winning_message);
                    score += 5;
                    textViewScoreNumber.setText(String.valueOf(score));
                    playAgain();
                }

                counter++;
                textViewAttempt.setText(String.valueOf(counter));
                progressBarAttempt.setProgress(counter);

                if (counter == maxAttempts) {
                    playAgain();
                }
            }

        });
    }

    private void init() {
        // generate random number between 1 and 20
        secretNumber = 1 + (int) (Math.random() * 20);
        counter = 0;
        textViewAttempt.setText(String.valueOf(counter));
        progressBarAttempt.setProgress(counter);
        progressBarAttempt.setMax(maxAttempts);
        textViewMessage.setText(R.string.str_message);
    }

    private void playAgain() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Play Again ?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                init();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialog.show();
    }
}