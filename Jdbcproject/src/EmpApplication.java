
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpApplication
{
	Connection connection;
	PreparedStatement preparedstatement;
	Statement statement;
	ResultSet resultset;
	String name,dept,sql;
	Integer eno,salary;
	static Scanner scanner = new Scanner(System.in);
	public EmpApplication() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","Akanksha@mysql12");

	}
	public void addRecord()throws SQLException
	{
		System.out.println("enter employee no:");
		eno=scanner.nextInt();
		System.out.println("enter employee name:");
		name=scanner.next();
		System.out.println("enter employee dept:");
		dept=scanner.next();
		System.out.println("enter employee salary:");
		salary=scanner.nextInt();
		sql="insert into employee values(?,?,?,?)";
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1,eno);
		preparedstatement.setString(2,name);
		preparedstatement.setString(3,dept);
		preparedstatement.setInt(4,salary);
		preparedstatement.executeUpdate();
		System.out.println("......Record inserted successfully.....");
	}
	public void deleteRecord()throws SQLException
	{
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		sql="delete from employee where eno=?";
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1,eno);
		if(preparedstatement.executeUpdate()>0)
		{
		System.out.println("record deleted..");
		}
		else 
		{
			System.out.println("employee do not exist....");
		}
	}
	public void updateRecord()throws SQLException
	{
		System.out.println("enter emp no:");
		eno=scanner.nextInt();
		System.out.println("enter updated employee salary:");
		salary=scanner.nextInt();
		sql="update employee set salary=? where eno=?";
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1,salary);
		preparedstatement.setInt(2,eno);
		if(preparedstatement.executeUpdate()>0)
		{
		System.out.println("......Record updated successfully.....");
		}
		else 
		{
			System.out.println("employee do not exist....");
		}
	}
	public void FindRecordById()throws SQLException
	{
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
	}
	public static void main(String args[])
	{
		int choice=0;
		System.out.println("****EMPLOYEE OPERATIONS****");
		System.out.println("-----------------------------------------------------");
		System.out.println("1.AddRecord");
		System.out.println("2.DeleteRecord");
		System.out.println("3.UpdateRecord");
		System.out.println("4.FindRecordByEmpId");
		System.out.println("5.exitApplication");
		while(choice!=5)
		{
			System.out.println("enter operation no:");
			choice=scanner.nextInt();
			try
			{
				EmpApplication empApp = new EmpApplication();
				switch(choice)
				{
				case 1: empApp.addRecord();
				        break;
				case 2: empApp.deleteRecord();
						break;
				case 3: empApp.updateRecord();
						break;
				case 4: empApp.FindRecordById();
						break;
				case 5: System.out.println("user quit application....\n");
				   		System.exit(0);
				default:System.out.println("invalid choice.....try again.....\n");
				}
			 }
		catch(ClassNotFoundException e)
				{
					System.out.println(e);
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
		     }
	     }
}
