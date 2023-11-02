package com.jdbc.emp.presentation;

import java.sql.SQLException;

public interface IEmpUser 
{
	void inputAddEmp() throws SQLException;
	void inputDeleteEmp() throws SQLException;
	void inputUpdateEmp() throws SQLException;
	void inputFindEmpById() throws SQLException;
	void inputFindAllEmp() throws SQLException;
}
