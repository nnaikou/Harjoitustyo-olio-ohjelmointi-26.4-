package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BattleFieldActivity extends AppCompatActivity {

    private Button buttonFight;

    // to these two lutemons we gather the two lutemons that the user wants to pick to fight
    private Lutemon Lute1;
    private Lutemon Lute2;
    private TextView fightText;
    private Lutemon attackingLute;
    private Lutemon defendingLute;
    private Lutemon winner;
    private Lutemon loser;
    private LinearLayout checkBoxLayout;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        buttonFight = findViewById(R.id.btnToFight);
        fightText = findViewById(R.id.txtFightText);

        // lets make the textview scrollable
        fightText.setMovementMethod(new ScrollingMovementMethod());

        checkBoxLayout = (LinearLayout) findViewById(R.id.layoutForChecks);

        // lets construct the checkBoxes for lutemons located in the battlefield
        for(Lutemon lute : BattleField.getBattleFieldInstance().getLutemonsInArray()) {
            CheckBox cb = new CheckBox(this);
            cb.setId(lute.getId());
            cb.setText(lute.getName()+" ("+lute.getColor()+")");
            LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            checkParams.setMargins(0,-12,0,-14);
            checkBoxLayout.addView(cb, checkParams);
        }

        // listener for the button that starts the fight
        buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0; // this variable is used to check that exactly two lutemons are checked

                // lets solve which checkBoxes are chosen
                for(Lutemon lute : BattleField.getBattleFieldInstance().getLutemonsInArray()) {
                    CheckBox cb = findViewById(lute.getId());
                    if(cb.isChecked()) {
                        if (i == 0) {
                            Lute1 = lute;
                        } else if (i == 1) {
                            Lute2 = lute;
                        }
                        i++;
                    }
                }
                if (i != 2) {
                    // lets inform the user if he/she picks wrong amount of checkBoxes/fighters
                    Toast.makeText(view.getContext(), "Valitsit kelvottoman määrän taistelijoita - yritä uudelleen", Toast.LENGTH_LONG).show();
                } else {
                    j = 0; // with this variable we define which lutemon's turn it is to attack based on even and odd

                    fightText.append("Taistelu alkakoon!\n\n");

                    // fighting loop:
                    while(true) {
                        if (j%2 == 0) { // Lute1's turn:
                            attackingLute = Lute1;
                            defendingLute = Lute2;

                        } else { // Lute2's turn:
                            attackingLute = Lute2;
                            defendingLute = Lute1;
                        }

                        // printing stats of both lutemons
                        fightText.append("ATT: "+attackingLute.getColor()+"("+attackingLute.getName()+") hyö: "+attackingLute.getAttack()+"; puo: "+
                                attackingLute.getDefense()+"; kok: "+attackingLute.getExperience()+"; elämä: "+attackingLute.getHealth()+"/"+attackingLute.getMaxHealth()+"\n");
                        fightText.append("DEF: "+defendingLute.getColor()+"("+defendingLute.getName()+") hyö: "+defendingLute.getAttack()+"; puo: "+
                                defendingLute.getDefense()+"; kok: "+defendingLute.getExperience()+"; elämä: "+defendingLute.getHealth()+"/"+defendingLute.getMaxHealth()+"\n");

                        // attack time
                        fightText.append(attackingLute.getColor()+"("+attackingLute.getName()+") hyökkää "+defendingLute.getColor()+"("+defendingLute.getName()+"):n kimppuun.\n");
                        defendingLute.defense(attackingLute.getAttackValue());
                        if (defendingLute.getHealth() <= 0) {
                            fightText.append(defendingLute.getColor()+"("+defendingLute.getName()+") saa surmansa.\n");
                            winner = attackingLute;
                            loser = defendingLute;
                            break;
                        } else {
                            fightText.append(defendingLute.getColor()+"("+defendingLute.getName()+") selviää hyökkäyksestä.\n\n");
                        }

                        j++; // changing turn
                    }

                    fightText.append("Taistelu on ohi.\n");

                    // generating health back and adding experience to winner
                    winner.setHealth(winner.getMaxHealth());
                    winner.changeExperience(1);

                    // adding one losed fight to loser and returning it to initial values
                    loser.setLosedFights(loser.getLosedFights() + 1);
                    loser.changeExperience(-(loser.getExperience())); // returning experience to zero
                    loser.setHealth(loser.getMaxHealth());

                }
            }
        });



    }
}