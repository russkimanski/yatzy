import javafx.beans.property.SimpleIntegerProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Peter Boxler <peter.boxler@edu.teko.ch>
 * @author Daniel Fiechter <daniel.fiechter@edu.teko.ch>
 * @author Alessandro Pucci <alessandro.pucci@edu.teko.ch>
 * @version 0.5
 * @implNote Refactoring notwendig! Schleifen einfügen und mit Listen arbeiten (DRY wird aktuell nicht eingehalten).
 * @since 0.5
 */
class Yatzy {
    private SimpleIntegerProperty roundCount = new SimpleIntegerProperty();

    private List<Dice> rollDices = new LinkedList<>();
    private List<Dice> holdDices = new LinkedList<>();

    private int round;

    public Yatzy() {
        int diceCount = 5;
        for (int i = 0; i < diceCount; i++) {
            rollDices.add(new Dice());
        }
    }

    public final void rollDices() {
        if (round < 3) {
            this.round += 1;
        } else {
            this.round = 1;
        }

        for (Dice dice : rollDices) {
            dice.roll();
        }

    }

    public void holdDice(Dice dice) {
        rollDices.remove(dice);
        holdDices.add(dice);
    }

    public void unholdDice(Dice dice) {
        holdDices.remove(dice);
        rollDices.add(dice);
    }


    public SimpleIntegerProperty getRound() {
        return roundCount;
    }

    public List<Dice> getHoldDices() {
        return holdDices;
    }

    public List<Dice> getRollDices() {
        return rollDices;
    }
}
