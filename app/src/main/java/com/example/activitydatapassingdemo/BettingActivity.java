package com.example.activitydatapassingdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BettingActivity extends AppCompatActivity {
    EditText etBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting);
        etBet = (EditText) findViewById(R.id.etBet);
    }

    public void onConfirm(View view) {
        String result = "You have bet " + etBet.getText() +  " on this game";
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result",result);
        setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }
}
