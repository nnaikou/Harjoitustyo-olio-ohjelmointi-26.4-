package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText lutemonName;
    private Home home;
    private Lutemon lutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        lutemonName = findViewById(R.id.editTextLutemonName);
        home = Home.getHomeInstance();
    }

    public void CreateLutemon(View view) {
        RadioGroup rgLutemon = findViewById(R.id.rgLutemon);

        switch (rgLutemon.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                lutemon = new White(R.drawable.white_dragon); // including the image for white lutemon
                break;
            case R.id.rbPink:
                lutemon = new Pink(R.drawable.pink_monster); // including the image for pink lutemon
                break;
            case R.id.rbGreen:
                lutemon = new Green(R.drawable.green_monster); // including the image for green lutemon
                break;
            case R.id.rbOrange:
                lutemon = new Orange(R.drawable.orange_monsterpng); // including the image for orange lutemon
                break;
            case R.id.rbBlack:
                lutemon = new Black(R.drawable.black_creature); // including the image for black lutemon
                break;
        }

        // lets put this in if clause in case of the user doesnt pick any of the radiobuttons,
        // in case like that, the adding button only throws info text to the screen
        if (lutemon != null) {
            lutemon.setName(lutemonName.getText().toString());
            home.addLutemon(lutemon); // new created lutemons always go to home
        } else {
            Toast.makeText(this, "Et valinnut, mikä lutemoni luodaan - yritä uudelleen", Toast.LENGTH_LONG).show();
        }

    }
}