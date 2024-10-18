package dice;

import java.util.Random;

public abstract class Dice {
    private final Random random = new Random();
    private int randomNumber;

    public void roll() {
        randomNumber = random.nextInt(6) + 1;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
