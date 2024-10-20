package player;

import dice.Dice;

public abstract class Player {

    private final String name;
    private final Dice typeOfDice;
    private String modeOfDice;
    private int totalScore;

    public Player(String name, Dice typeOfDice, String modeOfDice) {
        this.name = name;
        this.typeOfDice = typeOfDice;
        this.modeOfDice = modeOfDice;
        this.totalScore = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Dice getTypeOfDice() {
        return typeOfDice;
    }

    public String getModeOfDice() {
        return modeOfDice;
    }

    public void setModeOfDice(String modeOfDice) {
        this.modeOfDice = modeOfDice;
    }

    public void rollDice(Player player, int gap) {

    }
}
