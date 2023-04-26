package com.example.harjoitustyo;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int losedFights;
    protected int image;
    private static int idCounter = 0;
    protected int attackValue;


    public Lutemon(String color, int attack, int defense, int maxHealth, int image) {
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        experience = 0;
        health = maxHealth;
        this.maxHealth = maxHealth;
        id = idCounter;
        losedFights = 0;
        idCounter++;
        this.image = image;
    }

    public int getAttackValue() {
        // lets include randomness into the attack
        attackValue = (int) ((attack-1)+Math.random()*3);  // now the attack can be from 1 value smaller to 1 value bigger
        return attackValue;
    }

    public void defense(int attackValue) {
        health = health - (attackValue - defense);
    }

    public void changeExperience(int valueToAdd) {
        experience = experience + valueToAdd;
        attack = attack + valueToAdd; // attack changes in proportion to experience
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getLosedFights() { return losedFights; }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLosedFights(int losedFights) {
        this.losedFights = losedFights;
    }
}
