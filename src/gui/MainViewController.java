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

//classe q controla o nosso MAINVIEW.FXML... essa classe vai IMPLEMENTAR a
//INTERFACE INITIALIZABLE
public class MainViewController implements Initializable{

	//itens de controle de tela. q correspondem ao menu do GUI...

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	//a baixo, vamos declarar OS METODOS para REALIZAR AS ACOES dos ITENS
	//de MENU (MENUITEM) declarados acima... ali como VARIAVEIS...
	
	
	//metodo para realizar as acoes do MenuItemSeller
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	//metodo para realizar as acoes do MenuItemDEPARTMENT
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	
	//metodo para realizar as acoes do MenuItemABOUT
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	//implementando o metodo initialize
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
	
	//criando uma funcao para abrir outra tela... em q o ABSOLUTNAME
	//vai receber o caminho de onde ta a outra tela, em FXML :)
	private synchronized void loadView(String absoluteName) {

		try {
			
			//chamando o FXMLLoader para abrir uma tela em FXML
			//e para o FXMLLOADER nos vamos passar o CAMINHO da tela FXML q ta
			//na VAR/atributo AbsoluteName
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			//a var NEWVBOX do tipo VBOX recebe o FXML q ta na VAR LOADER, feita acima
			VBox newVBox = loader.load();
			
			//mostrando a VIEW nova q foi carregada dentro da janela principal
			//	pegando qual a JANELA q ja ta aparecendo se e seller, about, etc...
			//pegando a referencia da SCENA/cena q a JANELA ta, chamando o METODO
			//getMAINSCENE q ta dentro da class MAIN
			Scene mainScene = Main.getMainScene();
			//pegando a referencia para os FILHOS<children> da JANELA PRINCIPAL
			//o VBOX do MainView.fxml, para saber se ta no registration ou help...
				//o metodo getroot pega o primeiro elemento da VIEW no caso o 
				//scrollpane... e dentro do SCROLLPANE no acessamos o .CONTET
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			
			//guardando uma referencia para o menu... no caso estamos pegando o
			//PRIMEIRO FIlho do VBOX da janela principal no caso e o MAINMENU
			Node mainMenu = mainVBox.getChildren().get(0);
			//chamando o MAINVBOX feito ali em cima, e limpando todos os filhos
			//dele
			mainVBox.getChildren().clear();
			//agora vamos ADD o MAINMENU (eu ACHO q é aquela barrinha de MENUS
			//q fica na parte de cima do software)
			mainVBox.getChildren().add(mainMenu);
			//adicionando os filhos do NEWVBOX... ou seja o filhos da janela q
			//estamos abrindo
			mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		//tratando a excecao
		catch(IOException e) {
			//chamando a classe ALERTS(q é utilizada para caso de excessao)
			Alerts.showAlert("IO Exception", "error loading view", e.getMessage(), AlertType.ERROR);
			
		}
	}
	
}