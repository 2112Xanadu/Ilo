package com.sovellus.ilo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class EditorActivity extends AppCompatActivity {
    EditText editText;
    TextView timeoutput;
    SharedPreferences sharedPreferences;

    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        editText = findViewById(R.id.editText);

        // Fetch data that is passed from MainActivity
        // Accessing the data using key and value
        Intent intent = getIntent();
        itemId = intent.getIntExtra("itemId", -1); //default value: -1 (in case of intent error)

        if (itemId != -1) {
            editText.setText(GratitudeActivity.gratitudeList.get(itemId));

        } else {
            GratitudeActivity.gratitudeList.add("");
            itemId = GratitudeActivity.gratitudeList.size() - 1;
            GratitudeActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                GratitudeActivity.gratitudeList.set(itemId, String.valueOf(charSequence));
                GratitudeActivity.arrayAdapter.notifyDataSetChanged();
                /** Creating Object of SharedPreferences to store data in the phone */
                sharedPreferences = getApplicationContext().getSharedPreferences("Text saved", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(GratitudeActivity.gratitudeList);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}