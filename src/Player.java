import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextInputDialog;

import java.util.HashMap;
import java.util.Optional;

public class Player {
    public HashMap<String, Integer> results = new HashMap<>();
    private static int playerCount;
    private int playRound;
    private SimpleStringProperty name = new SimpleStringProperty();


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
        playerCount = playerCount + 1;
    }

    public static void resetPlayerCount() {
        playerCount = 0;
    }

    public void setPlayerName() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Spielername");
        dialog.setHeaderText("Spieler " + (playerCount));
        dialog.setContentText("Gib di name i:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(s -> this.name.setValue(s));
    }

    public SimpleStringProperty getPlayerName() {
        return this.name;
    }

    //ToDo Implement MaxRoundCount...
    public int getPlayRound() {
        return playRound;
    }

    public void setPlayRound(int playRound) {
        this.playRound = playRound;
    }
}
