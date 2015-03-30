package middleLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DAO {

	static int result1;
	static int pid,uid;
	static int votes = 0;
	static String main_stmnt;
//	String statement;
	String status;

	public static String RetrieveMainStmnt(String tf) {

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL JDBC Driver not found !!");
				// return;
			}
			String connectionUrl = "jdbc:mysql://localhost:3306/litedb";
			String connectionUser = "root";
			String connectionPassword = "touchmenot";
			Connection con = DriverManager.getConnection(connectionUrl,
					connectionUser, connectionPassword);
			Statement st = con.createStatement();
			String query1 = "select statement from logicaltree where UID = "
					+ 1 + ";";
			String query2 = "select UID from logicaltree where statement = '"
					+ tf + "';";

			if (tf == null) {
				ResultSet rs1 = st.executeQuery(query1);
				while (rs1.next()) {
					main_stmnt = rs1.getString("statement");
				}
				rs1.close();
				// return main_stmnt;
			} else {
				ResultSet rs1 = st.executeQuery(query2);
				while (rs1.next()) {
					result1 = rs1.getInt("UID");
				}
				rs1.close();
				main_stmnt = String.valueOf(result1);
				// return String.valueOf(result1);
			}

			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return main_stmnt;

	}
	
	//-------- Enter the new statements into db --------------------------------------------------------------//
	public static void Enterintodb(String main_stmnt,String tf, String stat) {
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL JDBC Driver not found !!");
				// return;
			}
			String connectionUrl = "jdbc:mysql://localhost:3306/litedb";
			String connectionUser = "root";
			String connectionPassword = "touchmenot";
			Connection con = DriverManager.getConnection(connectionUrl,
					connectionUser, connectionPassword);
			Statement st = con.createStatement();
			String query1 = "select Count(*) from logicaltree";
			String query2 = "select UID from logicaltree where statement = '"
					+ main_stmnt + "';";
			

			ResultSet rs1 = st.executeQuery(query1);
			while (rs1.next()) {
				result1 = rs1.getInt("count(*)");
			}
			rs1.close();

			ResultSet rs2 = st.executeQuery(query2);
			while (rs2.next()) {
				pid = rs2.getInt("UID");
			}
			rs2.close();
			
			result1++;
			//System.out.println("result1 is"+result1+" pid is "+pid);
			
			String query3 = "insert into logicaltree values("+result1+",'"+tf
					+ "'," + votes + " ," + pid + " ,'" + stat + "')";
			String query4 = "commit";
			st.executeUpdate(query3);
			st.executeQuery(query4);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
  //---------------------------- Load the Agree, Disagree containers ------------------------------------
	public static Hashtable NewStatements(String main_stmnt, String status)
			throws SQLException {
		
		Hashtable<String,Integer> h = new Hashtable<String,Integer>();

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL JDBC Driver not found !!");
				// return;
			}
			String connectionUrl = "jdbc:mysql://localhost:3306/litedb";
			String connectionUser = "root";
			String connectionPassword = "touchmenot";
			Connection con = DriverManager.getConnection(connectionUrl,
					connectionUser, connectionPassword);
			Statement st = con.createStatement();
			String query1 = "select UID from logicaltree where statement = '"
					+ main_stmnt + "';";
			String query2;
			String query3;
			String query4;
			String query5;
			String query6;
			String query7;
			
			ResultSet rs1 = st.executeQuery(query1);
			while (rs1.next()) {
				result1 = rs1.getInt("UID");
			}
			rs1.close();

			query2 = "select statement,votes from logicaltree where PID="+result1+" and status='"+status+"';";
			ResultSet rs2 = st.executeQuery(query2);
			while (rs2.next()) {
				h.put(rs2.getString("statement"),rs2.getInt("votes"));
			}
			rs2.close();

			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return h;
	}

}
