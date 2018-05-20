package com.goropai;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MathView {
	private String value;
	private String operation;
	private Map<String, String> operations;
	
	@PostConstruct
	public void init() {
		operations = new HashMap<>();
		operations.put("log", "log");
		operations.put("sqrt", "sqrt");
		operations.put("cos", "cos");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Map<String, String> getOperations() {
		return operations;
	}

	public void setOperations(Map<String, String> operations) {
		this.operations = operations;
	}

	public void operate() {
		double val = Double.valueOf(value);
		if(operation.equals("log")) {
			value = String.valueOf(Math.log(val));
		}
		if(operation.equals("sqrt")) {
			value = String.valueOf(Math.sqrt(val));
		}
		if(operation.equals("cos")) {
			value = String.valueOf(Math.cos(val));
		}
	}
}
