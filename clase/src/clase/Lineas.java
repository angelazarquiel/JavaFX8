package clase;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class Lineas extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		Group root = new Group();
		Scene ventana=new Scene(root,400,500,Color.BEIGE);
		
		Line linea1 = new Line(50,50,350,50);
		linea1.setStroke(Color.RED);
		linea1.setStrokeWidth(10);
		linea1.setStrokeLineCap(StrokeLineCap.ROUND);
		
		Line linea2 = new Line(50,100,350,100);
		linea2.setStroke(Color.BLUE);
		linea2.setStrokeWidth(10);
		linea2.setStrokeLineCap(StrokeLineCap.ROUND);
		
		Slider tamaño=new Slider(1,30,10);
		tamaño.setLayoutX(50);
		tamaño.setLayoutY(150);
		
		linea2.strokeWidthProperty().bind(tamaño.valueProperty());
		
				
		root.getChildren().addAll(linea1,linea2,tamaño);
		
		
		primaryStage.setScene(ventana);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
