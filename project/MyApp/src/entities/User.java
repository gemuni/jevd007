package entities;

public class User {
	private String id;
	private String email;
	private String full_name;
	private String phone;
	private String address1;
	private String address2;
	private String status;
	private String role;
	private String createddate;
	
	/**
	 * Set ID
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Set Full Name
	 * @param full_name
	 */
	public void setFullFame(String full_name) {
		this.full_name = full_name;
	}
	
	/**
	 * Set Phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Set Address 1
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	/**
	 * Set Address 2
	 * @param address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	/**
	 * Set Status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Set Role
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Set Createdate
	 * @param createddate
	 */
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
}
