package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.activities.ChatActivity;
import com.example.myapplication.activities.SignInActivity;
import com.example.myapplication.activities.UsersActivity;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.utilities.Constants;
import com.example.myapplication.utilities.PreferenceManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class contact extends AppCompatActivity {
    ImageButton health;
    ImageButton police;
    ImageButton vul;
    private PreferenceManager preferenceManager;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);



        //setListeners();



        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.contact);

        health = (ImageButton) findViewById(R.id.health);
        health.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 937));
                startActivity(i);}

        });

        police = (ImageButton) findViewById(R.id.police);
        police.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 999));
                startActivity(i);
            }
        });
        vul = (ImageButton) findViewById(R.id.vul);
        vul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1919));
                startActivity(i);
            }
        });
// Initialize and assign variable
        BottomNavigationView bottomNavigationView1=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.contact);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
//                    case R.id.status:
//                        startActivity(new Intent(getApplicationContext(),status.class));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.awareness:
                        startActivity(new Intent(getApplicationContext(),awareness.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contact:
                        return true;

                }
                return false;
            }
        });
    }
    public void map(View view){
        Intent i = new Intent(contact.this, location.class);
        startActivity(i);
    }


    }

