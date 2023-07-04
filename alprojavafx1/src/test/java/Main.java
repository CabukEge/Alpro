import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    private String name = "Ege";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello World, " + name);

        Scene scene = new Scene(label, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
