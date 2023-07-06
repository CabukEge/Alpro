import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    Label text;

    @FXML
    Button logout;

    @FXML
    void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        var fxml = getClass().getResource("login.fxml");
        Parent root = FXMLLoader.load(fxml);
        stage.setScene(new Scene(root));
    }

}
