
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectPRecord
{
	static PreparedStatement preparedstatement;
	static ResultSet resultset;
	public static void main(String args[])
	{
		int eno;
		String name,dep,sql;
		Scanner scanner = new Scanner(System.in);
		
		/*System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter emp dep:");
		dep=scanner.next();*/
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");
		System.out.println("....connection established....");
		
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		sql="select * from employee where eno=?";
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1,eno);
		resultset=preparedstatement.executeQuery();
		if(resultset.next())
		{
		System.out.println("empno\tname\tdept\t\tsalary");
		System.out.println("--------------------------------------------");
		System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getInt(4));
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
