package org.study.controller;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/PropertyEditorInit", loadOnStartup = 1)
public class PropertyEditorInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PropertyEditorInit() {
        PropertyEditorManager.registerEditor(Date.class, CustomDateEditor.class);
        //PropertyEditor editor = PropertyEditorManager.findEditor(Date.class);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
