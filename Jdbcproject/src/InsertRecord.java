
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord
{
	public static void main(String args[])
	{
		int eno,salary;
		String name,dep;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter emp name:");
		name=scanner.next();
		System.out.println("enter emp dep:");
		dep=scanner.next();
		System.out.println("enter emp salary:");
		salary=scanner.nextInt();
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");
		System.out.println("....connection established....");
		
		String sql ="insert into employee values(?,?,?,?)";
		PreparedStatement pstatement = connection.prepareStatement(sql);
		pstatement.setInt(1,eno);
		pstatement.setString(2,name);
		pstatement.setString(3,dep);
		pstatement.setInt(4,salary);
		pstatement.executeUpdate();
		System.out.println("......Record inserted successfully.....");
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