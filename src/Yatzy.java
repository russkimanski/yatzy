import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Peter Boxler <peter.boxler@edu.teko.ch>
 * @author Daniel Fiechter <daniel.fiechter@edu.teko.ch>
 * @author Alessandro Pucci <alessandro.pucci@edu.teko.ch>
 * @version 0.5
 * @implNote Refactoring notwendig! Schleifen einfügen und mit Listen arbeiten (DRY wird aktuell nicht eingehalten).
 * @since 0.5
 */
class Yatzy {
    private SimpleStringProperty throwString1 = new SimpleStringProperty();
    private SimpleStringProperty throwString2 = new SimpleStringProperty();
    private SimpleStringProperty throwString3 = new SimpleStringProperty();
    private SimpleStringProperty throwString4 = new SimpleStringProperty();
    private SimpleStringProperty throwString5 = new SimpleStringProperty();
    private SimpleStringProperty roundCount = new SimpleStringProperty();
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();
    private Dice dice3 = new Dice();
    private Dice dice4 = new Dice();
    private Dice dice5 = new Dice();
    private boolean tButton1Value;
    private boolean tButton2Value;
    private boolean tButton3Value;
    private boolean tButton4Value;
    private boolean tButton5Value;
    private int round;

    public final void rollDices() {
        if (round < 3) {
            this.round += 1;
        } else {
            this.round = 1;
        }
        if (!tButton1Value) {
            dice1.roll();
        }
        if (!tButton2Value) {
            dice2.roll();
        }
        if (!tButton3Value) {
            dice3.roll();
        }
        if (!tButton4Value) {
            dice4.roll();
        }
        if (!tButton5Value) {
            dice5.roll();
        }
        throwString1.setValue(String.valueOf(dice1.getResult()));
        throwString2.setValue(String.valueOf(dice2.getResult()));
        throwString3.setValue(String.valueOf(dice3.getResult()));
        throwString4.setValue(String.valueOf(dice4.getResult()));
        throwString5.setValue(String.valueOf(dice5.getResult()));
    }

    public StringProperty getThrowString1() {
        return throwString1;
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

    public void setTButtonValue(boolean t1Value, boolean t2Value, boolean t3Value, boolean t4Value, boolean t5Value) {
        this.tButton1Value = t1Value;
        this.tButton2Value = t2Value;
        this.tButton3Value = t3Value;
        this.tButton4Value = t4Value;
        this.tButton5Value = t5Value;

    }

    public SimpleStringProperty getRound() {
        String roundsConvert = "Wurf " + round;
        roundCount.setValue(roundsConvert);
        return roundCount;
    }
}
