package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.JDBCConnection;
import entities.User;

public class UserDAO implements UserDAOInterface<User>{
	public static UserDAO getUserMethod() {
		return new UserDAO();
	}
	
	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "select * from user where username = ? and password =? and type = ?";
			PreparedStatement prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, user.getUsername());
			prepare.setString(2, user.getPassword());
			prepare.setString(3,"0");
			ResultSet check = prepare.executeQuery();
			while(check.next()) {
				String name = check.getString("username");
				String pass = check.getString("password");
				
				if(!name.equals("") && !pass.equals("")) {
					return check.getInt("id");
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "select * from user where username = ? and type = ?";
			PreparedStatement prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, user.getUsername());
			prepare.setString(2,"0");
			ResultSet check = prepare.executeQuery();
			while(check.next()) {
				String name = check.getString("username");
				if(!name.equals("")) {
					flag = 0;
				}
			}
			if(!user.getPassword().equals(user.getConfirmpassword())) {
				flag =  2;
			}
			if(flag==1) {
				String register_sql = "INSERT INTO USER(username, password,confirmpassword,type) values(?,?,?,?)";
				PreparedStatement st = conn.prepareStatement(register_sql);
				
				st.setString(1, user.getUsername());
				st.setString(2, user.getPassword());
				st.setString(3, user.getConfirmpassword());
				st.setString(4, "0");
				st.executeUpdate();
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean adminLogin(User user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "select * from user where username = ? and password =? and type = ?";
			PreparedStatement prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, user.getUsername());
			prepare.setString(2, user.getPassword());
			prepare.setString(3, "1");
			
			ResultSet check =  prepare.executeQuery();
			while(check.next()) {
				String name = check.getString("username");
				String pass = check.getString("password");
				
				if(!name.equals("") && !pass.equals("")) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
