package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
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
	
	//metodo de tratamento do botao... Para QUANDO CLICAR NO BOTAO FAZER ALGO
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
		
	}

	//metodo initialize nodes... para iniciar o comportamento das colunas
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		//acessando o tableCOLUMNNAE e pegando os dados q estao dentro de NAME
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
}
