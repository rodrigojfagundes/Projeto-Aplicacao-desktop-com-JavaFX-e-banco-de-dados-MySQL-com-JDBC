package gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentService;

//classe q controla o nosso MAINVIEW.FXML... 
public class MainViewController implements Initializable{

	//itens de controle de tela. q correspondem ao menu do GUI...

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	//metodo para realizar as acoes do MenuItemDEPARTMENT
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}
	
	//metodo para realizar as acoes do MenuItemABOUT
	@FXML
	public void onMenuItemAboutAction() {
		//passando para o LOADVIEW o local q esta o DESIGN da tela do ABOUT
		loadView("/gui/About.fxml", x -> {});
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
	
	//criando uma funcao para abrir outra tela... em q o ABSOLUTNAME
	//vai receber o caminho de onde ta a outra tela, em FXML :)
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			
			//chamando o FXMLLoader para abrir uma tela em FXML
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			//a var NEWVBOX do tipo VBOX recebe o FXML q ta na VAR LOADER, feita acima
			VBox newVBox = loader.load();
			
			//mostrando a VIEW nova q foi carregada dentro da janela principal
			Scene mainScene = Main.getMainScene();
			//pegando a referencia para os FILHOS<children> da JANELA PRINCIPAL
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			
			
			mainVBox.getChildren().clear();
			
			mainVBox.getChildren().add(mainMenu);
			
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
			//depois de carregar a janela acima, para ativar a funcao q
			//foi passada em Consumer <T> initializingAction
			
			T controller = loader.getController();
			//executando a acao q ta em INITIALINGACTIOn
			initializingAction.accept(controller);
		}

		catch(IOException e) {

			Alerts.showAlert("IO Exception", "error loading view", e.getMessage(), AlertType.ERROR);
			
		}
	}	
}