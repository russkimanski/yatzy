import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;


public class Player {
    public HashMap<String, Integer> results = new HashMap<>();
    private int playRound;
    private StringProperty name = new SimpleStringProperty();
    private int bonus = 0;
    private int sum1 = 0;
    private int finalScore = 0;

    public Player() {
        results.put("1er", 0);
        results.put("2er", 0);
        results.put("3er", 0);
        results.put("4er", 0);
        results.put("5er", 0);
        results.put("6er", 0);
        results.put("1paar", 0);
        results.put("2paar", 0);
        results.put("dreiGleiche", 0);
        results.put("vierGleiche", 0);
        results.put("kleineStrasse", 0);
        results.put("grosseStrasse", 0);
        results.put("fullHouse", 0);
        results.put("chance", 0);
        results.put("yatzy", 0);
    }

    public int getSum1() {
        this.sum1 = results.get("1er") + results.get("2er") + results.get("3er") + results.get("4er") + results.get("5er") + results.get("6er");
        return sum1;
    }

    public int getBonus() {
        if (sum1 >= 63) {
            return 35;
        } else {
            return 0;
        }
    }

    public int getFinalScore() {
        this.finalScore = bonus; //ToDo: Plus Resultat Hashmap
        return this.finalScore;
    }


    public StringProperty getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setPlayRound(int playRound) {
        this.playRound = playRound;
    }

    public int getPlayRound() {
        return playRound;
    }

    public SimpleIntegerProperty getPlayerResultValue(int select) {
        SimpleIntegerProperty value = new SimpleIntegerProperty();
        Integer[] listValues = this.results.values().toArray(new Integer[0]);
        value.set(listValues[select]);
        return value;
    }
}
