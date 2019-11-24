package gui;

import game.Dice;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Eventhandler implementieren
public class MainWindowTest extends Application implements EventHandler {

    // Button Referenz
    Button button;
    String sceneResult;
    int i = 0;
    String diceResult;

    public static void main() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            primaryStage.setTitle("YATZY");
            StackPane root = new StackPane();
            Scene scene = new Scene(root, 640, 480);
            // hier legen wir den Button an und setzten seinen Text
            button = new Button();
            button.setText("Würfeln");
            // #1 Button
            button.setOnAction(this);

            root.getChildren().add(button);

            //Next Step: Den Button im Fenster anstelle der Konsole ausgeben...
            //diceResult = dice1.printOut();
            Text text = new Text(20, 40, sceneResult);
            // Wir setzen die Textgröße
            text.setFont(new Font(40));
            // Wir weisen unseren Text einer Gruppe hinzu die wir
            // wiederrum einer Scene zuweisen
            //Scene scene2 = new Scene(new Group(text));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == button) {
            Dice dice2 = new Dice(5); //Aufruf der übergebenen Würfe
            sceneResult = dice2.getResult();
            dice2.printOut();
            ;
        }
    }
}