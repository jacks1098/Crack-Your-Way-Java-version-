package com.jacks.cyw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacks.cyw.services.UserService;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		String qid = (String) session.getAttribute("qid");
		String user = (String) session.getAttribute("user");
		System.out.println(user+" "+qid+" "+code);
		UserService service = new UserService();
		String status = (String) service.process(qid, code);
		System.out.println(status);
		if(status.equals("correct"))
		{
			String temp = qid.substring(1);
			int a = Integer.parseInt(temp);
			System.out.println(a);
			System.out.println((a+1)%20);
			a=(a+1)%20;
			if(a==0) a=20;
			System.out.println("a:"+a);
			String id = "";
			if(a<10) id+="C0"+a;
			else id+="C"+a;
			
			session.setAttribute("qid", id);
			System.out.println(qid);
			Integer count = (Integer) session.getAttribute("qcount");
			count++;
			session.setAttribute("qcount", count);
			if(count>=21) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("winner.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
			}
		}
		else
		{
			System.out.println(qid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);	
		}
	}

}
