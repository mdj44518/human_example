package org.study.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (id.equals("admin") && pw.equals("0000")) {
			/*
			// cookie를 생성하고 response에 주입
			Cookie ck = new Cookie("user", "admin");
			ck.setMaxAge(1 * 60);
			response.addCookie(ck);
			*/
			HttpSession session = request.getSession();
			session.setAttribute("user", "admin");
			
			response.sendRedirect(request.getContextPath() + "/student/list");
		} else {
			request.setAttribute("error", "로그인이 실패하였습니다. 다시 로그인 하세요");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
