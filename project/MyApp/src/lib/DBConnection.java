package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	Connection conn = null;
	
	public Connection conenct() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn =
		       DriverManager.getConnection("jdbc:mysql://sql166.main-hosting.eu/u798698804_stu", "u798698804_stu","student");
		    String sql = "SELECT id, email as email, full_name, phone, address1, address2, status, role, createddate FROM admin_user";
		    conn.prepareStatement(sql);
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return this.conn;
	}
	
	/**
	 * Get prepare statement
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public PreparedStatement getStatement(String sql) throws SQLException, ClassNotFoundException {
		if(this.conn == null) {
			this.conenct();
		}
		return this.conn.prepareStatement(sql);
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public Connection getConnection() throws ClassNotFoundException {
		if(this.conn == null) {
			return this.conenct();
		}
		return this.conn;
	}
	
	/**
	 * Close connection
	 * @throws SQLException 
	 */
	public void close() throws SQLException {
		if(this.conn != null) {
			this.conn.close();
		}
	}
	
}
