package com.jdbc.emp.presentation;

import java.sql.SQLException;
import java.util.Scanner;

public class EmpApplication
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		EmpUser empUser = new EmpUser();
		int choice=0;
		System.out.println("****EMPLOYEE OPERATIONS****");
		System.out.println("-----------------------------------------------------");
		System.out.println("1.AddRecord");
		System.out.println("2.DeleteRecord");
		System.out.println("3.UpdateRecord");
		System.out.println("4.FindRecordByEmpId");
		System.out.println("5.FindAllRecords");
		System.out.println("6.exitApplication");
		while(choice!=6)
		{
			System.out.println("enter operation no:");
			choice=scanner.nextInt();
			try
			{
				switch(choice)
				{
				case 1: empUser.inputAddEmp();
				        break;
				case 2: empUser.inputDeleteEmp();
						break;
				case 3: empUser.inputUpdateEmp();
						break;
				case 4: empUser.inputFindEmpById();
						break;
				case 5: empUser.inputFindAllEmp();
				        break;
				case 6: System.out.println("user quit application....\n");
				   		System.exit(0);
				default:System.out.println("invalid choice.....try again.....\n");
				}
			 }
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
	}
}