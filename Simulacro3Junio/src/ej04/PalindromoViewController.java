package ej04;

/**
 * Sample Skeleton for 'PalindromoView.fxml' Controller Class
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

import static ej04.Palíndromo.esPalíndromo;

public class PalindromoViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="frase"
    private TextField frase; // Value injected by FXMLLoader

    @FXML // fx:id="resultado"
    private Label resultado; // Value injected by FXMLLoader

    @FXML // fx:id="blancos"
    private CheckBox blancos; // Value injected by FXMLLoader

    @FXML // fx:id="comprobar"
    private Button comprobar; // Value injected by FXMLLoader

    @FXML // fx:id="salir"
    private Button salir; // Value injected by FXMLLoader

    @FXML
    void onComprobar(ActionEvent event) {
    	if (esPalíndromo(frase.getText(),blancos.isSelected()))
    		resultado.setText("Es palíndromo");
    	else
    		resultado.setText("No es palíndromo");
    }

    @FXML
    void onSalir(ActionEvent event) {
    	Platform.exit();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert frase != null : "fx:id=\"frase\" was not injected: check your FXML file 'PalindromoView.fxml'.";
        assert resultado != null : "fx:id=\"resultado\" was not injected: check your FXML file 'PalindromoView.fxml'.";
        assert blancos != null : "fx:id=\"blancos\" was not injected: check your FXML file 'PalindromoView.fxml'.";
        assert comprobar != null : "fx:id=\"comprobar\" was not injected: check your FXML file 'PalindromoView.fxml'.";
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'PalindromoView.fxml'.";

    }
}
