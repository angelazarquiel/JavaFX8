package ej03;

/**
 * Sample Skeleton for 'DadoView.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LetrasViewController {

	private Generador generador;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField letras;

    @FXML
    private TextField palabras;

    @FXML
    private Button generar;

    @FXML
    private Button comprobar;

    @FXML
    private Button salir;

    @FXML
    void onComprobar(ActionEvent event) {
    	if (generador.comprobar(palabras.getText()))
    		palabras.setStyle("-fx-background-color: lightgreen");
    	else
    		palabras.setStyle("-fx-background-color: red");
    }

    @FXML
    void onGenerar(ActionEvent event) {
    	generador.generar();
    }

    @FXML
    void onKeyRelease(KeyEvent event) {
    	if (generador.comprobar(palabras.getText()))
    		palabras.setStyle("-fx-background-color: lightgreen");
    	else
    		palabras.setStyle("-fx-background-color: red");
    }

    @FXML
    void onSalir(ActionEvent event) {
    	Platform.exit();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {        
    	palabras.setStyle("-fx-fill:black");
        generador=new Generador();
        letras.promptTextProperty().bindBidirectional(generador.getProperty());
    }
}
