package com.example.harjoitustyo;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Storage {

    protected String name;

    // HashMap for storing lutemons
    protected HashMap<Integer, Lutemon> lutemonsHash = new HashMap<>();

    // ArrayList for lutemons
    protected ArrayList<Lutemon> lutemonsArray = null;


    public Storage (String name) {
        this.name = name;
    }


    public void addLutemon(Lutemon lutemon) {
        lutemonsHash.put(lutemon.getId(), lutemon);
    }

    public void addLutemonWithItsId(Lutemon lutemon, int id) {
        lutemonsHash.put(id, lutemon);
    }

    public void deleteLutemonById(int id) {
        lutemonsHash.remove(id);
    }

    public HashMap<Integer, Lutemon> getLutemonsInHash() {
        return lutemonsHash;
    }

    public ArrayList<Lutemon> getLutemonsInArray() {
        lutemonsArray = new ArrayList<>();
        lutemonsHash.forEach((id, lutemon) -> lutemonsArray.add(lutemon));
        return lutemonsArray;
    }

    public ArrayList<Lutemon> getAllLutemons() { // method to get lutemons from home, training area and battlefield
        lutemonsArray = new ArrayList<>();
        Home.getHomeInstance().getLutemonsInHash().forEach((id, lutemon) -> lutemonsArray.add(lutemon));
        TrainingArea.getTrainingAreaInstance().getLutemonsInHash().forEach((id, lutemon) -> lutemonsArray.add(lutemon));
        BattleField.getBattleFieldInstance().getLutemonsInHash().forEach((id, lutemon) -> lutemonsArray.add(lutemon));
        return lutemonsArray;
    }

    public void setLutemonsHash(HashMap<Integer, Lutemon> lutemonsHash) {
        this.lutemonsHash = lutemonsHash;
    }




}
