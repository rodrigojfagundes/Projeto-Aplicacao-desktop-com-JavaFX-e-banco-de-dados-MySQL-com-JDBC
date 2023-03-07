package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	

	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//definindo onde ta o FXML...
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			
			ScrollPane scrollPane = loader.load();
			
			//deixando o SCROLLPANE ajustado a janela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			//criando a CENA passando o SCROLLPANE como argumento
			mainScene = new Scene(scrollPane);
			//palco da cena... o MAINSCENE é a CENA PRINCIPAL... eu acho q
			//tela inicial EU ACHO
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//metodo para pegar a REFERENCIA da SCENE, 
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
