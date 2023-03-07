package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	
	//criando um METODO chamado FINDALL q IRA retornar uma LIST com todos os
	//DEPARTMENT do BANCO DE DADOS :)
	public List<Department> findAll(){
		//dados de teste... Q NAO ESTAO VINDO DO BANCO DE DADOS
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "books"));
		list.add(new Department(2, "computers"));
		list.add(new Department(3, "eletronics"));
		return list;
	}
}
