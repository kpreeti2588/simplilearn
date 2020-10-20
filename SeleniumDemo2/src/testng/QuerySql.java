package testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


public class QuerySql {
	
	@Test
	public void QueryMySql() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caldb?characterEncoding=utf8", "root", "admin123");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from calorietab;");
		
		while(rs.next()) {
			System.out.println("age = "+rs.getInt(1)+  "  height =  "+rs.getString(2)+  "   weight =  "+rs.getString(3) );
		}
	}

}
