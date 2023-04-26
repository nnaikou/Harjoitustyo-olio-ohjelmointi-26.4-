package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TrainingAreaActivity extends AppCompatActivity {

    private Button buttonTrain;
    private TextView trainInfoText;
    private LinearLayout checkBoxLayout;
    private Lutemon luteToTrain;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        buttonTrain = findViewById(R.id.btnToTrain);
        trainInfoText = findViewById(R.id.txtTrainInfo);

        checkBoxLayout = (LinearLayout) findViewById(R.id.layoutForChecks2);

        // lets construct the checkBoxes for lutemons located in the training area
        for(Lutemon lute : TrainingArea.getTrainingAreaInstance().getLutemonsInArray()) {
            CheckBox cb = new CheckBox(this);
            cb.setId(lute.getId());
            cb.setText(lute.getName()+" ("+lute.getColor()+")");
            LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            checkParams.setMargins(0,-10,0,-10);
            checkBoxLayout.addView(cb, checkParams);
        }

        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = 0; // lets use this variable to check how many checkboxes are checked

                // lets solve which checkBox is checked
                for(Lutemon lute : TrainingArea.getTrainingAreaInstance().getLutemonsInArray()) {
                    CheckBox cb = findViewById(lute.getId());
                    if (cb.isChecked()) {
                        luteToTrain = lute;
                        i++;
                    }
                }
                if (i == 1) {
                    luteToTrain.changeExperience(1); // lets increase the experience of lutemon by one due his training

                    trainInfoText.setText(luteToTrain.getName()+" ("+luteToTrain.getColor()+") treenasi ja kasvatti kokemustaan yhdellä.\n\n" +
                            "Ennen:\nkokemus: "+(luteToTrain.getExperience()-1)+", hyökkäys: "+(luteToTrain.getAttack()-1)+"\n\n"+
                            "Nyt:\nkokemus: "+luteToTrain.getExperience()+", hyökkäys: "+luteToTrain.getAttack());

                } else { // lets inform the user if he/she picks wrong amount of checkBoxes/fighters
                    Toast.makeText(TrainingAreaActivity.this, "Valitsit kelvottoman määrän taistelijoita - yritä uudelleen", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}