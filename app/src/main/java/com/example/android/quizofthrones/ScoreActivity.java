package com.example.android.quizofthrones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        score = i.getIntExtra("ScoreIdentifier", 0);

        Log.d("Score value", "in new activity is " + score);

        TextView setScore = (TextView) findViewById(R.id.scoreBeginningText2);
        setScore.setText("You scored " + score + "/7");

        if (score == 7) {
            Toast.makeText(this, R.string.toastAllRight, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.toastNotAllRight) + " " + score + "/7", Toast.LENGTH_SHORT).show();
        }
    }

}
