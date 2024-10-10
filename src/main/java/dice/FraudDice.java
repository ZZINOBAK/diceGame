package dice;

public class FraudDice extends Dice{
    int result;

    @Override
    public int roll() {
        return super.roll();
    }

    public int strongRoll() {
        while (result <= 2) {
            result = super.roll();
        }
        return result;
    }

    public int weakRoll() {
        while (result >= 5) {
            result = super.roll();
        }
        return result;
    }
}
