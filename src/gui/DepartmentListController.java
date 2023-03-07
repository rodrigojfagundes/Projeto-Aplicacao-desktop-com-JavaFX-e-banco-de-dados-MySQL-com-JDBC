package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

//classe department list controller q implementa a INTERFACE INITIALIZABLE
public class DepartmentListController implements Initializable {
	
	//fazendo uma DEPENDENCIA do DEPARTMENT SERVICE, para carregar os DADOS
	//q estao cadastrados no DEPARTMENT ID NOME... e vamos chamar essa dependencia
	//de SERVICE
	private DepartmentService service;
	
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	
	//metodo de tratamento do botao... Para QUANDO CLICAR NO BOTAO
	//carregar a telinha com os campos para cadastrar um novo produto
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		createDialogForm("/gui/DepartmentForm.fxml", parentStage);
	}
	 
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		//acessando o tableCOLUMNNAE e pegando os dados q estao dentro de NAME
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		
		//comando para q a tela fique em tela cheia...
		Stage stage = (Stage) Main.getMainScene().getWindow();

		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//metodo q sera responsavel por ACESSAR O SERVICE, carregar os DEPARTMENT
	//ou seja o NOME e o ID
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("service was null");
		}

		List<Department> list = service.findAll();

		obsList = FXCollections.observableArrayList(list);

		tableViewDepartment.setItems(obsList);
	}

	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
			//implementando a logica para abrir a JANELINHA de formulario
			//para CAD as pessoas
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			//chamando o painel PANE para carregar a tela 
			Pane pane = loader.load();
			
			//criando um cenario/stage novo
			Stage dialogStage = new Stage();
			//informando q vai ser um DIALOG STAGE ou seja... q vai ser uma
			//janela pequena q ira aparecer o formulario para add um novo
			//departamento
			dialogStage.setTitle("Enter Department data");
		
			dialogStage.setScene(new Scene(pane));
		
			dialogStage.setResizable(false);
		
			dialogStage.initOwner(parentStage);
		
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
}
