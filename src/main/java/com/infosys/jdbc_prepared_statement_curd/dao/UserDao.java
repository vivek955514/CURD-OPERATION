package com.infosys.jdbc_prepared_statement_curd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_curd.connection.UserConnection;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class UserDao {

	Connection connection = UserConnection.getUserConnection();

	/**
	 * saveUserDao(User user) method
	 */
	public User saveUserDao(User user) {

		String insertUserQuery = "insert into user(id,name,email,password,gender,dob) values (?,?,?,?,?,?)";

		{

			try {

				if (connection != null) {
					PreparedStatement ps = connection.prepareStatement(insertUserQuery);

					ps.setInt(1, user.getId());
					ps.setString(2, user.getName());
					ps.setString(3, user.getEmail());
					ps.setString(4, user.getPassword());
					ps.setString(5, user.getGender());
					ps.setObject(6, user.getDob());

					return ps.executeUpdate() > 0 ? user : null;

				}

				else {
					System.out.println("no connection found!!!");
					return null;

				}
			} catch (SQLException e) {

				e.printStackTrace();
				return null;
			}
		}

	}

	public List<User> getAllUserDao() {
		String selectUserQuery = " select * from user";

		try {

			PreparedStatement ps = connection.prepareStatement(selectUserQuery);
			List<User> users = new ArrayList<>();
			ResultSet set = ps.executeQuery();
			while (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				String password = set.getString("password");
				String gender = set.getString("gender");
				LocalDate dob = set.getDate("dob").toLocalDate();

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);

				user.setDob(dob);

				users.add(user);

			}
			return users;
		} catch (Exception e) {
			return null;

		}

	}

	public boolean deleteUserByIdDao(int id) {

		String deleteQuery = " delete from user where id = ?";

		try {

			PreparedStatement ps = connection.prepareStatement(deleteQuery);

			ps.setInt(1, id);

			int a = ps.executeUpdate();

			return a > 0;
		} catch (Exception e) {
			return false;

		}

	}

	public User getUserById(int id) {

		String selectUserByIdQuery = "select * from user where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(selectUserByIdQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String password = rs.getString("password");
				LocalDate dob = rs.getDate("dob").toLocalDate();
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);

				user.setDob(dob);

				return user;

			} else {
				return null; // user not found
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public User getUserByEmail(String email) {

		String selectUserByEmailQuery = "select * from user where email = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(selectUserByEmailQuery);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");
				String password = rs.getString("password");

				User user = new User();
				user.setName(name);
				user.setPassword(password);
				return user;

			}

			else {
				return null;
			}
		}

		catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public User updateUserById(User user) {
		String updateQuery = "UPDATE user SET name = ?, email = ?, password = ?,gender=?,dob=? WHERE id = ?";

		try {

			if (connection != null) {
				PreparedStatement ps = connection.prepareStatement(updateQuery);

				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getGender());
				ps.setObject(5, user.getDob());
				ps.setInt(6, user.getId());

				return ps.executeUpdate() > 0 ? user : null;

			}

			else {
				System.out.println("no connection found!!!");
				return null;

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
