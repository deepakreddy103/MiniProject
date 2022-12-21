package com.C45minproject.controler;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.C45minproject.model.DAOService;
import com.C45minproject.model.DAOServiceimpl;

@WebServlet("/delete")
public class DeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteControler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
			
			String email = request.getParameter("email");

			DAOService dao = new DAOServiceimpl();
			dao.connectDB();
			
			dao.deleteRegistration(email);
			
			ResultSet result = dao.getAllReg();
			request.setAttribute("result", result);
		
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/list_registration.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
