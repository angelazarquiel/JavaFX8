package principal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Listview extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene ventana = new Scene(root, Color.BEIGE);
		
		ObservableList<String> versos=FXCollections.observableArrayList();
		ListView<String> lista=new ListView<String>(versos);
		lista.setEditable(true);
		lista.setCellFactory(TextFieldListCell.forListView());
		lista.setOnEditCommit(e -> lista.getItems().set(
				e.getIndex(), e.getNewValue()));
		lista.setOnEditCancel(e -> {
			System.out.println("setOnEditCancel");
		});
		
		Button b=new Button("Add");
		b.setOnAction(e -> versos.add("otro"));

		versos.add("Daw 1");
		
		root.setCenter(lista);
		root.setBottom(b);
		
		primaryStage.setScene(ventana);
		primaryStage.show();
	}

}
