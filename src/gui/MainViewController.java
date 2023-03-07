package gui;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

//classe q controla o nosso MAINVIEW.FXML... essa classe vai IMPLEMENTAR a
//INTERFACE INITIALIZABLE
public class MainViewController implements Initializable{
	
	
	//itens de controle de tela. q correspondem ao menu do GUI...
	
	//criando uma VARIAVEL do TIPO MENUITEM chamada MENUTIEMSELLER
	@FXML
	private MenuItem menuItemSeller;
	
	//criando uma VARIAVEL do TIPO MENUITEM chamada MENUTIEMDepartment
	@FXML
	private MenuItem menuItemDepartment;
	
	//criando uma VARIAVEL do TIPO MENUITEM chamada MENUTIEMAbout
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
		System.out.println("onMenuItemAboutAction");
	}
	
	//implementando o metodo initialize
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}