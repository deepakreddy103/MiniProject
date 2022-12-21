package com.C45minproject.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email, String password );
	public void saveRegistration(String name, String city, String email, String mobile);
	public ResultSet getAllReg();
	public void deleteRegistration(String email);
	public void updateReg(String email, String mobile);
}
