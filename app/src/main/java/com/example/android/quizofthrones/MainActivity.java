package com.example.android.quizofthrones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public int score = 0;
    private ProgressBar pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this makes sure, that the computer knows which progressbar we mean.
        pg = (ProgressBar) findViewById(R.id.progressBar);

    }

    // increases the ProgressBar by 1; max-value is 10.
    public void adjustProgressBar(View view){
        pg.incrementProgressBy(1);
    }

    public void scoreQuestions(View view) {

        //RadioButtons
        getQ1();
        getQ2();
        getQ5();
        getQ7();

        //CheckBoxes
        getQ3();
        getQ6();

        //EditText
        getQ4();

        //first we send an intent to the new activity with our score-int
        Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
        i.putExtra("ScoreIdentifier", score);
        startActivity(i);

        //now we set score-int back to the default value, so that the score doesn't add up when going back to this activity
        score = 0;

    }

    // these methods check whether the RadioButtons were clicked correctly or not (in which case nothing happens)
    private void getQ1() {
        RadioButton rB = (RadioButton) (findViewById(R.id.Q1A1));
        Boolean buttonTrue = rB.isChecked();
        if (buttonTrue) {
            score++;
        }
    }

    private void getQ2() {
        RadioButton rB = (RadioButton) (findViewById(R.id.Q2A1));
        Boolean buttonTrue = rB.isChecked();
        if (buttonTrue) {
            score++;
        }
    }

    private void getQ5() {
        RadioButton rB = (RadioButton) (findViewById(R.id.Q5A3));
        Boolean buttonTrue = rB.isChecked();
        if (buttonTrue) {
            score++;
        }
    }

    private void getQ7() {
        RadioButton rB = (RadioButton) (findViewById(R.id.Q7A2));
        Boolean buttonTrue = rB.isChecked();
        if (buttonTrue) {
            score++;
        }
    }

    //these methods check whether the CheckBoxes were clicked correctly
    private void getQ3() {
        CheckBox rB1 = (CheckBox) (findViewById(R.id.Q3A1));
        Boolean button1True = rB1.isChecked();

        CheckBox rB2 = (CheckBox) (findViewById(R.id.Q3A2));
        Boolean button2True = rB2.isChecked();

        CheckBox rB3 = (CheckBox) (findViewById(R.id.Q3A3));
        Boolean button3True = rB3.isChecked();

        CheckBox rB4 = (CheckBox) (findViewById(R.id.Q3A4));
        Boolean button4True = rB4.isChecked();

        CheckBox rB5 = (CheckBox) (findViewById(R.id.Q3A5));
        Boolean button5True = rB5.isChecked();

        if (!button1True && button2True && button3True && button4True && !button5True) {
            score++;
        }
    }

    private void getQ6() {
        CheckBox rB1 = (CheckBox) (findViewById(R.id.Q6A1));
        Boolean button1True = rB1.isChecked();

        CheckBox rB2 = (CheckBox) (findViewById(R.id.Q6A2));
        Boolean button2True = rB2.isChecked();

        CheckBox rB3 = (CheckBox) (findViewById(R.id.Q6A3));
        Boolean button3True = rB3.isChecked();

        CheckBox rB4 = (CheckBox) (findViewById(R.id.Q6A4));
        Boolean button4True = rB4.isChecked();

        if (!button1True && !button2True && button3True && button4True) {
            score++;
        }
    }

    //these method checks whether the input in the EditText is valid
    private void getQ4() {
        EditText answer = (EditText) findViewById(R.id.Q4A1);

        if (answer.getText().toString().contains("Westeros")) {
            score++;
        }
    }
}
