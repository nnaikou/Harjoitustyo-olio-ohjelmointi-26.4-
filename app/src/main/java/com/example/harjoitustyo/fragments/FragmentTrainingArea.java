package com.example.harjoitustyo.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.harjoitustyo.BattleField;
import com.example.harjoitustyo.Home;
import com.example.harjoitustyo.Lutemon;
import com.example.harjoitustyo.R;
import com.example.harjoitustyo.TrainingArea;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrainingArea extends Fragment {

    private Home home;
    private TrainingArea trainingArea;
    private BattleField battleField;
    private ArrayList<Lutemon> lutemons = null;

    // in this arraylist we gather the lutemons that user wants to transfer
    private ArrayList<Lutemon> lutemonsToTransfer = new ArrayList<>();

    private Button buttonMove;
    private RadioGroup rgGroup;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout view = (LinearLayout) inflater.inflate(
                R.layout.fragment_train_area, container, false);

        home = Home.getHomeInstance();
        trainingArea = TrainingArea.getTrainingAreaInstance();
        battleField = BattleField.getBattleFieldInstance();

        buttonMove = view.findViewById(R.id.btnMoveLutemonsFromTrainArea);

        // lets fetch the lutemons from training area
        lutemons = trainingArea.getLutemonsInArray();

        // lets construct the checkBoxes for lutemons
        view.setOrientation(LinearLayout.VERTICAL);
        for (Lutemon lute : lutemons) {
            CheckBox cb = new CheckBox(view.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            cb.setText(lute.getName().toString() + " ("+ lute.getColor().toString() + ")");
            cb.setId(lute.getId());
            view.addView(cb);
        }

        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {

                // first lets gather all the lutemons that user has checked with checkboxes
                for(Lutemon lute : lutemons) {
                    CheckBox cb = view.findViewById(lute.getId());
                    if(cb.isChecked()) {
                        lutemonsToTransfer.add(lute);
                    }
                }

                // then lets transfer the lutemons to the destination of which radio button the user has selected
                rgGroup = view.findViewById(R.id.rgGroupTrainArea);
                switch (rgGroup.getCheckedRadioButtonId()) {
                    case R.id.rbToHomeFromTrainArea:
                        for(Lutemon lute : lutemonsToTransfer) {
                            home.addLutemonWithItsId(lute, lute.getId());

                            // and then we need also to delete the lutemon from training area
                            trainingArea.deleteLutemonById(lute.getId());
                        }
                        // lets inform the user of successful transfer
                        Toast.makeText(getContext(), "Siirto tehty", Toast.LENGTH_LONG).show();
                        getActivity().finish();
                        break;
                    case R.id.rbToBattleFieldfromTrainArea:
                        for(Lutemon lute : lutemonsToTransfer) {
                            battleField.addLutemonWithItsId(lute, lute.getId());

                            // and then we need also to delete the lutemon from training area
                            trainingArea.deleteLutemonById(lute.getId());
                        }
                        // lets inform the user of successful transfer
                        Toast.makeText(getContext(), "Siirto tehty", Toast.LENGTH_LONG).show();
                        getActivity().finish();
                        break;
                    default:
                        // lets inform the user if he/she doesnt pick a destination location via radio buttons
                        Toast.makeText(getContext(), "Et valinnut kohdetta - yritä uudelleen", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });

        return view;
    }
}