import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Yatzy yatzy;

    @FXML
    private Label dice1;

    @FXML
    private Label dice2;

    @FXML
    private Label dice3;

    @FXML
    private Label dice4;

    @FXML
    private Label dice5;

    @FXML
    private ToggleButton t1;

    @FXML
    private ToggleButton t2;

    @FXML
    private ToggleButton t3;

    @FXML
    private ToggleButton t4;

    @FXML
    private ToggleButton t5;

    @FXML
    private Button submit;

    Presenter(Yatzy yatzy) {
        this.yatzy = yatzy;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(this::submitButtonHandler);

        yatzy.getThrowString().addListener(this::throwStringListener);

        yatzy.getThrowString2().addListener(this::throwStringListener2);

        yatzy.getThrowString3().addListener(this::throwStringListener3);

        yatzy.getThrowString4().addListener(this::throwStringListener4);

        yatzy.getThrowString5().addListener(this::throwStringListener5);

    }

    private void throwStringListener(Observable observable) {
        if (t1.isSelected()) {
        } else {
            String value = yatzy.getThrowString().get();
            dice1.setText(value);
        }
    }

    private void throwStringListener2(Observable observable) {
        if (t2.isSelected()) {
        } else {
            String value = yatzy.getThrowString2().get();
            dice2.setText(value);
        }
    }

    private void throwStringListener3(Observable observable) {
        if (t3.isSelected()) {
        } else {
            String value = yatzy.getThrowString3().get();
            dice3.setText(value);
        }
    }

    private void throwStringListener4(Observable observable) {
        if (t4.isSelected()) {
        } else {
            String value = yatzy.getThrowString4().get();
            dice4.setText(value);
        }
    }

    private void throwStringListener5(Observable observable) {
        if (t5.isSelected()) {
        } else {
            String value = yatzy.getThrowString5().get();
            dice5.setText(value);
        }
    }

    private void submitButtonHandler(ActionEvent actionEvent) {
        yatzy.rollDices();

    }

}