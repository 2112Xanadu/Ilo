package com.sovellus.ilo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends MainActivity {
    ArrayList<String> listOfRandomPositiveQuotes;
    TextView txtViewHeader;
    private int selector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        //TextView txtView = findViewById(R.id.quote_txtView);
        listOfRandomPositiveQuotes = new ArrayList<String>();
        listOfRandomPositiveQuotes.add("Olet upea tänään ");
        listOfRandomPositiveQuotes.add("Hyvää päivää, ");
        listOfRandomPositiveQuotes.add("Tänään on hyvä päivä ");

        txtViewHeader = (TextView) findViewById(R.id.txtViewHeader);
        //Random randomNumber = new Random();
        //selector = randomNumber.nexInt(4);
        //txtViewHeader.setText(listOfRandomPositiveQuotes.get(selector));

    }

    private void updateUI() {

    }

    public void onClickStartBreathing(View v) {
        Log.v("Breathe", "button clicked");
        //Intent intent = new Intent(this, BreatheActivity.class);
        //startActivity(intent);
    }
    public void onClickStartGratitude(View v) {
        Log.v("Breathe", "button clicked");//Intent intent = new Intent(this, GratitudelistActivity.class);
        //startActivity(intent);
    }
}