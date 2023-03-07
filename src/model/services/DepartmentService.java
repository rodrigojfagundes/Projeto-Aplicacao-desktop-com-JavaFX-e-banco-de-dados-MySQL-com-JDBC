package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	

	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){
		return dao.findAll();
	}
	
	//crianod uma opera��o/metodo q vai receber um DEPARTMENT como OBJETO/VARIAVEL
	//ATRIBUTO... e vai verificar SE � para INSERIR ou ATUALIZAR O DEPARTMENT
	//existente
	public void SaveOrUpdate(Department obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
}
