package controllers;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationController {
      private static Stage stage;
	  
	  public static void setStage(Stage primaryStage) {
		stage=primaryStage;
	  }
	  
	  public static Stage getStage() {
		return stage;
	  }
	  
	  public static void goToLoginView(){
		  loadForm("/views/LoginView.fxml");
		  stage.setTitle("Entrada de usuario");
	  }
	 
	  public static void goToMainView(){
		  loadForm("/views/MainView.fxml");
		  stage.setTitle("Aplicación principal");
	  }
	  
	  public static void closeApp() {
		  stage.close();
	  }
		    
	  private static void loadForm(String fxml) {
			    try {
			    	
			        Parent root = null;
			        URL    url  = null;
			        Class c = null;
			        c=ApplicationController.class;
			        try
			        {
			            url  = c.getResource( fxml );
			            root = FXMLLoader.load( url );
			            System.out.println( "  fxmlResource = " + fxml );
			        }
			        catch ( Exception ex )
			        {
			            System.out.println( "Exception on FXMLLoader.load()" );
			            System.out.println( "  * class: " + c );
			            System.out.println( "  * url: " + url );
			            System.out.println( "  * " + ex );
			            System.out.println( "    ----------------------------------------\n" );
			            throw ex;
			        }
			        stage.hide();
					stage.getScene().setRoot(root);
					stage.show();
				} catch (IOException e) {
					System.out.println("No se pudo cargar el archivo " + fxml);
					e.printStackTrace();
				}			   
		   }


	
}
