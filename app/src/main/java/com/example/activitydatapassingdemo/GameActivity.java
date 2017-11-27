package com.example.activitydatapassingdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Button btnRoll;
    private TextView tvGameRules, tvGameNumber, tvResult;
    Random random;
    private int winCount = 0, loseCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvGameRules = findViewById(R.id.tvRules);
        tvGameNumber = findViewById(R.id.tvGameNumber);
        tvResult = findViewById(R.id.tvResult);
        random = new Random();
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("playerName");
        tvGameRules.setText(name + "! " + tvGameRules.getText());
    }

    public void onQuit(View view) {
        String result = "Thank you for playing. " + "You won " + winCount + " times and lost " + loseCount + " times.";
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result",result);
        setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void onRoll(View view) {
        int gameRandom = random.nextInt(11) + 2;
        tvGameNumber.setText("Game Random:" + gameRandom);
        int playerRandom = random.nextInt(11) + 2;
        if (playerRandom > gameRandom) {
            winCount++;
            tvResult.setText("Your number is " + playerRandom + ". You Win!  \nWin count: " + winCount + " Lose count: " + loseCount);
        } else if (playerRandom < gameRandom) {
            loseCount++;
            tvResult.setText("Your number is " + playerRandom + ". You Lose  \nWin count: " + winCount + " Lose count: " + loseCount);
        } else {
            tvResult.setText("Your number is " + playerRandom + ". It's a Tie  \nWin count: " + winCount + " Lose count: " + loseCount);
        }
    }
}
