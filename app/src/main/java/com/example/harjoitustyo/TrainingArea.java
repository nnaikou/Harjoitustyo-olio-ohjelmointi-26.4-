package com.example.harjoitustyo;

public class TrainingArea extends Storage{

    private static TrainingArea trainingArea = null;

    public TrainingArea() {
        super("Training Area");
    }

    public static TrainingArea getTrainingAreaInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }
}
