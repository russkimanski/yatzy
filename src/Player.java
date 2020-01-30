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
        results.put("bonusSum", 0);
        results.put("bonus", 0);
        results.put("1paar", 0);
        results.put("2paar", 0);
        results.put("dreiGleiche", 0);
        results.put("vierGleiche", 0);
        results.put("kleineStrasse", 0);
        results.put("grosseStrasse", 0);
        results.put("fullHouse", 0);
        results.put("chance", 0);
        results.put("yatzy", 0);
        results.put("finalPoints", 0);
        String noName = "n/a";
        name.setValue(noName);
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
