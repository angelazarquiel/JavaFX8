package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button salir;
    
    @FXML
    private Button dialogo;

    @FXML
    void onDialogo(ActionEvent event) {
    	ApplicationController.showUserDialog();
    }
    
    @FXML
    void onSalir(ActionEvent event) {
    	ApplicationController.goToLoginView();
    }

    @FXML
    void initialize() {
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'MainView.fxml'.";

    }

}