package com.sovellus.ilo;

import static com.sovellus.ilo.MainActivity.EXTRA_TEXT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    ArrayList<String> quotes = new ArrayList<String>();
    TextView txtViewHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_TEXT);

        // List of Random Positive Quotes
        quotes.add("Olet upea tänään, ");
        quotes.add("Olet ihana, ");
        quotes.add("Hyvää päivää, ");
        quotes.add("Tänään on hyvä päivä, ");
        quotes.add("Riität sellaisena kuin olet ");

        txtViewHeader = (TextView) findViewById(R.id.txtViewHeader);
        Random randomNumber = new Random();
        int selector = randomNumber.nextInt(5);
        txtViewHeader.setText(quotes.get(selector) + name + "!");
    }

    /** Going from HomeActivity to BreatheActivity */
    public void onClickStartBreathing(View v) {
        startActivity(new Intent(this, BreatheActivity.class));
    }

    /** Going from HomeActivity to GratitudeActivity */
    public void onClickStartGratitude(View v) {
        //startActivity(new Intent(this, GratitudeActivity.class));
    }
}
