package dice;

import java.util.Random;

public class Dice {
    Random random = new Random();
    int randomNumber;
    public int roll() {
        randomNumber = random.nextInt(6)+ 1;
        return randomNumber;
    }
}
