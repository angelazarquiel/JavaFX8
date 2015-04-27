package aplicacion;

import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());

			// Parte izquierda
			ObservableList<String> versos = FXCollections.observableArrayList(
					"","","","","","","","","","","","");
			ListView<String> vistaVersos = new ListView<String>(versos);
			vistaVersos.getStyleClass().add("box");
			vistaVersos.setEditable(true);
			vistaVersos.setCellFactory(TextFieldListCell.forListView());
			vistaVersos.setOnEditCommit(e -> vistaVersos.getItems().set(
					e.getIndex(), e.getNewValue()));
			vistaVersos.setOnEditCancel(e -> {
				System.out.println("setOnEditCancel");
			});

			Button resetVersos = new Button("Limpiar");
			resetVersos.getStyleClass().add("button");
			VBox izquierda = new VBox();
			izquierda.getStyleClass().add("vbox");
			izquierda.getChildren().addAll(vistaVersos, resetVersos);
			resetVersos.setOnAction(e -> {
				for (int i = 0; i < versos.size(); i++)
					versos.set(i, "");
			});
			root.setLeft(izquierda);

			// parte derecha
			Button resetHaikus = new Button("Limpiar");
			resetHaikus.getStyleClass().add("button");
			TextArea haikus = new TextArea();
			haikus.getStyleClass().add("box");
			SimpleStringProperty haikusString = new SimpleStringProperty();
			haikusString.bindBidirectional(haikus.textProperty());
			haikus.setEditable(false);
			VBox derecha = new VBox();
			derecha.getStyleClass().add("vbox");
			derecha.getChildren().addAll(haikus, resetHaikus);
			resetHaikus.setOnAction(e -> haikus.clear());
			root.setRight(derecha);

			// botón central
			Button generar = new Button("Generar >");
			generar.getStyleClass().add("button");

			root.setCenter(generar);
			generar.setAlignment(Pos.CENTER);
			generar.setOnAction(e -> haikusString.set(haikusString.get()
					+ haiku(versos)));

			primaryStage.setTitle("Haiku Generator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long countNonEmpty(ObservableList<String> list) {
		return list.stream().filter(e -> !e.equals("")).count();
	}

	private String haiku(ObservableList<String> versos) {
		boolean[] usado;

		if (countNonEmpty(versos) < 3)
			return "Versos insuficientes\n";

		String resultado = "\n";
		usado = new boolean[versos.size()];
		Arrays.fill(usado, false);
		for (int i = 0; i < 3; i++) {
			int aleatorio;
			do {
				aleatorio = (int) (Math.random() * versos.size());
			} while (usado[aleatorio] == true
					|| versos.get(aleatorio).equals(""));
			System.out.println(Arrays.toString(usado));
			usado[aleatorio] = true;
			resultado += versos.get(aleatorio) + "\n";
		}
		return resultado;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
