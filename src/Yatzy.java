import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;
import java.util.LinkedList;


class Yatzy {
    private IntegerProperty roundCount = new SimpleIntegerProperty();
    private LinkedList<Dice> rollDices = new LinkedList<>();
    private LinkedList<Player> players = new LinkedList<>();
    private int currentPlayer;
    private boolean endOfGame = false;

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

    public int sumDices() {
        int sum = 0;
        for (Dice rollDice : rollDices) {
            sum += rollDice.getValue().intValue();
        }
        return sum;
    }

    public int getDiceSum(int nr) {
        int sum = 0;
        for (Dice d : getRollDices()) { //ToDo: Was ist besser, Aufruf über Methode oder über Feld rollDiceses, wenn eine Methode z.B. nur in der selben Klasse wervendet würde?
            if (d.getValue().getValue() == nr) {
                sum += nr;
            }
        }
        return sum;
    }

    //ToDo: Implement a method to evaluate the winning player.
    public String getWinner() {
        return players.get(0).getName().getValue();
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

    public void writeResults(int playerId, String key) {
        if (key.equals("1er") | key.equals("2er") | key.equals("3er") | key.equals("4er") | key.equals("5er") | key.equals("6er")) {
            int sum = getDiceSum(Character.getNumericValue(key.charAt(0)));
            players.get(playerId).results.put(key, sum);
        } else if (key.equals("Chance")) {
            int sum = sumDices();
            players.get(playerId).results.put(key, sum);
        } else if (key.equals("Zwöi Paar")) {
            players.get(playerId).results.put(key, checkTwoPairs());
        } else if (key.equals("Äs Paar") | key.equals("Drü Glichi") | key.equals("Vier Glichi")) {
            players.get(playerId).results.put(key, checkXofAKind());
        } else if (key.equals("Chlini Strass")) {
            players.get(playerId).results.put(key, checkSmallOrLargeStraight());
        } else if (key.equals("Grossi Strass")) {
            players.get(playerId).results.put(key, checkSmallOrLargeStraight());
        } else if (key.equals("Full House")) {
            players.get(playerId).results.put(key, checkFullHouse());
        } else {
            players.get(playerId).results.put(key, checkYatzy());
        }
        setNextPlayer(playerId);
    }


    public void setNextPlayer(int playerId) {
        players.get(playerId).setPlayRound(players.get(playerId).getPlayRound() + 1);

        this.roundCount.set(0);

        for (Dice dice : rollDices) {
            dice.setActive();
            dice.setDiceValueNull();
        }

        if (!evaluateEndOfGame()) {
            if (playerId < (players.size()) - 1) {
                setCurrentPlayer(getCurrentPlayer() + 1);
            } else {
                setCurrentPlayer(0);
            }
        } else {
            resetGame();
        }
    }


    public boolean evaluateEndOfGame() {
        if (players.get(getCurrentPlayer()).getPlayRound() > 14) {
            double sum = 0;
            for (Player player : players) {
                sum += player.getPlayRound();
            }
            if (sum / players.size() >= 15) {
                this.endOfGame = true;
                //ToDo: Implement a method to evaluate the winning player.
                System.out.println("Hier wird der Spieler mit den meisten Punkten ausgegeben. Z.B. " + getWinner());
            }
        }
        return this.endOfGame;
    }

    public boolean getEndOfGame() {
        return endOfGame;
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

    //ToDO: Create a separate class to check dice results.
    public int checkTwoPairs() {
        int numPairs = 0;
        int score = 0;
        int sum;
        //for each possible number
        for (int i = 1; i <= 6; i++) {
            sum = 0;
            //for each dice
            for (Dice d : getRollDices()) {
                //if i is the dice value
                if (d.getValue().getValue() == i) {
                    //increment the number of matches
                    sum++;
                }
            }

            if (sum / 2 > 0) {
                numPairs += (sum / 2);
                score += (sum / 2) * 2 * i;
            }


            if (numPairs == 2) {
                return score;
            }
        }
        return 0;
    }

    public int[] getSortedResultsAsArray() {

        int[] diceValues = new int[getRollDices().size()];

        for (int i = 0; i < getRollDices().size(); i++) {
            diceValues[i] = getRollDices().get(i).getValue().intValue();
        }
        Arrays.sort(diceValues);
        return diceValues;
    }


    public int checkXofAKind() {
        int[] diceValues = getSortedResultsAsArray();
        int diceValue = 0;
        int countFinal = 0;

        for (int item : diceValues) {
            int count = 0;
            for (int value : diceValues) {
                if (item == value) {
                    count++;
                }
            }
            if (count == 2) {
                diceValue = item;
                countFinal = 2;
            } else if (count == 3) {
                diceValue = item;
                countFinal = 3;
            } else if (count == 4) {
                diceValue = item;
                countFinal = 4;
            }
        }
        return countFinal * diceValue;
    }

    public int checkSmallOrLargeStraight() {
        int[] diceValues = getSortedResultsAsArray();
        int count = 0;

        for (int i = 0; i < diceValues.length - 1; i++) {
            if (diceValues[i + 1] - diceValues[i] == 1) {
                count++;
            }
        }
        if (count >= 4) {
            return 40;
        } else if (count >= 3) {
            return 30;
        } else {
            return 0;
        }
    }

    public int checkFullHouse() {
        int[] diceValues = getSortedResultsAsArray();
        boolean foundThree = false;
        boolean foundTwo = false;

        for (int diceValue : diceValues) {
            int count = 0;
            for (int value : diceValues) {
                if (diceValue == value) {
                    count++;
                }
            }
            if (count == 3) {
                foundThree = true;
            } else if (count == 2) {
                foundTwo = true;
            }
        }
        if (foundThree && foundTwo) {
            return 25;
        } else {
            return 0;
        }
    }

    public int checkYatzy() {
        int[] diceValues = getSortedResultsAsArray();
        boolean foundFive = false;

        for (int value : diceValues) {
            int count = 0;
            for (int diceValue : diceValues) {
                if (value == diceValue) {
                    count++;
                }
            }
            if (count == 5) {
                foundFive = true;
                break;
            }
        }
        if (foundFive) {
            return 50;
        } else {
            return 0;
        }
    }

}
