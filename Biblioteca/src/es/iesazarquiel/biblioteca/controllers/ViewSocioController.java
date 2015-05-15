package es.iesazarquiel.biblioteca.controllers;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import es.iesazarquiel.biblioteca.models.dao.DaoSocio;
import es.iesazarquiel.biblioteca.models.entidades.Socio;

public class ViewSocioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Socio> tablaSocios;

    @FXML
    private TableColumn<Socio,Long> idSocio;

    @FXML
    private TableColumn<Socio, String> nombreSocio;

    @FXML
    private TableColumn<Socio, String> direcciónSocio;

    private DaoSocio daoSocio=new DaoSocio();
    
    @FXML
    void initialize() {
        assert tablaSocios != null : "fx:id=\"tablaSocios\" was not injected: check your FXML file 'ViewSocio.fxml'.";
        assert idSocio != null : "fx:id=\"idSocio\" was not injected: check your FXML file 'ViewSocio.fxml'.";
        assert nombreSocio != null : "fx:id=\"nombreSocio\" was not injected: check your FXML file 'ViewSocio.fxml'.";
        assert direcciónSocio != null : "fx:id=\"direcciónSocio\" was not injected: check your FXML file 'ViewSocio.fxml'.";

        idSocio.setCellValueFactory(new PropertyValueFactory<Socio, Long>("id"));
        nombreSocio.setCellValueFactory(new PropertyValueFactory<Socio, String>("nombre"));
        direcciónSocio.setCellValueFactory(new PropertyValueFactory<Socio, String>("direccion"));
        
        try {
			tablaSocios.getItems().setAll(daoSocio.listadoSocios());
		} catch (SQLException e) {
			System.out.println("No se pudo realalizar la consulta");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}








