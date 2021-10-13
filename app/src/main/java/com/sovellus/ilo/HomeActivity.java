package com.sovellus.ilo;

import static com.sovellus.ilo.MainActivity.EXTRA_TEXT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Activity for loading layout resources
 *
 * @author Grete
 * @version 2010.1105
 * @since 1.0
 */
public class HomeActivity extends AppCompatActivity {
    ArrayList<String> quotes = new ArrayList<String>();
    TextView txtViewHeader;

    /**
     * Initialize the activity.
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* initialize all the view variables */
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        txtViewHeader = (TextView) findViewById(R.id.txtViewHeader);

        /* Instanciating an array list: List of Random Positive Quotes */
        quotes.add("Olet upea tänään, ");
        quotes.add("Olet ihana, ");
        quotes.add("Hyvää päivää, ");
        quotes.add("Tänään on hyvä päivä, ");
        quotes.add("Riität sellaisena kuin olet ");

        /* displays random line of text and adds user's name to end of the line */
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
        startActivity(new Intent(this, GratitudeActivity.class));
    }
}
