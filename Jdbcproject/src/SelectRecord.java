
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectRecord
{
	public static void main(String args[])
	{
		/*int eno;
		String name,dep;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter emp dep:");
		dep=scanner.next();*/
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");
		System.out.println("....connection established....");
		
		String sql ="select * from emp";
		Statement statement = connection.createStatement();
		ResultSet Resultset=statement.executeQuery(sql);
		if(Resultset.next())
		{
		System.out.println("empno\tname\tdept");
		System.out.println("--------------------------------------------");
		while(Resultset.next())
		{
			System.out.println(Resultset.getInt(1)+"\t"+Resultset.getString(2)+"\t"+Resultset.getString(3)+"\t");
		}
		}
		else
		{
			System.out.println("no record found in table");
		}
		connection.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver not found...");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}