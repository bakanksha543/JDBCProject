import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRecord
{
	public static void main(String args[])
	{
		int eno;
		String name,dep;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter emp dep:");
		dep=scanner.next();
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");
		System.out.println("....connection established....");
		
		String sql ="update emp set dep=? where eno=?";
		PreparedStatement pstatement = connection.prepareStatement(sql);
		pstatement.setString(1,dep);
		pstatement.setInt(2,eno);
		pstatement.executeUpdate();
		System.out.println("......Record updated successfully.....");
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
