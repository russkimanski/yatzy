import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Yatzy {
    private StringProperty throwString = new SimpleStringProperty();
    private StringProperty throwString2 = new SimpleStringProperty();
    private StringProperty throwString3 = new SimpleStringProperty();
    private StringProperty throwString4 = new SimpleStringProperty();
    private StringProperty throwString5 = new SimpleStringProperty();

    public final void rollDices() {
        Dice dice = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        throwString.setValue(String.valueOf(dice.getResult()));
        throwString2.setValue(String.valueOf(dice2.getResult()));
        throwString3.setValue(String.valueOf(dice3.getResult()));
        throwString4.setValue(String.valueOf(dice4.getResult()));
        throwString5.setValue(String.valueOf(dice5.getResult()));

    }

    public StringProperty getThrowString() {
        return throwString;
    }

    public StringProperty getThrowString2() {
        return throwString2;
    }

    public StringProperty getThrowString3() {
        return throwString3;
    }

    public StringProperty getThrowString4() {
        return throwString4;
    }

    public StringProperty getThrowString5() {
        return throwString5;
    }

}
