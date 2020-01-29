package org.study.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomDateEditor extends PropertyEditorSupport{
	public void setAsText(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			setValue(format.parse(s));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
