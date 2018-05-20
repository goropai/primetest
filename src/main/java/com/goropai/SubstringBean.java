package com.goropai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

@ManagedBean(name="substringFinder")
public class SubstringBean {
	
	private String text1;
	
	private String text2;

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}
	
	public void countSubstr(ActionEvent e) {
		int counter = 0;
		if(text1 != null || text2 != null) {
			Pattern pattern = Pattern.compile(text2);
			Matcher matcher = pattern.matcher(text1);
			while(matcher.find()) {
				counter++;
			}
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Word's found in string: ", String.valueOf(counter) + " times.");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

}
