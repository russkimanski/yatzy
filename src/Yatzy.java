import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Yatzy {
    private StringProperty throwString = new SimpleStringProperty();
    private final int[] rollDice = new int[5];

    public final void rollDices() {
        Dice dice = new Dice();
        dice.roll();
        throwString.setValue(String.valueOf(dice.getResult()));

    }

    public StringProperty getThrowString() {
        return throwString;

       /* String result = "";
        for (int i = 0; i < rollDice.length; i++) {
            if (i + 1 < rollDice.length) {
                result += rollDice[i] + ", ";
            } else {
                result += rollDice[i] + "";
            }

        }
        throwString = new SimpleStringProperty(result);
        return throwString;*/
    }

    private void setRollDice() {
        getThrowString();

    }


}
