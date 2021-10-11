package com.sovellus.ilo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class GratitudeActivity extends AppCompatActivity {
    static ArrayList<String> gratitudeList = new ArrayList<String>();
    static ArrayAdapter arrayAdapter;
    SharedPreferences sharedPreferences;
    AlertDialog dialog;

    // Menu Options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.add_item: /** If Lisaa was selected */
                // Going from MainActivity to EditorActivity
                startActivity(new Intent(getApplicationContext(), EditorActivity.class));
                return true;
            case R.id.delete_all: /** If Poista kaikki was selected */
                // To delete the data from the App
                dialog = new AlertDialog.Builder(GratitudeActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Huomio")
                        .setMessage("Oletko varma, että haluat poistaa kaiken listalta?")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                gratitudeList.clear();
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.sovellus.listaosuus", Activity.MODE_PRIVATE);
                                HashSet<String> set = new HashSet(GratitudeActivity.gratitudeList);
                                sharedPreferences.edit().putStringSet("notes", set).apply();
                                Toast.makeText(GratitudeActivity.this, "Poistaminen onnistui", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("En", null).show();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ListView listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(GratitudeActivity.this, android.R.layout.simple_list_item_1, gratitudeList);
        listView.setAdapter(arrayAdapter);

        sharedPreferences = getApplicationContext().getSharedPreferences("listdata", Activity.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("gratitudeList", null);
        //if (set == null) {
        //notes.add("Olen kiitollinen ");
        //} else {
        //notes = new ArrayList(set);
        //}

        /** When the user taps one item on the list */
        /** Going from GratitudeActivity to EditorActivity */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("onItemClick", "(" + i + ")");
                Intent intent = new Intent(getApplicationContext(), EditorActivity.class);
                intent.putExtra("itemId", i);
                startActivity(intent);

                //Toast.makeText(getApplicationContext(), "Clicked: " + i, Toast.LENGTH_LONG).show();
            }
        });

        /** When the user long clicks one item on the list */
        /** Alert */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int item = i;
                // To delete the data from the App
                dialog = new AlertDialog.Builder(GratitudeActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Huomio")
                        .setMessage("Oletko varma, että haluat poistaa tämän listalta?")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                gratitudeList.remove(item);
                                arrayAdapter.notifyDataSetChanged();
                                sharedPreferences = getApplicationContext().getSharedPreferences("com.sovellus.ilo", Activity.MODE_PRIVATE);
                                HashSet<String> set = new HashSet(GratitudeActivity.gratitudeList);
                                sharedPreferences.edit().putStringSet("gratitudeList", set).apply();
                                Toast.makeText(GratitudeActivity.this, "Poistaminen onnistui", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("En", null).show();
                return true;
            }
        });

        Button addBtn = findViewById(R.id.addBtn);
        // When the user taps the Lisaa button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Going from GratitudeActivity to EditorActivity */
                startActivity(new Intent(GratitudeActivity.this, EditorActivity.class));
            }
        });
    }
}
