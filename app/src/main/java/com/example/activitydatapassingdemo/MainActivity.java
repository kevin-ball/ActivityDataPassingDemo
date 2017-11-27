package com.example.activitydatapassingdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private TextView tvResult;
    static final int GAME_REQUEST_CODE = 1;
    static final int BET_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResultDisplay);
    }

    public void onClickPlay(View view) {
        Intent gameIntent = new Intent(MainActivity.this,GameActivity.class);
        gameIntent.putExtra("playerName",etName.getText().toString());
        startActivityForResult(gameIntent, GAME_REQUEST_CODE);
    }

    public void onClickBet(View view) {
        Intent gameIntent = new Intent(MainActivity.this,BettingActivity.class);
        gameIntent.putExtra("playerName",etName.getText().toString());
        startActivityForResult(gameIntent, BET_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                tvResult.setText(data.getStringExtra("result"));
                tvResult.setTextColor(Color.RED);
            }
        }
        if (requestCode == BET_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                tvResult.setText(data.getStringExtra("result"));
                tvResult.setTextColor(Color.BLUE);
            }
        }
    }

}
