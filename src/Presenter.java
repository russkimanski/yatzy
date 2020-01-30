import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
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
    private Text p1;
    @FXML
    private Text p2;
    @FXML
    private Text p3;
    @FXML
    private Text p4;
    @FXML
    private Text p5;

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
        for (int i = 0; i < Integer.parseInt(toggleGroupValue); i++) {
            switch (i) {
                //todo: Mit Group lösen oder variablen Variabel :)
                case 0:
                    p1.textProperty().bind((yatzy.getPlayerName(i)));
                    break;
                case 1:
                    p2.textProperty().bind((yatzy.getPlayerName(i)));
                    break;
                case 2:
                    p3.textProperty().bind((yatzy.getPlayerName(i)));
                    break;
                case 3:
                    p4.textProperty().bind((yatzy.getPlayerName(i)));
                    break;
                case 4:
                    p5.textProperty().bind((yatzy.getPlayerName(i)));
                    break;
                default:
                    break;
            }
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
            button.setText("Hält");
            yatzy.holdDice(id);
        } else {
            yatzy.unHoldDice(id);
            button.setText("Halten");
        }
    }
}