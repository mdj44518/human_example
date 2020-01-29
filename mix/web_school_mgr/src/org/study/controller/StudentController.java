package org.study.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.model.Student;

/*
 * 
 */
@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String[] tokens = uri.split("/");
		String cmd = tokens[tokens.length - 1];
		
		if (cmd.equals("add")) {
			procAddStudentForm(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String[] tokens = uri.split("/");
		String cmd = tokens[tokens.length - 1];
		
		if (cmd.equals("add")) {
			procAddStudent(request, response);
		}
	}

	private void procAddStudent(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		
		student.setsName(request.getParameter("sname"));
		student.setsId(request.getParameter("sid"));
		student.setsPw(request.getParameter("spw"));
		student.setEmail(request.getParameter("email"));
		student.setAddress(request.getParameter("address"));
		student.setBirthDay(request.getParameter("birthday"));
		student.setMajorCode(Integer.parseInt(request.getParameter("majorcode")));
		
	}

	private void procAddStudentForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*
		 * 
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addStudentForm.jsp");
		dispatcher.forward(request, response);
	}

}
