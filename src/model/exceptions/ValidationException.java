package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errors = new HashMap<>();
	

	public ValidationException(String msg) {
		super(msg);
	}
	
	public Map<String, String> getErros(){
		return errors;
	}
	//metodo para add elementos(errors) a colecao MAP
	//passando o campo... NAME, ID, CPF, etc... e o NOME do error
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}
}