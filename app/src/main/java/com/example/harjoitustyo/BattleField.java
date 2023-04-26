package com.example.harjoitustyo;

public class BattleField extends Storage{

    private static BattleField battleField = null;

    public BattleField() {
        super("Battle Field");
    }

    public static BattleField getBattleFieldInstance() {
        if (battleField == null) {
            battleField = new BattleField();
        }
        return battleField;
    }

}
