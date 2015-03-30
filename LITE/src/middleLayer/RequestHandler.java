package middleLayer;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import org.json.simple.JSONObject;

public class RequestHandler extends HttpServlet {
	
int result1,uid,pid,votes = 0;
String main_stmnt,statement,status;
Hashtable<String,Integer> h = new Hashtable<String,Integer>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String tf1 = request.getParameter("textfield1");
		String tf2 = request.getParameter("textfield2");
		String main_stmnt = request.getParameter("main_stmnt_hidden");
					
//		main_stmnt = DAO.RetrieveMainStmnt(null);
			
//		request.setAttribute("main_stmnt",main_stmnt);
		
		if(request.getParameter("Agree_button") != null){
			DAO.Enterintodb(main_stmnt,tf1,"A");
			try {
				h = DAO.NewStatements(main_stmnt,"A");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//System.out.println(h.get(tf1));
		}
		if(request.getParameter("DisAgree_button") != null){
			DAO.Enterintodb(main_stmnt,tf2,"D");
			try {
				h = DAO.NewStatements(main_stmnt,"D");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		JSONObject json = new JSONObject();
	    json.putAll( h );
//	    System.out.printf( "JSON: %s", json.toString() );
	    
	    try {
            request.setAttribute("objkey", json);

            RequestDispatcher rd = request
                    .getRequestDispatcher("MainScreen.jsp");   // jsp to which i want to send data
            rd.forward(request, response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
	    
	  
	}
	
}
