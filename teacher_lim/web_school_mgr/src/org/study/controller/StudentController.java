package org.study.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.SchoolDAO;
import org.study.model.Student;
import org.study.model.StudentWN;

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
			/*
			Cookie[] cookies = request.getCookies();
			boolean isFound = false;
			for (Cookie ck : cookies) {
				if (ck.getName().equals("user") &&
						ck.getValue().equals("admin") ) {
					isFound = true;
				}
			}
			*/
			
			HttpSession session = request.getSession();
			String userName = (String)session.getAttribute("user");
			if (userName == null) {
				request.setAttribute("error", "Login is required");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			
			procAddStudentForm(request, response);
		} else if (cmd.equals("list")) {
			procListStudent(request, response);
		} else if (cmd.equals("delete")) {
			procDeleteStudent(request, response);
		} else if (cmd.equals("update")) {
			procUpdateStudentForm(request, response);
		} else {
			response.getWriter().append("<h1>Under Construction")
				.append("</h1>" + request.getRequestURI());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String[] tokens = uri.split("/");
		String cmd = tokens[tokens.length - 1];
		
		if (cmd.equals("add")) {
			procAddStudent(request, response);
		} else if (cmd.equals("update")) {
			procUpdateStudent(request, response);
		} else {
			response.getWriter().append("<h1>Under Construction")
			.append("</h1>" + request.getRequestURI());
		}
	}

	private void procAddStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Student student = new Student();
		
		student.setsName(request.getParameter("sname"));
		student.setsId(request.getParameter("sid"));
		student.setsPw(request.getParameter("spw"));
		student.setEmail(request.getParameter("email"));
		student.setAddress(request.getParameter("address"));
		student.setBirthDay(request.getParameter("birthday"));
		student.setMajorCode(Integer.parseInt(request.getParameter("majorcode")));
		
		SchoolDAO dao = new SchoolDAO();
		if (dao.addStudent(student)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/success.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errorCode", "idDup");
			student.setsPw(null);
			request.setAttribute("student", student);
			procAddStudentForm(request, response);
		}
	}

	private void procAddStudentForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("action", "add");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void procListStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SchoolDAO dao = new SchoolDAO();
		StudentWN[] students = dao.getAllStudents();
		
		//System.out.println(Arrays.toString(students));
		request.setAttribute("students", students);
		request.getRequestDispatcher("/WEB-INF/views/listStudents.jsp").forward(request, response);
	}
	
	private void procDeleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		SchoolDAO dao = new SchoolDAO();
		if (dao.deleteStudent(id) ) {
			// 삭제가 성공했을때,
			// 사용자에게 다시 /student/list로 재 요청을 하도록 처리
			response.sendRedirect(request.getContextPath() + "/student/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(request, response);
		}
	}
	
	private void procUpdateStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		SchoolDAO dao = new SchoolDAO();
		Student s = dao.getStudentInfo(id);	
	
		request.setAttribute("student", s);
		request.setAttribute("action", "update");
		request.getRequestDispatcher("/WEB-INF/views/studentForm.jsp").forward(request, response);
	}
	
	private void procUpdateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		
		student.setsName(request.getParameter("sname"));
		student.setsId(request.getParameter("sid"));
		student.setsPw(request.getParameter("spw"));
		student.setEmail(request.getParameter("email"));
		student.setAddress(request.getParameter("address"));
		student.setBirthDay(request.getParameter("birthday"));
		student.setMajorCode(Integer.parseInt(request.getParameter("majorcode")));
		
		SchoolDAO dao = new SchoolDAO();
		if (dao.updateStudent(student)) {
			response.sendRedirect(request.getContextPath() + "/student/list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(request, response);
		}
	}

}




