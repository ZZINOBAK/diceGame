package dice;

public class FraudDice extends Dice{
    int result;

    @Override
    public int roll() {
        return super.roll();
    }

    public int strongRoll() {
        do {
            result = super.roll();
        } while (result <= 2);
        return result;
    }

    public int weakRoll() {
        do {
            result = super.roll();
        } while (result >= 5);
        return result;
    }
}
