package com.sovellus.ilo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BreatheActivity extends AppCompatActivity {
    private TextView statusText;
    CountDownTimer countDownTimer;
    Toast t;
    View outerCircleView, innerCircleView;
    private int holdDuration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);

        statusText = findViewById(R.id.txt_status);
        //innerCircleView = findViewById(R.id.view_circle_inner);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // How long we want to the animation to run
        countDownTimer = new CountDownTimer(3000, 100) {  // 3s, will be running onTick function for 30x
            @Override
            public void onTick(long l) {
                if (t != null) t.cancel();
                //t = Toast.makeText(getApplicationContext(), "" + (l/1000+1), Toast.LENGTH_SHORT); // How much time is left
                //t.show();
            }

            @Override
            public void onFinish() {
                if (t != null) t.cancel();
                //t = Toast.makeText(getApplicationContext(), "Countdown complete", Toast.LENGTH_SHORT); // How much time is left
                //t.show();
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}