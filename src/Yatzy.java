import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;
import java.util.LinkedList;


class Yatzy {
    private IntegerProperty roundCount = new SimpleIntegerProperty();
    private HashMap<String, Integer> pointList = new HashMap<>();
    private LinkedList<Dice> rollDices = new LinkedList<>();
    private LinkedList<Player> players = new LinkedList<>();
    private int currentPlayer;

    public Yatzy() {
        int diceCount = 5;
        for (int i = 0; i < diceCount; i++) {
            rollDices.add(new Dice());
        }
    }

    public final void rollDices() {
        if (roundCount.getValue() < 3 && players.size() > 0) {
            this.roundCount.set(roundCount.getValue() + 1);
            for (Dice dice : rollDices) {
                //ToDo: Review Pesche
                if (!dice.isHold()) {
                    dice.roll();
                }
            }
        }
    }

    public void holdDice(int dice) {
        rollDices.get(dice).setOnHold();
    }

    public void setDiceActive(int dice) {
        rollDices.get(dice).setActive();
    }

    public IntegerProperty getRound() {
        return roundCount;
    }

    public LinkedList<Dice> getRollDices() {
        return rollDices;
    }

    public int sumRollDices() {
        int sum = 0;
        for (int i = 0; i < rollDices.size(); i++) {
            sum += rollDices.get(i).getValue().intValue();
        }
        return sum;
    }

    public StringProperty getPlayerName(int playerNumber) {
        if (players.size() == 0) {
            return new SimpleStringProperty();
        } else {
            return players.get(playerNumber).getName();
        }
    }

    public void startGame(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player();
            players.add(player);
            players.get(i).setPlayRound(0);
            setCurrentPlayer(0);
        }
    }

    //ToDo: Ausgabe von writResults aktuell nur in Konsole, muss auf die TextFelder gebunden werden...
    public void writeResults(int playerId, String key) {
        if (key == "1er" | key == "2er" | key == "3er" | key == "4er" | key == "5er" | key == "6er" | key == "chance") {
            int sum = sumRollDices();
            players.get(playerId).results.put(key, sum); //ToDo: Summe von Augenzahlen implementieren, diese funktioniert nur für die "chance".
        } else if (key == "1paar" | key == "2paar" | key == "dreiGleiche" | key == "vierGleiche") {
            players.get(playerId).results.put(key, 100); //ToDo: Implement method for these cases.
        } else {
            setPoints();
            int points = pointList.get(key);
            players.get(playerId).results.put(key, points);
        }
        this.roundCount.set(0);
        System.out.println("Spieler " + players.get(currentPlayer).getName().getValue() + " ha folgende Resultate in der HashMap:" + players.get(currentPlayer).results.values());
        if (currentPlayer < (players.size()) - 1) {
            setCurrentPlayer(getCurrentPlayer() + 1);
        } else {
            setCurrentPlayer(0);
        }
        System.out.println("Nächster Spieler: " + players.get(currentPlayer).getName().getValue());
    }

    public Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    public void resetGame() {
        for (Player player : players) {
            player.setName("");
        }
        players.clear();
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(int value) {
        this.currentPlayer = value;
    }

    private void setPoints() {
        pointList.put("kleineStrasse", 30);
        pointList.put("grosseStrasse", 40);
        pointList.put("fullHouse", 25);
        pointList.put("yatzy", 50);
        pointList.put("bonus", 35);
    }
}
