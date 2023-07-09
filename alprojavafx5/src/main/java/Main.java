import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hallo World + Ege");




        Slider slider = new Slider(0, 100, 0);
        slider.setMaxWidth(200);
        slider.setBlockIncrement(150);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        double breite = slider.getValue();
        Label text1 = new Label("Breite: " + breite);

        Slider slider2 = new Slider(0, 100, 0);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMaxWidth(200);
        slider2.setBlockIncrement(150);
        double hoehe = slider2.getValue();
        Label text2 = new Label("Hoehe: " + hoehe);

        Slider slider3 = new Slider(0, 100, 0);
        slider3.setShowTickLabels(true);
        slider3.setShowTickMarks(true);
        slider3.setMaxWidth(200);
        slider3.setBlockIncrement(150);
        double laenge = slider3.getValue();
        Label text3 = new Label("Laenge: " + laenge);

        HBox hBox1 = new HBox(slider, text1);
        HBox hBox2 = new HBox(slider2, text2);
        HBox hBox3 = new HBox(slider3, text3);

        Label Volumen = new Label("Volumen: ");


        VBox vBox = new VBox(hBox1, hBox2, hBox3, Volumen);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double breite = slider.getValue();
                text1.setText("Breite: " + breite);
                double volumen = slider.getValue() * slider2.getValue() * slider3.getValue();
                Volumen.setText("Volumen: " + volumen);

            }
        });
       slider2.valueProperty().addListener(new ChangeListener<Number>() {
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               double hoehe = slider2.getValue();
               text2.setText("hoehe: " + hoehe);
               double volumen = slider.getValue() * slider2.getValue() * slider3.getValue();
               Volumen.setText("Volumen: " + volumen);
           }
       });
        slider3.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double laenge = slider3.getValue();
                text3.setText("laenge: " + laenge);
                double volumen = slider.getValue() * slider2.getValue() * slider3.getValue();
                Volumen.setText("Volumen: " + volumen);

            }
        });
        Scene scene = new Scene(new StackPane( vBox, l), 400, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

