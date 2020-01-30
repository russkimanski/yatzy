import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;
import java.util.List;

class Yatzy {
    private SimpleIntegerProperty roundCount = new SimpleIntegerProperty();

    private List<Dice> rollDices = new LinkedList<>();
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
            if (!dice.isHold()) {
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

    public List<Dice> getRollDices() {
        return rollDices;
    }

    public SimpleStringProperty getPlayerName(int playerNumber) {
        if (players.size() == 0) {
            return new SimpleStringProperty();
        } else {
            return players.get(playerNumber).getPlayerName();
        }
    }

    public void startGame(String toggleGroupValue) {
        players.clear();
        Player.resetPlayerCount();
        for (int i = 0; i < Integer.parseInt(toggleGroupValue); i++) {
            Player player = new Player();
            players.add(player);
            players.get(i).setPlayerName();
            players.get(i).setPlayRound(0);
        }
    }
}
