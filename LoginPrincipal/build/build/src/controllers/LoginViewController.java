package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button entrar;

    @FXML
    void onEntrar(ActionEvent event) {
    	if (true) // comprobar credenciales
    		ApplicationController.goToMainView();
    }
    
    @FXML
    private Button cancelar;

    @FXML
    void onCancelar(ActionEvent event) {
    	ApplicationController.closeApp();
    }

    @FXML
    void initialize() {
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'LoginView.fxml'.";

    }

}