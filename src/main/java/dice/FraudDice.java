package dice;

public class FraudDice extends Dice {

    @Override
    public void roll() {
        super.roll();
    }

    public void strongRoll() {
        do {
            super.roll();
        } while (getRandomNumber() <= 2);
    }

    public void weakRoll() {
        do {
            super.roll();
        } while (getRandomNumber() >= 5);
    }
}
