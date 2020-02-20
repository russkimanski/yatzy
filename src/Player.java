import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.*;
import java.util.stream.Stream;


public class Player {
    //ToDo: Make private and write methods (get / set).
    public HashMap<String, Integer> results = new HashMap<>();
    private HashMap<String, Integer> resultsToSelect;
    private int playRound;
    private StringProperty name = new SimpleStringProperty();
    private int bonus = 0;
    private int sum1 = 0;

    //ToDo: Probably a solution with enum
    public Player() {
        results.put("1er", 0);
        results.put("2er", 0);
        results.put("3er", 0);
        results.put("4er", 0);
        results.put("5er", 0);
        results.put("6er", 0);
        results.put("Äs Paar", 0);
        results.put("Zwöi Paar", 0);
        results.put("Drü Glichi", 0);
        results.put("Vier Glichi", 0);
        results.put("Chlini Strass", 0);
        results.put("Grossi Strass", 0);
        results.put("Full House", 0);
        results.put("Chance", 0);
        results.put("Yatzy", 0);

        resultsToSelect = new HashMap<>(results);
    }

    public SimpleIntegerProperty getPlayerSum1() {
        SimpleIntegerProperty value = new SimpleIntegerProperty();
        this.sum1 = Stream.of("1er", "2er", "3er", "4er", "5er", "6er").mapToInt(s -> results.get(s)).sum();
        value.set(sum1);
        return value;
    }

    public SimpleIntegerProperty getPlayerBonus() {
        SimpleIntegerProperty value = new SimpleIntegerProperty();
        int bonus = 0;
        if (this.sum1 >= 63) {
            bonus = 35;
        }
        this.bonus = bonus;
        value.set(bonus);
        return value;
    }

    public SimpleIntegerProperty getFinalScore() {
        SimpleIntegerProperty value = new SimpleIntegerProperty();
        int finalScore = this.bonus + results.values().stream().mapToInt(Integer::intValue).sum();
        value.set(finalScore);
        return value;
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


    public String[] getListOfSortedKeys() {
        Set<String> keySet = this.resultsToSelect.keySet();
        ArrayList<String> keys = new ArrayList<>(keySet);
        Collections.sort(keys);

        return keys.toArray(new String[0]);

    }

    //SortedSet is necessary to bind the result labels.
    public SimpleIntegerProperty getPlayerResultValue(int select) {
        SimpleIntegerProperty value1 = new SimpleIntegerProperty();
        int i = 0;
        SortedSet<String> keys = new TreeSet<>(results.keySet());
        int[] listValues = new int[15];

        for (String key : keys) {
            int value = this.results.get(key);
            listValues[i] = value;
            i++;
        }

        value1.set(listValues[select]);
        return value1;
    }


    public void removeSelectedResult(String key) {
        this.resultsToSelect.remove(key);
    }

}
