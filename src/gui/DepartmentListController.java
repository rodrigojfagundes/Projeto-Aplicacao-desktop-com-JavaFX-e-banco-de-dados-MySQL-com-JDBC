package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	//fazendo uma DEPENDENCIA do DEPARTMENT SERVICE, para carregar os DADOS
	//q estao cadastrados no DEPARTMENT ID NOME... e vamos chamar essa dependencia
	//de SERVICE
	private DepartmentService service;
	
	
	//referencias para a tela de DEPARTMENT LIST...
	//temos um BOTAO na TOOLBAR e temos um TABLEVIEW q tem um ID e NAME 
			//referencia para tableview
	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	//pegar os DADOS Q TA NO SERVICE e mostrar dentro do tableVIEW
	private ObservableList<Department> obsList;
	
	
	//metodo de tratamento do botao... Para QUANDO CLICAR NO BOTAO FAZER ALGO
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	 
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//chamando o metodo initializeNodes
		initializeNodes();	
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		
		//comando para q a tela fique em tela cheia...
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//metodo q sera responsavel por ACESSAR O SERVICE, carregar os DEPARTMENT
	//ou seja o NOME e o ID e jogar esses DEPARTMENT na OBSERVABLELIST
	public void updateTableView() {
		//se o service for NULL...
		if (service == null) {
			throw new IllegalStateException("service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
	
}
