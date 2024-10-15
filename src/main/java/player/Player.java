package player;

import dice.Dice;

public class Player {
    String name;
    Type typeOfPlayer;
    int totalScore;
    Dice typeOfDice;
    String modeOfDice;

    public Player(String name, Type typeOfPlayer, int totalScore, Dice typeOfDice, String modeOfDice) {
        this.name = name;
        this.typeOfPlayer = typeOfPlayer;
        this.totalScore = totalScore;
        this.typeOfDice = typeOfDice;
        this.modeOfDice = modeOfDice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getTypeOfPlayer() {
        return typeOfPlayer;
    }

    public void setTypeOfPlayer(Type typeOfPlayer) {
        this.typeOfPlayer = typeOfPlayer;
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

    public void setTypeOfDice(Dice typeOfDice) {
        this.typeOfDice = typeOfDice;
    }

    public String getModeOfDice() {
        return modeOfDice;
    }

    public void setModeOfDice(String modeOfDice) {
        this.modeOfDice = modeOfDice;
    }
}
