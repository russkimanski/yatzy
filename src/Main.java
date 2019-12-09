import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
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
        final int height = 768;
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
    }
}
