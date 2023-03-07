package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	//classe INICIO
	public void start(Stage primaryStage) {
		try {
			//definindo onde ta o FXML... e nesse FXML ta COMO VAI SER A INTERFACE
			//GRAFICA (GUI) do software
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			//carregando a interface grafica
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			//palco da cena... o MAINSCENE é a CENA PRINCIPAL...
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
