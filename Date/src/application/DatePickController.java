package application;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class DatePickController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private DatePicker date;

	    @FXML
	    private Button pasar;

	    @FXML
	    private Label resultado;

	    @FXML
	    void onPasar(ActionEvent event) {
	    	LocalDate localDate = date.getValue();
	    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
	    	Date theDate=Date.from(instant);
	    	java.sql.Date sqlDate = new java.sql.Date(theDate.getTime());
	    	resultado.setText(sqlDate+"");
	    }

	    @FXML
	    void initialize() {
	        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'DatePick.fxml'.";
	        assert pasar != null : "fx:id=\"pasar\" was not injected: check your FXML file 'DatePick.fxml'.";
	        assert resultado != null : "fx:id=\"resultado\" was not injected: check your FXML file 'DatePick.fxml'.";

	    }
	}

