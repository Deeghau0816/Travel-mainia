package RegisterPack;
import java.sql.Date;

public class RegModel {
	
	private int userId;
	private String name;
	private String userName;
	private String phone;
	private String email;
	private Date dob;
	private String password;
	
	// Parameterized constructor to initialize user data
	public RegModel(int userId, String name, String userName, String phone, String email, Date dob, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.password = password;
	}

	//Setters and Getters
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
