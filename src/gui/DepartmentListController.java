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
	
	private DepartmentService service;
	
	
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
		
		//acessando o tableCOLUMNNAE e pegando os dados q estao dentro de NAME
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		//comando para a tableviewdepartment acompanhar a janela... e ficar
		//em tela cheia
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//metodo q sera responsavel por ACESSAR O SERVICE, carregar os DEPARTMENT
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("service was null");
		}

		List<Department> list = service.findAll();

		obsList = FXCollections.observableArrayList(list);

		tableViewDepartment.setItems(obsList);
	}
	
}
