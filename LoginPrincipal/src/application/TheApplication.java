package application;

import controllers.ApplicationController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


public class TheApplication extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		    Scene scene = new Scene(new StackPane());
		    primaryStage.setScene(scene);
		    
		    ApplicationController.setStage(primaryStage);
		    ApplicationController.goToLoginView();
		 
		    //primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
