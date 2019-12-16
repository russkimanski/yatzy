import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Peter Boxler <peter.boxler@edu.teko.ch>
 * @author Daniel Fiechter <daniel.fiechter@edu.teko.ch>
 * @author Alessandro Pucci <alessandro.pucci@edu.teko.ch>
 * @version 0.5
 * @since 0.5
 */
public class Presenter implements Initializable {
    private Yatzy yatzy;
    @FXML
    private Label dice1 = new Label();
    @FXML
    private Label dice2 = new Label();
    @FXML
    private Label dice3 = new Label();
    @FXML
    private Label dice4 = new Label();
    @FXML
    private Label dice5 = new Label();
    @FXML
    private Label rounds = new Label();
    @FXML
    private ToggleButton t1 = new ToggleButton();
    @FXML
    private ToggleButton t2 = new ToggleButton();
    @FXML
    private ToggleButton t3 = new ToggleButton();
    @FXML
    private ToggleButton t4 = new ToggleButton();
    @FXML
    private ToggleButton t5 = new ToggleButton();
    @FXML
    private Button submit = new Button();

    Presenter(Yatzy yatzy) {
        this.yatzy = yatzy;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(this::submitButtonHandler);
        t1.setOnAction(this::submitToggleButtonHandler);
        t2.setOnAction(this::submitToggleButtonHandler);
        t3.setOnAction(this::submitToggleButtonHandler);
        t4.setOnAction(this::submitToggleButtonHandler);
        t5.setOnAction(this::submitToggleButtonHandler);
        rounds.textProperty().bind(yatzy.getRound());
        dice1.textProperty().bind(yatzy.getThrowString1());
        dice2.textProperty().bind(yatzy.getThrowString2());
        dice3.textProperty().bind(yatzy.getThrowString3());
        dice4.textProperty().bind(yatzy.getThrowString4());
        dice5.textProperty().bind(yatzy.getThrowString5());
    }

    private void submitButtonHandler(ActionEvent actionEvent) {
        yatzy.rollDices();
        yatzy.getRound();
    }

    private void submitToggleButtonHandler(ActionEvent actionEvent) {
        yatzy.setTButtonValue(t1.isSelected(), t2.isSelected(), t3.isSelected(), t4.isSelected(), t5.isSelected());
    }
}