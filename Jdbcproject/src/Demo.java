
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo 
{
	public static void main(String args[])
	{
		int eno,sal;
		String name,dep;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter emp name:");
		name=scanner.next();
		System.out.println("enter emp dep:");
		dep=scanner.next();
		System.out.println("enter emp salary:");
		sal=scanner.nextInt();
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");
		System.out.println("connection established....");
		
		String sql =" delete from emp where eno="+eno+" ";
		Statement statement = connection.createStatement();
		
		if(statement.executeUpdate(sql)>0)
		{
		System.out.println("record delete..");
		}
		else 
		{
			System.out.println("record not found..");
		}
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