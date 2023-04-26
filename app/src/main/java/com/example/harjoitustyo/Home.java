package com.example.harjoitustyo;

public class Home extends Storage{

    private static Home home = null;

    public Home() {
        super("Home");
    }

    public static Home getHomeInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }
}
