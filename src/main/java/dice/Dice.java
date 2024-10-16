package dice;

import java.util.Random;

public abstract class Dice {
    Random random = new Random();
    int randomNumber;
    public int roll() {
        randomNumber = random.nextInt(6)+ 1;
        return randomNumber;
    }
}
