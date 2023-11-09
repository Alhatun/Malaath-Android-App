//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import  java.util.*;
//import androidx.appcompat.app.AppCompatActivity;
//
//
//
//import android.os.Bundle;
//import android.widget.HorizontalScrollView;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class status extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//
//
//
//
//
//
//
//
//            // State defaults to NOT_COMPLETED stepList.add(new Step("Amet"));
//            // State defaults to NOT_COMPLETED horizontalStepView.setSteps(stepList);
//
//
//        // Initialize and assign variable
//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
//
//        // Set Home selected
//        bottomNavigationView.setSelectedItemId(R.id.status);
//
//        // Perform item selected listener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch(item.getItemId())
//                {
//                    case R.id.awareness:
//                        startActivity(new Intent(getApplicationContext(),awareness.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.status:
//                        return true;
//                    case R.id.contact:
//                        startActivity(new Intent(getApplicationContext(),contact.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
//}
//    }


