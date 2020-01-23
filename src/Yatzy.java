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
    private List<Player> players = new LinkedList<>();

    public Yatzy() {
        int diceCount = 5;
        for (int i = 0; i < diceCount; i++) {
            rollDices.add(new Dice());
        }
    }

    public final void rollDices() {
        if (roundCount.getValue() < 3) {
            this.roundCount.set(roundCount.getValue() + 1);
        } else {
            this.roundCount.set(1);
        }

        for (Dice dice : rollDices) {
            //ToDo: Review Pesche
            if (dice.isHold()) {
            } else {
                dice.roll();
            }
        }

    }

    public void holdDice(int dice) {
        rollDices.get(dice).setOnHold();
    }

    public void setDiceActive(int dice) {
        rollDices.get(dice).setActive();
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

    public void startGame(String toggleGroupValue) {
        players.clear();
        for (int i = 0; i < Integer.parseInt(toggleGroupValue); i++) {
            String playerName = "Spieler" + (i + 1);
            Player player = new Player();
            this.players.add(player);
            player.setPlayerName(playerName);
            player.setPlayRound(0);
            /*Für Itrationsmeeting um zu zeigen, dass entsprechend den mit dem RadioButton selektierten Anzahl Spielern
            Objekte erstellt worden sind:*/
            System.out.println(player.getPlayerName());
            System.out.println(player.getPlayRound());
        }
        //Für Iterationsmeeting um die Anzahl Spieler aufzulisten (Konsole):
        System.out.println(players.size());
    }
}
