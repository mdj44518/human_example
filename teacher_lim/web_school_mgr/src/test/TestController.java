package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/*")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] tokens = request.getRequestURI().split("/");
		String cmd = tokens[tokens.length - 1];
		
		if (cmd.equals("add")) {
			// 화면을 그리는 것은 JSP에서 디자인
			// 해당 요청을 위의 JSP가 담당하도록 일을 부탁
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addTestForm.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println(request.getRequestURL());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인사결정
		// 인사 결정을 jsp로 전달
		if (request.getParameter("name").charAt(0) == '박') {
			request.setAttribute("applyResult", "SUCCESS");
		} else {
			request.setAttribute("applyResult", "FAILURE");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addTestResult.jsp");
		dispatcher.forward(request, response);
	}

}
