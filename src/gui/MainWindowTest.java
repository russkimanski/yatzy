package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// wir implementieren den Eventhandler
public class MainWindowTest extends Application implements EventHandler {

    // Hier legen wir einen Button an
    Button button;
    int i = 0;

    public static void main() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            primaryStage.setTitle("Unser erstes Fenster");
            StackPane root = new StackPane();
            Scene scene = new Scene(root, 400, 400);

            // hier legen wir den Button an und setzten seinen Text
            button = new Button();
            button.setText("Klick mich");
            // #1 Button
            button.setOnAction(this);

            root.getChildren().add(button);

            //Next Step: Den Button im Fenster anstelle der Konsole ausgeben...
            //Text text = new Text(20, 40, "Hallo Welt!");
            // Wir setzen die Textgröße
            //text.setFont(new Font(40));
            // Wir weisen unseren Text einer Gruppe hinzu die wir
            // wiederrum einer Scene zuweisen
            //Scene scene = new Scene(new Group(text));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == button) {
            i++;
            System.out.println(i + " mal geklickt");
        }
    }
}