package web0801;

public class AccountDTO {
	String name;
	String ssn;
	String tel;
	public AccountDTO(String name, String ssn, String tel) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "AccountDTO [name=" + name + ", ssn=" + ssn + ", tel=" + tel + "]";
	}
	
	
}
