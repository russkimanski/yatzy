package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Model model;

    @FXML
    private Text diced;
    @FXML private Button submit;

    Presenter(Model model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(this::submitButtonHandler);
    }

    private void submitButtonHandler(ActionEvent actionEvent) {
        model.rollDice();
        diced.setText(model.getDiced());
    }

}