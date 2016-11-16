
/* Create a dynamic web application in Eclipse and 
 * then add a new Servlet called DBConnect. 
 * The following code in your servlet will connect to the oracle database
 *  and print a result in the console of Eclipse.
 *   Next we'll modify it to output to a JSP.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletDBClass")

public class ServletDBClass extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
    public ServletDBClass()
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		 String sql =  "select * from companies where companyid>18";
		//String sql = "select user from dual";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//con = DriverManager.getConnection("jdbc:oracle:thin:username/pwd@localhost:1521:SID");
			con = DriverManager.getConnection("jdbc:oracle:thin:HR/hr@localhost:1521:xe");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1) + "\t");
				System.out.println(rs.getString(2));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	
	

	}

	
	


