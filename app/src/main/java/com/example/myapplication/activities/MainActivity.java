package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.awareness;
import com.example.myapplication.databinding.ActivityMainBinding;

import com.example.myapplication.utilities.Constants;
import com.example.myapplication.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;


import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Spinner myspinner;

    Button btn1;

    private ActivityMainBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        btn1 = findViewById(R.id.btn1);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        loadUserDetails();
        getToken();
        setListeners();
        myspinner = findViewById(R.id.spinner1);
        String[] myString = getResources().getStringArray(R.array.select);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, myString);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        myspinner.setAdapter(adapter);


    }
    public void toastMsg(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
    public void displayToastMsg(View v){
        toastMsg("Thank you, we have received your problem");
    }

//        btn1.setOnClickListener(new View.OnClickListener() {
//          @Override
//            public void onClick(View v) {
//                AlertDialog.Builder reef = new AlertDialog.Builder(v.getContext());
//                reef.setTitle("Submitted");
//                reef.setMessage("Thank you, we have received your problem");
//                reef.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                   @Override
//                   public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//               });
//
//               reef.create().show();
//           }
//        });



    private void setListeners(){
        binding.imageSignOut.setOnClickListener(v -> signOut());
        binding.fabNewChat.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(),UsersActivity.class)));
    }

    private void loadUserDetails(){
       byte[] bytes = Base64.decode(preferenceManager.getString(Constants.KEY_IMAGE), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0 ,bytes.length);
        binding.imageProfile.setImageBitmap(bitmap);
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }
    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
    }

    private void updateToken(String token){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        documentReference.update(Constants.KEY_FCM_TOKEN, token)
                .addOnFailureListener(e -> showToast(" Unable to update Token"));

    }
private void signOut(){
        showToast("Signing out...");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                        );

    HashMap<String, Object> updates = new HashMap<>();
    updates.put(Constants. KEY_FCM_TOKEN, FieldValue.delete());
    documentReference.update(updates)
            .addOnSuccessListener(unused -> {
                preferenceManager.clear();
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                finish();
            })
           .addOnFailureListener(e -> showToast("Unable to sign out "));

}
//    public void fun(View view){
//        Intent i = new Intent(MainActivity.this, awareness.class);
//        startActivity(i);
//    }

}