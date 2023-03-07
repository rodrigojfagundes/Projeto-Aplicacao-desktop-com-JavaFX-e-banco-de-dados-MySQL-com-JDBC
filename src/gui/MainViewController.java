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
import model.services.SellerService;


public class MainViewController implements Initializable {

	// itens de controle de tela. q correspondem ao menu do GUI...

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	// a baixo, vamos declarar OS METODOS para REALIZAR AS ACOES dos ITENS
	// de MENU (MENUITEM) declarados acima... ali como VARIAVEIS...

	// metodo para realizar as acoes do MenuItemSeller
	@FXML
	public void onMenuItemSellerAction() {

		loadView("/gui/SellerList.fxml", (SellerListController controller) -> {
			controller.setSellerService(new SellerService());
			controller.updateTableView();
		});
	}

	// metodo para realizar as acoes do MenuItemDEPARTMENT
	
	@FXML
	public void onMenuItemDepartmentAction() {
	
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}

	@FXML
	public void onMenuItemAboutAction() {

		loadView("/gui/About.fxml", x -> {
		});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {

		try {

			// chamando o FXMLLoader para abrir uma tela em FXML
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();


			Node mainMenu = mainVBox.getChildren().get(0);

			mainVBox.getChildren().clear();

			mainVBox.getChildren().add(mainMenu);

			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "error loading view", e.getMessage(), AlertType.ERROR);

		}
	}
}