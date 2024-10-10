package recorder;

public class Recorder {
    int result;
    String typeOfDice;

    public Recorder(int result, String typeOfDice) {
        this.result = result;
        this.typeOfDice = typeOfDice;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getTypeOfDice() {
        return typeOfDice;
    }

    public void setTypeOfDice(String typeOfDice) {
        this.typeOfDice = typeOfDice;
    }
}
