package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	
	//declarando uma depedencia de departmentDAO (q é uma INTERFACE q serve para
	//INSERIR ATUALIZAR e DELETAR dados do BD)
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	
	
	//criando um METODO chamado FINDALL q IRA retornar uma LIST com todos os
	//DEPARTMENT do BANCO DE DADOS :)
	public List<Department> findAll(){
		//chamando o DAO (objeto/variavel) q ciramos ali em CIMA q é do tipo
		//DEPARTMENTDAO... E chamando o METODO FINDALL que irá retornar uma LISTA
		//com os DEPARTAMENTOS CADASTRADOS... no BANCO DE DADOS
		return dao.findAll();
	}
	
	public void SaveOrUpdate(Department obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
}
