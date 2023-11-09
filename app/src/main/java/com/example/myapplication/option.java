//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//
//import com.example.myapplication.activities.ChatActivity;
//
//public class option extends AppCompatActivity {
//    private Spinner myspinner;
//    public Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_option);
//
//
//        myspinner = findViewById(R.id.spinner1);
//        String[] myString = getResources().getStringArray(R.array.select);
//        ArrayAdapter adapter = new ArrayAdapter(this,
//                android.R.layout.simple_spinner_item, myString);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
//        );
//        myspinner.setAdapter(adapter);
//    }
//    public void fun(View view){
//        Intent i = new Intent(option.this, awareness.class);
//        startActivity(i);
//    }
//}