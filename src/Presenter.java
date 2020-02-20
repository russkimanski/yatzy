import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private Yatzy yatzy;

    @FXML
    private Group labelGroup;
    @FXML
    private ToggleGroup tgswitch;
    @FXML
    private Group resultGroupP1;
    @FXML
    private Group resultGroupP2;
    @FXML
    private Group resultGroupP3;
    @FXML
    private Group resultGroupP4;
    @FXML
    private Group resultGroupP5;
    @FXML
    private Label rounds;
    @FXML
    private Label sum1P1;
    @FXML
    private Label bonusP1;
    @FXML
    private Label finalPointsP1;
    @FXML
    private Label sum1P2;
    @FXML
    private Label bonusP2;
    @FXML
    private Label finalPointsP2;
    @FXML
    private Label sum1P3;
    @FXML
    private Label bonusP3;
    @FXML
    private Label finalPointsP3;
    @FXML
    private Label sum1P4;
    @FXML
    private Label bonusP4;
    @FXML
    private Label finalPointsP4;
    @FXML
    private Label sum1P5;
    @FXML
    private Label bonusP5;
    @FXML
    private Label finalPointsP5;
    @FXML
    private ToggleButton t0;
    @FXML
    private ToggleButton t1;
    @FXML
    private ToggleButton t2;
    @FXML
    private ToggleButton t3;
    @FXML
    private ToggleButton t4;
    @FXML
    private Button submit;
    @FXML
    private Button start;
    @FXML
    private Button writeResults;
    @FXML
    private Group playerGroup;

    Presenter(Yatzy yatzy) {
        this.yatzy = yatzy;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(this::submitButtonHandler);
        start.setOnAction(this::startButtonHandler);
        writeResults.setOnAction(this::writeResultsButtonHandler);
        t0.setOnAction(this::holdButtonHandler);
        t1.setOnAction(this::holdButtonHandler);
        t2.setOnAction(this::holdButtonHandler);
        t3.setOnAction(this::holdButtonHandler);
        t4.setOnAction(this::holdButtonHandler);
        rounds.textProperty().bind(Bindings.convert(yatzy.getRound()));

        final List<Dice> dices = yatzy.getRollDices();
        final ObservableList<Node> labels = labelGroup.getChildren();
        for (int i = 0; i < dices.size(); i++) {
            Label label = (Label) labels.get(i);
            Dice dice = dices.get(i);
            label.textProperty().bind(Bindings.convert(dice.getValue()));
        }
    }

    private void submitButtonHandler(ActionEvent actionEvent) {
        yatzy.rollDices();
    }

    private void startButtonHandler(ActionEvent actionEvent) {
        yatzy.resetGame();
        initializeGame();
    }

    private void initializeGame() {
        RadioButton selectedRadioButton = (RadioButton) tgswitch.getSelectedToggle();
        int playerCount = Integer.parseInt(selectedRadioButton.getText());

        final ObservableList<Node> labels = playerGroup.getChildren();
        yatzy.startGame(playerCount);

        for (int playerId = 0; playerId < playerCount; playerId++) {
            Label label = (Label) labels.get(playerId);
            String name = getPlayerName(playerId);
            yatzy.getPlayer(playerId).setName(name);
            label.textProperty().bind((yatzy.getPlayerName(playerId)));
        }
    }


    private void bindPlayerResults(int playerId) {
        final ObservableList<Node> resultLabels1 = resultGroupP1.getChildren();
        final ObservableList<Node> resultLabels2 = resultGroupP2.getChildren();
        final ObservableList<Node> resultLabels3 = resultGroupP3.getChildren();
        final ObservableList<Node> resultLabels4 = resultGroupP4.getChildren();
        final ObservableList<Node> resultLabels5 = resultGroupP5.getChildren();
        switch (playerId) {
            case 0:
                bindSumLabels(playerId, resultLabels1, sum1P1, bonusP1, finalPointsP1);
                break;
            case 1:
                bindSumLabels(playerId, resultLabels2, sum1P2, bonusP2, finalPointsP2);
                break;
            case 2:
                bindSumLabels(playerId, resultLabels3, sum1P3, bonusP3, finalPointsP3);
                break;
            case 3:
                bindSumLabels(playerId, resultLabels4, sum1P4, bonusP4, finalPointsP4);
                break;
            case 4:
                bindSumLabels(playerId, resultLabels5, sum1P5, bonusP5, finalPointsP5);
                break;
        }
    }


    private void bindSumLabels(int playerId, ObservableList<Node> resultLabels1, Label sum1P1, Label bonusP1, Label finalPointsP1) {
        sum1P1.textProperty().bind(Bindings.convert(this.yatzy.getPlayer(playerId).getPlayerSum1()));
        bonusP1.textProperty().bind(Bindings.convert(this.yatzy.getPlayer(playerId).getPlayerBonus()));
        finalPointsP1.textProperty().bind(Bindings.convert(this.yatzy.getPlayer(playerId).getFinalScore()));
        int size = this.yatzy.getPlayer(playerId).getSizeOfResults();
        for (int i = 0; i < size; i++) {
            Label resultLabel = (Label) resultLabels1.get(i);
            resultLabel.textProperty().bind(Bindings.convert(this.yatzy.getPlayer(playerId).getPlayerResultValue(i)));
        }
    }


    private String getPlayerName(int playerId) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Spielername");
        dialog.setHeaderText("Spieler " + (playerId + 1));
        dialog.setContentText("Wie heissisch?");
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }


    private String getPlayerChoice(int playerId) {
        String[] resultKeys = yatzy.getPlayer(playerId).getListOfSortedKeys();
        ChoiceDialog<String> dialog = new ChoiceDialog<>(resultKeys[0], resultKeys);
        dialog.setTitle("Triff ä Entscheidig!");
        dialog.setHeaderText(yatzy.getPlayerName(playerId).getValue());
        dialog.setContentText("Weles Resultat wosch übernäh?");
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }


    private void changePlayerMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(yatzy.getPlayerName(yatzy.getCurrentPlayer()).getValue() + " isch dran!");
        if (yatzy.getPlayerName(yatzy.getCurrentPlayer()).getValue() != null) {
            alert.show();
        }
    }


    private void writeResultsButtonHandler(ActionEvent actionEvent) {
        if (yatzy.getRound().getValue() > 0) {
            int player = yatzy.getCurrentPlayer();
            String playerChoice = getPlayerChoice(player);
            yatzy.writeResults(player, playerChoice);
            if (!yatzy.getEndOfGame()) {
                bindPlayerResults(player);
                changePlayerMessage();
                yatzy.getPlayer(player).removeSelectedResult(playerChoice);
                deselectHoldButtons();
            }//ToDo: Implement a method for reset of result labels.
        }
    }


    private void holdButtonHandler(ActionEvent actionEvent) {

        ToggleButton button = (ToggleButton) actionEvent.getSource();
        int id = Character.getNumericValue(button.getId().charAt(1));

        if (button.isSelected()) {
            button.setText("Häbene");
            yatzy.holdDice(id);
        } else {
            button.setText("Bhaute");
            yatzy.setDiceActive(id);
        }
    }

    //ToDo: Use for loop.
    private void deselectHoldButtons() {
        t0.setSelected(false);
        t0.textProperty().set("Bhaute");
        t1.setSelected(false);
        t1.textProperty().set("Bhaute");
        t2.setSelected(false);
        t2.textProperty().set("Bhaute");
        t3.setSelected(false);
        t3.textProperty().set("Bhaute");
        t4.setSelected(false);
        t4.textProperty().set("Bhaute");
    }
}