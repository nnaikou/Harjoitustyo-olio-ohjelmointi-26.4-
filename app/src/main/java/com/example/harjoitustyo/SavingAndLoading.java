package com.example.harjoitustyo;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SavingAndLoading {
    private HashMap<Integer, Lutemon> hashToFileTransfer = new HashMap<>();

    public SavingAndLoading(){}

    public void saveLutemons(Context context) {
        try {
            // first lets gather lutemons together from home, training area and battlefield
            Home.getHomeInstance().getLutemonsInHash().forEach((id, lutemon) -> hashToFileTransfer.put(id, lutemon));
            TrainingArea.getTrainingAreaInstance().getLutemonsInHash().forEach((id, lutemon) -> hashToFileTransfer.put(id, lutemon));
            BattleField.getBattleFieldInstance().getLutemonsInHash().forEach((id, lutemon) -> hashToFileTransfer.put(id, lutemon));

            // writing lutemons to file
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemon.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(hashToFileTransfer);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
            e.printStackTrace();
        }
    }


    public void loadLutemons(Context context) {
        try {
            // reading lutemons from file
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemon.data"));
            hashToFileTransfer = (HashMap<Integer, Lutemon>) lutemonReader.readObject();

            // we will put all the loaded lutemons to home
            Home.getHomeInstance().setLutemonsHash(hashToFileTransfer);
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }
}
