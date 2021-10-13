package com.sovellus.ilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.sovellus.ilo.EXTRA_TEXT";
    Button btnStart;

    /**
     * Activity for loading layout resources
     *
     *
     * @author Xanadu2112
     * @version 2010.1105
     * @since 1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {

            /**
             * Handles the onClick for the "Aloita" button. Gets the value of the main
             * EditText, creates an intent, and launches the second activity with
             * that intent.
             *
             * @param view The view (Button) that was clicked.
             */
            @Override
            public void onClick(View v) {
                Log.v("onClick", "button clicked");
                EditText editTxtName = (EditText) findViewById(R.id.editTxtName);
                String name = editTxtName.getText().toString();

                // name required
                if (!name.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra(EXTRA_TEXT, name);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Tarvitaan nimi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}