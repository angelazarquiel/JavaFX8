package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

public class ControladorFactorial {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField resultado;

    @FXML
    private TextField numero;

    @FXML
    private Button calcular;

    @FXML
    void hacerFactorial(ActionEvent event) {
    	try {
    		resultado.setText(String.valueOf(factorial(Integer.parseInt(numero.getText()))));
    	} catch (Exception e) {
    		resultado.setText("Error de cálculo");
    	}
    }
    
    private int factorial(int i) {
    	return i*i;
    }

    @FXML
    void initialize() {
        assert resultado != null : "fx:id=\"resultado\" was not injected: check your FXML file 'VistaFactorial.fxml'.";
        assert numero != null : "fx:id=\"numero\" was not injected: check your FXML file 'VistaFactorial.fxml'.";
        assert calcular != null : "fx:id=\"calcular\" was not injected: check your FXML file 'VistaFactorial.fxml'.";

        resultado.setText("Esperando...");
        
    }
}

