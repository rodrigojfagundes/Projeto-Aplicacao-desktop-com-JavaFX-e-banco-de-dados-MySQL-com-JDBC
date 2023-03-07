package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//para carregar os erros na excessao vamos chamar um MAP
	//String String... MAP é uma colecao de CHAVE:VALOR
	private Map<String, String> errors = new HashMap<>();
	

	public ValidationException(String msg) {
		super(msg);
	}
	
	public Map<String, String> getErros(){
		return errors;
	}

	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}
}