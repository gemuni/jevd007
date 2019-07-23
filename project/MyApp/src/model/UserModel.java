package model;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.User;
import lib.DBConnection;
import lib.Utils;

public class UserModel {
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList getList() throws SQLException {
		String sql = "SELECT id, email, full_name, phone, address1, address2, status, role, createddate FROM admin_user";
		DBConnection connection = new DBConnection();
		ArrayList<User> list= new ArrayList<>();
		try {
			PreparedStatement ps = connection.getStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getString(1));
				u.setEmail(rs.getString(2));
				u.setFullFame(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setAddress1(rs.getString(5));
				u.setAddress2(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRole(rs.getString(8));
				u.setCreateddate(rs.getString(9));
				list.add(u);
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("assdad");
		}
		
		connection.close();
		
		return list;
	}
	
	/**
	 * 
	 * @param Email
	 * @param Password
	 * @return
	 * @throws SQLException
	 */
	public Array getUser(String Email, String Password) throws SQLException {
		String sql = "SELECT email, full_name FROM admin_user WHERE email=? AND password=?";
		DBConnection connection = new DBConnection();
		PreparedStatement ps = connection.getStatement(sql);
		ps.setString(1, Email);
		ps.setString(2, Utils.hash(Password));
		ResultSet rs = ps.executeQuery();
		
		Array results = rs.getArray(1);
		
		ps.close();
		connection.close();
		
		return results;
	}
}
