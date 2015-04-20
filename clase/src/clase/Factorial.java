package clase;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Factorial extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		BorderPane root = new BorderPane();
		Scene ventana=new Scene(root);
		
		Button calcular=new Button("Calcular");
		Button salir=new Button("Salir");
		HBox botonera=new HBox();
		botonera.getChildren().addAll(calcular,salir);
		botonera.setSpacing(10);
		botonera.setPadding(new Insets(20,0,40,0));
		botonera.setAlignment(Pos.CENTER);
		root.setBottom(botonera);
		
		Label texto=new Label("Introduce un número para calcular su factorial:");
		VBox cabecera=new VBox();
		cabecera.setPadding(new Insets(10,10,10,10));
		cabecera.getChildren().add(texto);
		cabecera.setAlignment(Pos.CENTER);
		root.setTop(cabecera);
		
		VBox datos=new VBox();
		datos.setSpacing(20);
		TextField numero=new TextField();
		Label resultado=new Label("resultado");
		datos.getChildren().addAll(numero,resultado);
		datos.setPadding(new Insets(20));
		datos.setAlignment(Pos.CENTER);
		root.setCenter(datos);
		
		salir.setOnAction(e -> Platform.exit());
		//salir.setOnAction(e -> System.exit(0));
		calcular.setOnAction(e -> resultado.setText(factorial(numero.getText())));
		numero.setOnKeyPressed( (KeyEvent e) -> {
				if (e.getCode() == KeyCode.ENTER)
					resultado.setText(factorial(numero.getText()));
				else if (e.getCode()==KeyCode.ESCAPE) 
					Platform.exit();
			});
		
		primaryStage.setScene(ventana);
		primaryStage.show();
	}

	private String factorial(String text) {
		long numero=0;
		String resultado="";
		
		try {
			numero=Long.parseLong(text);
			long factorial=1;
			for(int i=1;i<=numero;i++)
				factorial*=i;
			resultado="Resultado: " + Long.toString(factorial);
		}
		catch (NumberFormatException nfe) {
			resultado="No se ha podido leer el numero";
		}
		
		return resultado;
	}

}
