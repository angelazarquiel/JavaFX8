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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DadoViewController {

	private Dado dado;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="resultado"
    private TextField resultado; // Value injected by FXMLLoader
    
    @FXML // fx:id="caras"
    private TextField caras; // Value injected by FXMLLoader

    @FXML // fx:id="comprobar"
    private Button tirar; // Value injected by FXMLLoader

    @FXML // fx:id="salir"
    private Button salir; // Value injected by FXMLLoader

    @FXML
    void onTirar(ActionEvent event) {
    	try {
    	   dado.setCaras(Integer.valueOf(caras.getText()));
    	   resultado.setText(String.valueOf(dado.tirar()));
    	} catch (Exception e){
    		resultado.setText("Error...");
    	}
    }

    @FXML
    void onSalir(ActionEvent event) {
    	Platform.exit();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {        
        
        dado=new Dado();
    }
}
