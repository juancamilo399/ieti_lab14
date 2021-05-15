package com.example.myapplicationmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddAddress extends AppCompatActivity {
    EditText nameView,descriptionView,latitudeView,longitudeView;
    public static final String RESPONSE_NAME="Location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        nameView=findViewById(R.id.name);
        descriptionView=findViewById(R.id.description);
        latitudeView=findViewById(R.id.latitude);
        longitudeView=findViewById(R.id.longitude);
    }

    public  void onSubmitClicked(View view){
        String name=nameView.getText().toString();
        String description=descriptionView.getText().toString();
        double latitude=0.0;
        double longitude=0.0;
        boolean error=false;
        if(name.isEmpty()){
            nameView.setError("Este campo no puede estar vacío");
            error=true;
        }
        if(description.isEmpty()){
            descriptionView.setError("Este campo no puede estar vacío");
            error=true;
        }
        if(latitudeView.getText().toString().isEmpty()){
            latitudeView.setError("Este campo no puede estar vacío");
            error=true;
        }
        else {
            latitude=Double.parseDouble(latitudeView.getText().toString());
        }
        if(longitudeView.getText().toString().isEmpty()){
            longitudeView.setError("Este campo no puede estar vacío");
            error=true;
        }
        else {
            longitude=Double.parseDouble(longitudeView.getText().toString());
        }
        if(!error){
            CustomLocation location= new CustomLocation(name,description,longitude,latitude);
            Intent returnIntent = new Intent();
            returnIntent.putExtra(RESPONSE_NAME,location);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }

    }
}