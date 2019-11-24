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

    @FXML private Text destination;
    //@FXML private ComboBox<String> destinations;
    @FXML private Button submit;

    public Presenter(Model model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add destinations to dropdown list
        //destinations.getItems().addAll(model.getDestinations());

        // set submit button action handler
        submit.setOnAction(this::submitButtonHandler);

        // add change listener
        //model.destinationProperty().addListener(this::selectedNodeHandler);
    }

    /*private void selectedNodeHandler(Observable observable) {
        destination.setText(model.getDestination());
    }*/

    public void submitButtonHandler(ActionEvent actionEvent) {
        model.setDestination();
        destination.setText(model.getDestination());
    }


}