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
    private Label rounds;
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

        RadioButton selectedRadioButton = (RadioButton) tgswitch.getSelectedToggle();
        int playerCount = Integer.parseInt(selectedRadioButton.getText());

        final ObservableList<Node> labels = playerGroup.getChildren();
        for (int playerId = 0; playerId < playerCount; playerId++) {
            Label label = (Label) labels.get(playerId);
            String name = getPlayerName(playerId);
            yatzy.startGame(playerCount);
            yatzy.getPlayer(playerId).setName(name);
            label.textProperty().bind((yatzy.getPlayerName(playerId)));
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

    private void writeResultsButtonHandler(ActionEvent actionEvent) {
        /* yatzy.updateResults(); todo: implement selection of result key and update the value. */
    }

    private void holdButtonHandler(ActionEvent actionEvent) {
        //ToDo: Review Pesche!
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
}