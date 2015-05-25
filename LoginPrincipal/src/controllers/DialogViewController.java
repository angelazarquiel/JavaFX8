package controllers;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DialogViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button salir;

    @FXML
    void onSalir(ActionEvent event) {
    	ApplicationController.closeUserDialog();
    }
   

    @FXML
    void initialize() {
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'DialogView.fxml'.";

    }
}
