package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.entities.Admin;

public class AdminDao {
	private Connection connection;

	public AdminDao(Connection connection){
		super();
		this.connection = connection;
	}

	public boolean saveAdmin(Admin admin){
		boolean flag = false;

		try {
			String query = "INSERT INTO admin(name, email, password, phone) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getEmail());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getPhone());

			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Admin getAdminByEmailPassword(String email, String password){
		Admin admin = null;
		try {
			String query = "SELECT * FROM admin WHERE email = ? AND password = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				admin = new Admin();
				admin.setId(resultSet.getInt("id"));
				admin.setName(resultSet.getString("name"));
				admin.setEmail(resultSet.getString("email"));
				admin.setPassword(resultSet.getString("password"));
				admin.setPhone(resultSet.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	public List<Admin> getAllAdmin(){
		List<Admin> list = new ArrayList<Admin>();
		try {
			String query = "SELECT * FROM admin";
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Admin admin = new Admin();
				admin.setId(resultSet.getInt("id"));
				admin.setName(resultSet.getString("name"));
				admin.setEmail(resultSet.getString("email"));
				admin.setPhone(resultSet.getString("phone"));
				admin.setPassword(resultSet.getString("password"));

				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteAdmin(int id){
		boolean flag = false;
		try {
			String query = "DELETE FROM admin WHERE id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
