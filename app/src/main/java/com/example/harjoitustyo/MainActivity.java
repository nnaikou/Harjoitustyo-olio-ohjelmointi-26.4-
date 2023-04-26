package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SavingAndLoading savingAndLoading = new SavingAndLoading();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddLutemonActivity(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemonActivity(View view) {
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToTransferLutemonsActivity(View view) {
        Intent intent = new Intent(this, TransferLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToTrainingAreaActivity(View view) {
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);
    }
    public void switchToBattleFieldActivity(View view) {
        Intent intent = new Intent(this, BattleFieldActivity.class);
        startActivity(intent);
    }

    // method to save all lutemons
    public void saveLutemons(View view) {
        savingAndLoading.saveLutemons(this);
    }

    // method to load lutemons to home
    public void loadLutemons(View view) {
        savingAndLoading.loadLutemons(this);
    }
}