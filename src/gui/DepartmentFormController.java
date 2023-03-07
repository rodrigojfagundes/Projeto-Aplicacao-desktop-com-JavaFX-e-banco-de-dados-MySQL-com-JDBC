package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
	private DepartmentService service;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setDepertment(Department entity) {
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@FXML
	public void ontBtSaveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("entity wall null");
		}
		if (service == null) {
			throw new IllegalStateException("service was null");
		}
		try {
			//salvando o departamento no BD
			entity = getFormData();
			//chamando o metodo SaveOrUpdate e passando o OBJ que é um DEPARTAMENT
			//para salvar ou ATUALIZAR no BANCO
			service.SaveOrUpdate(entity);
			Utils.currentStage(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("error saving objet", null, e.getMessage(), AlertType.ERROR);
		}
	}
		
	//um metodo responsavel por pegar os dados
	//q foram digitados no camp de CAD DEPARTAMENTO e instanciar um departamento
	private Department getFormData() {
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

		public void updateFormData() {
			if (entity == null) {
				throw new IllegalStateException("entity wass null");
			}
			
			txtId.setText(String.valueOf(entity.getId()));
			txtName.setText(entity.getName());
	}
}