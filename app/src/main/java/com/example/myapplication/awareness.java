package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;



import android.content.Intent;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class awareness extends AppCompatActivity {
    Button button, button2 ,button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                AlertDialog.Builder passresetDialog = new AlertDialog.Builder(v.getContext());
                passresetDialog.setTitle("Threatening");
                passresetDialog.setMessage("Someone is threating you with your photos or anything else that causes you harm");
                passresetDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                passresetDialog.create().show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder passresetDialog = new AlertDialog.Builder(v.getContext());
                passresetDialog.setTitle("Sexual assault");
                passresetDialog.setMessage("You can still ask for help rape or sexual assault if it happend to you weeks, months or even years ago");
                passresetDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                passresetDialog.create().show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder passresetDialog = new AlertDialog.Builder(v.getContext());
                passresetDialog.setTitle("Anywhere");
                passresetDialog.setMessage("You're in the workplace or anywhere and sexual harassment has occurred");
                passresetDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                passresetDialog.create().show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder passresetDialog = new AlertDialog.Builder(v.getContext());
                passresetDialog.setTitle("Violence");
                passresetDialog.setMessage("You experiencing violence physically or verblly from your family ");
                passresetDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                passresetDialog.create().show();
            }
        });


        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.awareness);

        // Perform item selected listener

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
//                    case R.id.status:
//                        startActivity(new Intent(getApplicationContext(),status.class));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.awareness:
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),contact.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}


