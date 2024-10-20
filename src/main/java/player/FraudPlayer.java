package player;

import dice.Dice;
import dice.FraudDice;

public class FraudPlayer extends Player {
    public FraudPlayer(String name, Dice typeOfDice, String modeOfDice) {
        super(name, typeOfDice, modeOfDice);
    }

    @Override
    public void rollDice(Player player, int gap) {
        FraudDice fraudDice = (FraudDice) player.getTypeOfDice();
        if (gap < 0) {
            player.setModeOfDice("strong");
            fraudDice.strongRoll();  // FraudDice에만 있는 메서드 호출
        } else if (gap >= 3) {
            player.setModeOfDice("weak");
            fraudDice.weakRoll();
        } else {
            player.setModeOfDice("normal");
            fraudDice.roll();
        }
    }

}
