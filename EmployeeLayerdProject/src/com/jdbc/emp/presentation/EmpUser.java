package com.jdbc.emp.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jdbc.emp.dao.EmpDao;
import com.jdbc.emp.entity.Emp;

public class EmpUser implements IEmpUser
{
	Integer eno,salary;
	String ename,dept;
	Scanner scanner = new Scanner(System.in);
	EmpDao empDao = new EmpDao();
	
	public void inputAddEmp() throws SQLException
	{
		System.out.println("enter employee no:");
		eno=scanner.nextInt();
		System.out.println("enter employee name:");
		ename=scanner.next();
		System.out.println("enter employee dept:");
		dept=scanner.next();
		System.out.println("enter employee salary:");
		salary=scanner.nextInt();
		
		Emp emp = new Emp();
		emp.setEno(eno);
		emp.setEname(ename);
		emp.setDept(dept);
		emp.setSalary(salary);
		System.out.println(empDao.addEmp(emp));
		
	}
	public void inputDeleteEmp() throws SQLException
	{
		System.out.println("enter employee no:");
		eno=scanner.nextInt();
		
		System.out.println(empDao.deleteEmp(eno));
	}
	public void inputUpdateEmp() throws SQLException
	{
		System.out.println("enter employee no:");
		eno=scanner.nextInt();
		System.out.println("enter employee salary:");
		salary=scanner.nextInt();
		
		Emp emp = new Emp();
		emp.setEno(eno);
		emp.setSalary(salary);
		System.out.println(empDao.updateEmp(emp));
	}
	public void inputFindEmpById() throws SQLException
	{
		System.out.println("enter employee no:");
		eno=scanner.nextInt();
		
		Emp emp =empDao.findEmpById(eno);
		if(emp!=null)
		{
			System.out.println("empno\tename\tdept\t\tsalary");
			System.out.println("--------------------------------------------");
			System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDept()+"\t\t"+emp.getSalary());
		}
			else
			{
				System.out.println("no record found in table");
			}
	}
	public void inputFindAllEmp() throws SQLException
	{
		List <Emp> list = empDao.findAllEmp();
		if(list.size()>0)
		{
			System.out.println("empno\tname\tdept\t\tsalary");
			for(Emp emp : list)
			{
				System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDept()+"\t"+emp.getSalary());
			}
		}
			else
			{
				System.out.println("no record found in table");
			}
	}
}
