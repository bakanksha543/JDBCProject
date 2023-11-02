package com.jdbc.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.emp.entity.Emp;

public class EmpDao implements IEmpDao
{
	Connection connection;
	PreparedStatement preparedStatement;
	String sql;
	private ResultSet resultset;
	private Emp emp;
	public EmpDao()
	{
		connection = MyConnection.getConnection();
	}
	public String addEmp(Emp emp)throws SQLException
	{
		sql="insert into employee values(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,emp.getEno());
		preparedStatement.setString(2,emp.getEname());
		preparedStatement.setString(3,emp.getDept());
		preparedStatement.setInt(4,emp.getSalary());
		preparedStatement.executeUpdate();
		return "......Record inserted successfully.....";
	}
	public String deleteEmp(Integer eno)throws SQLException
	{
		sql="delete from employee where eno=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,eno);
		if(preparedStatement.executeUpdate()>0)
		{
			return "record deleted..";
		}
		else 
		{
			return "employee do not exist....";
		}
	}
	public String updateEmp(Emp emp)throws SQLException
	{
		sql="update employee set salary=? where eno=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,emp.getSalary());
		preparedStatement.setInt(2,emp.getEno());
		
		if(preparedStatement.executeUpdate()>0)
		{
			return "......Record updated successfully.....";
		}
		else 
		{
			return "employee do not exist....";
		}
	}
	public Emp findEmpById(Integer eno)throws SQLException
	{
		sql="select * from employee where eno=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,eno);
		resultset = preparedStatement.executeQuery();
		Emp emp=null;
		if(resultset.next())
		{
			emp = new Emp();
			emp.setEno(resultset.getInt(1));
			emp.setEname(resultset.getString(2));
			emp.setDept(resultset.getString(3));
			emp.setSalary(resultset.getInt(4));
		}
		return emp;
	}
	public List <Emp> findAllEmp() throws SQLException
	{
		sql="select * from employee";
		preparedStatement = connection.prepareStatement(sql);
		resultset = preparedStatement.executeQuery();
		Emp emp=null;
		List <Emp> list = new ArrayList<Emp>();
		while(resultset.next())
		{
			emp = new Emp();
			emp.setEno(resultset.getInt(1));
			emp.setEname(resultset.getString(2));
			emp.setDept(resultset.getString(3));
			emp.setSalary(resultset.getInt(4));
			list.add(emp);
		}
		return list;
	}
}