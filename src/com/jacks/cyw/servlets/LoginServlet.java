package com.jacks.cyw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacks.cyw.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("email");
		String password = request.getParameter("password");
		

		UserService service = new UserService();
		String status = service.login(id, password);
		
		
		
		HttpSession session = request.getSession();
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	if(status.equals("Login Successful")) {
			
			session.setAttribute("user", id);
			String t = id.substring(1);
			int a = Integer.parseInt(t);
			System.out.println(a);
			if(a>20) 
			{
				a=a-20;
				if(a<10) id="C0"+a;
				else id="C"+a;
				
			}
			System.out.println(id);
			session.setAttribute("qid", id);
			Integer temp =new Integer(1);
			
			session.setAttribute("qcount", temp);
			//out.println("Welcome "+uid);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(status.equals("Login Failure")){
			session.setAttribute("message", "Username and password doesn't matched.Try again");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else {
			session.setAttribute("message", status);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}
		
	}


	
	}


