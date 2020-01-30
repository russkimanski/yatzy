import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Popup;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private Yatzy yatzy;

    @FXML
    private Group labelGroup;
    @FXML
    ToggleGroup tgswitch;
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
    private Popup popup;
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
        RadioButton selectedRadioButton = (RadioButton) tgswitch.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        yatzy.startGame(toggleGroupValue);
        final ObservableList<Node> labels = playerGroup.getChildren();
        for (int i = 0; i < Integer.parseInt(toggleGroupValue); i++) {
            Label label = (Label) labels.get(i);
            label.textProperty().bind((yatzy.getPlayerName(i)));
        }
    }

    private void writeResultsButtonHandler(ActionEvent actionEvent) {

    }
        /* yatzy.updateResults(); todo: implement selection of result key and update the value. */

    private void holdButtonHandler(ActionEvent actionEvent) {
        //ToDo: Review Pesche!
        ToggleButton button = (ToggleButton) actionEvent.getSource();
        int id = Character.getNumericValue(button.getId().charAt(1));

        if (button.isSelected()) {
            button.setText("Häbe");
            yatzy.holdDice(id);
        } else {
            yatzy.unHoldDice(id);
            button.setText("Haute");
        }
    }
}