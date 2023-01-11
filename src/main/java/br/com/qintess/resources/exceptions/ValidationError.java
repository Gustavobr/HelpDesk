package br.com.qintess.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationError(long timestamp, Integer status, String error, String message, String path,
			List<FieldMessage> errors) {
		super(timestamp, status, error, message, path);
		this.errors = errors;
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setErrors(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

	public  static List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

}
