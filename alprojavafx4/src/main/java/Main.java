import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField email = new TextField();
        email.setPromptText("email");

        PasswordField password = new PasswordField();
        password.setPromptText("password");

        HBox textFieldRow = new HBox(email, password);

        Button login = new Button("Login");
        login.disableProperty().bind(login.textProperty().isEmpty().or(password.textProperty().isEmpty()));
        Button register = new Button("Register");
        register.disableProperty().bind(email.textProperty().isNotEmpty().or(password.textProperty().isNotEmpty()));

        HBox buttonRow = new HBox(login, register);

        Label warning = new Label("email should contain @");
        warning.visibleProperty().bind(warning.managedProperty().not());
        email.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty() && !newValue.contains("@")) {
                warning.setManaged(false);
            } else {
                warning.setManaged(true);
            }
        });

        VBox root = new VBox(textFieldRow, buttonRow, warning);
        primaryStage.setScene(new Scene(root));


        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
