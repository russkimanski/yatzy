import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Peter Boxler <peter.boxler@edu.teko.ch>
 * @author Daniel Fiechter <daniel.fiechter@edu.teko.ch>
 * @author Alessandro Pucci <alessandro.pucci@edu.teko.ch>
 * @version 0.6
 * @since 0.1
 */
public class Main extends Application {
    public static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Yatzy yatzy = new Yatzy();
        Presenter presenter = new Presenter(yatzy);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        loader.setController(presenter);

        Pane root = loader.load();

        initScene(primaryStage, root);

        primaryStage.setTitle("YATZY");
        primaryStage.show();
    }

    private void initScene(Stage primaryStage, Pane root) {
        final int width = 1024;
        final int height = 668;
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        stage = primaryStage;
    }
}
