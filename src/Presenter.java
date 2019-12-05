import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Yatzy yatzy;

    @FXML
    private Text diced;
    @FXML private Button submit;

    Presenter(Yatzy yatzy) {
        this.yatzy = yatzy;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(this::submitButtonHandler);

        yatzy.getThrowString().addListener(this::throwStringListener);
    }

    private void throwStringListener(Observable observable) {
        String value = yatzy.getThrowString().get();
        diced.setText(value);
    }

    private void submitButtonHandler(ActionEvent actionEvent) {
        yatzy.rollDices();

    }

}