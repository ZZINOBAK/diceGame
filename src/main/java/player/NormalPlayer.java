package player;

import dice.Dice;

public class NormalPlayer extends Player {
    public NormalPlayer(String name, Dice typeOfDice, String modeOfDice) {
        super(name, typeOfDice, modeOfDice);
    }

    @Override
    public void rollDice(Player player, int gap) {
        player.getTypeOfDice().roll();
    }
}
