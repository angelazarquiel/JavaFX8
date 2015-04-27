package principal;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	//variables estáticas
	public static int numeroSecreto = 0;
	public static int numIntentos = 0;
    public boolean enJuego = false;
    public static Label mayormenor = new Label(" ");
    public static Label msjNumIntentos = new Label(" ");
    
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		BorderPane root = new BorderPane();
		Scene ventana = new Scene(root, Color.BEIGE);
		ventana.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Adivina número");
		
		//parte superior: tiene título y botón de iniciar juego
		VBox inicio = new VBox();
		inicio.getStyleClass().add("titulo");
		Label instruccion = new Label("Adivina el número");
		Button iniciarJuego = new Button("Iniciar juego");
		iniciarJuego.setOnAction(e -> {
			//método que reinicia el juego
			enJuego = true;
			numeroSecreto = (int)(Math.random()*100)+1;
			numIntentos = 10;
			mayormenor.setText("Adivina el número secreto");
			msjNumIntentos.setText("Tienes " + numIntentos + " intentos");
		});
		inicio.getChildren().addAll(instruccion, iniciarJuego);
		root.setTop(inicio);
		
		//parte central: tiene el recuadro de texto para introducir el texto,
		//funciona con ENTER
		VBox contNumero = new VBox();
		contNumero.getStyleClass().add("centro");
		TextField numero = new TextField();
		numero.getStyleClass().add("centrado");
		
		numero.setOnKeyPressed( (KeyEvent e) -> {
			if (e.getCode()==KeyCode.ENTER) {
				//método para comprobar si ha adivinado el número, 
				//si es mayor o menor,
				//y para reducir intentos
			if (enJuego) {
				int n = Integer.parseInt(numero.getText());
				numIntentos--;
				if (numIntentos==1) {
					msjNumIntentos.setText("Tienes 1 intento");
				}
				else {
				msjNumIntentos.setText("Tienes " + numIntentos + " intentos");
				}
				if (numIntentos==0 && n!=numeroSecreto) {
					mayormenor.setText("No adivinaste el número: " + numeroSecreto);
					msjNumIntentos.setText("Pulsa iniciar para otra partida");
					numero.setText("");
					enJuego = false;
				}
				else {				
				if (n==numeroSecreto) {
					mayormenor.setText("Número correcto. Enhorabuena.");
					msjNumIntentos.setText("Pulsar iniciar para otra partida");
					numero.setText("");
					enJuego = false;
				}
				else if (n<numeroSecreto) {
					mayormenor.setText("El número secreto es mayor");
				}
				else {
					mayormenor.setText("El número secreto es menor");
				}
				}
			}
			}
		});
		contNumero.getChildren().add(numero);
		root.setCenter(contNumero);
		
		//parte inferior, tiene dos líneas
		//la primera línea dice si el número es mayor o menor
		//la segunda línea dice cuántos intentos quedan al jugador
		VBox mensaje = new VBox();
		mensaje.getStyleClass().addAll("resultados","centrado");
		mensaje.getChildren().addAll(mayormenor, msjNumIntentos);
		root.setBottom(mensaje);
		
		
		primaryStage.setScene(ventana);
		primaryStage.show();		
		
	}
		

}

