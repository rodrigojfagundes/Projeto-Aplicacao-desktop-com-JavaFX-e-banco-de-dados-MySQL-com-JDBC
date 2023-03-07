package gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{

	//itens de controle de tela. q correspondem ao menu do GUI...
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	//a baixo, vamos declarar OS METODOS para REALIZAR AS ACOES dos ITENS
	//de MENU (MENUITEM)
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
	
	//criando uma funcao para abrir outra tela...
	private synchronized void loadView(String absoluteName) {
		
		try {
			
			//chamando o FXMLLoader para abrir uma tela em FXML
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			//a var NEWVBOX do tipo VBOX recebe o FXML q ta na VAR LOADER, feita acima
			VBox newVBox = loader.load();
			
			//mostrando a VIEW nova q foi carregada dentro da janela principal
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			
			//guardando uma referencia para o menu... 
			Node mainMenu = mainVBox.getChildren().get(0);
		
			mainVBox.getChildren().clear();
		
			mainVBox.getChildren().add(mainMenu);
		
			mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "error loading view", e.getMessage(), AlertType.ERROR);
			
		}
	}
	
}