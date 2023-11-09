package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.activities.ChatActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class location extends AppCompatActivity  implements
        OnMapReadyCallback {
    public Button option ;
    boolean isPermissionGranted;
    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
//        option = (Button) findViewById(R.id.option1);
//        option.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(location.this, option.class);
//                startActivity(i);
//            }
//        });
        checkMyPermission();
        if(isPermissionGranted){
            SupportMapFragment supportMapFragment =
                    (SupportMapFragment)
                            getSupportFragmentManager().findFragmentById(R.id.fragment);
            supportMapFragment.getMapAsync(this);
        }
        }





    private void checkMyPermission() {

        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse
                                                    permissionGrantedResponse) {
                Toast.makeText(location.this , "pewmission granted"
                        , Toast.LENGTH_SHORT).show();
                        isPermissionGranted = true;
            }
            @Override
            public void onPermissionDenied(PermissionDeniedResponse
                                                   permissionDeniedResponse) {
                Intent intent = new Intent();

                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri =Uri.fromParts("package",
                        getPackageName(),"");
                intent.setData(uri);
                startActivity(intent);
            }
            @Override
            public void
            onPermissionRationaleShouldBeShown(PermissionRequest
                                                       permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMyLocationEnabled(true);

    }
   public void option(View view){
        Intent i = new Intent(location.this, contact.class);
        startActivity(i);
    }

}