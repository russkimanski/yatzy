import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;

public class Player {
    public HashMap<String, Integer> results = new HashMap<>();
    private int playRound;
    private StringProperty name = new SimpleStringProperty();

    public Player() {
        results.put("1er", 0);
        results.put("2er", 0);
        results.put("3er", 0);
        results.put("4er", 0);
        results.put("5er", 0);
        results.put("6er", 0);
        results.put("sum1", 0);
        //results.put("sum1", results.get("1er") + results.get("2er") + results.get("3er") + results.get("4er") + results.get("5er") + results.get("6er"));
        results.put("Bonus", 0);
        /*if (results.get("sum1") > 62){
            results.put("bonus", 35);
        }else {
            results.put("bonus", 0);
        }*/
        results.put("1 Paar", 0);
        results.put("2 Paar", 0);
        results.put("Drei Gleiche", 0);
        results.put("Vier Gleiche", 0);
        results.put("Kleine Strasse", 0);
        results.put("Grosse Strasse", 0);
        results.put("Full House", 0);
        results.put("Chance", 0);
        results.put("Yatzy", 0);
        results.put("Final Points", 0);
        //results.put("finalPoints", results.get("sum1") + results.get("bonus") + results.get("1paar") + results.get("2paar") + results.get("dreiGleiche") + results.get("vierGleiche") + results.get("kleineStrasse") + results.get("grosseStrasse") + results.get("fullHouse") + results.get("chance") + results.get("yatzy"));
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
}
