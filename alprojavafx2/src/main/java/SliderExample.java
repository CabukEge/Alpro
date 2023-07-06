import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SliderExample extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Slider slider1= new Slider(0,100,0);
        slider1.setShowTickMarks(true);
        slider1.setShowTickLabels(true);
        double value1 = slider1.getValue();
        Label label1= new Label("Hoehe: "+value1);

        Slider slider2= new Slider(0,100,0);
        slider2.setShowTickMarks(true);
        slider2.setShowTickLabels(true);
        double value2 = slider2.getValue();
        Label label2= new Label("Breite: "+value2);

        Slider slider3= new Slider(0,100,0);
        slider3.setShowTickMarks(true);
        slider3.setShowTickLabels(true);
        double value3 = slider3.getValue();
        Label label3= new Label("Laenge: "+value3);

        double summe= slider1.getValue()*slider2.getValue()*slider3.getValue();
        Label label= new Label("Volumen: "+summe);

        slider1.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double newValue1= slider1.getValue();
                label1.setText("Hoehe: "+newValue1);
                label.setText("Volumen: "+newValue1*slider2.getValue()*slider3.getValue());
            }
        });
        slider2.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double newValue2= slider2.getValue();
                label2.setText("Breite: "+newValue2);
                label.setText("Volumen: "+slider1.getValue()*newValue2*slider3.getValue());
            }
        });
        slider3.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double newValue3= slider3.getValue();
                label3.setText("Laenge: "+newValue3);
                label.setText("Volumen: "+slider1.getValue()*slider2.getValue()*newValue3);
            }
        });

        HBox hbox1= new HBox(slider1, label1);
        HBox hbox2= new HBox(slider2,label2);
        HBox hbox3= new HBox(slider3,label3);

        VBox vBox = new VBox(hbox1,hbox2,hbox3,label);
        Scene scene = new Scene(vBox, 500, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}