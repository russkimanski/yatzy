import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;

public class Player {
    public HashMap<String, Integer> results = new HashMap<>();
    private int playRound;
    private boolean lock;
    private boolean active;
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
        results.put("bonus", 0);
        //results.put("bonus", if(results.get("sum1") >62){35}else{0});
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
        //results.put("finalPoints", results.get("sum1") + results.get("bonus") + results.get("1paar") + results.get("2paar") + results.get("dreiGleiche") + results.get("vierGleiche") + results.get("kleineStrasse") + results.get("grosseStrassear") + results.get("fullHouse") + results.get("chance") + results.get("yatzy"));
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

    public boolean getLock() {
        return this.lock;
    }

    public void setLock(boolean lockValue) {
        this.lock = lockValue;
    }

    public boolean getActivePlayer() {
        return this.active;
    }

    public void setActivePlayer(boolean activeValue) {
        this.active = activeValue;
    }
}
