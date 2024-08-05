package project1;

public class UserDTO {
	private int userNum;
	private String id;
	private String ssn;
	private String name;

	public UserDTO(int userNum, String id, String ssn, String name) {
		super();
		this.userNum = userNum;
		this.id = id;
		this.ssn = ssn;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userNum=" + userNum + ", id=" + id + ", ssn=" + ssn + ", name=" + name + "]";
	}

	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
