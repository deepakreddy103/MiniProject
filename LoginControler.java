package com.C45minproject.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.C45minproject.model.DAOService;
import com.C45minproject.model.DAOServiceimpl;

@WebServlet("/LoginControler")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginControler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService dao = new DAOServiceimpl();	
		dao.connectDB();
		boolean status = dao.verifyLogin(email, password);
		if (status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/new_registration.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error","invalid username/password");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
