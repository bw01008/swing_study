package swing_study.component.Table;

import java.sql.Date;

public class Customer {
	//Fields
	private int csNo;
	private String csName;
	private Date birth;
	private String phoneNo;
	private int sex;
	
	//Constructor
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int csNo) {
		this.csNo = csNo;
	}
	
	public Customer(int csNo, String csName, Date birth, String phoneNo, int sex) {
		this.csNo = csNo;
		this.csName = csName;
		this.birth = birth;
		this.phoneNo = phoneNo;
		this.sex = sex;
	}


	//Getter / Setter
	public int getCsNo() {
		return csNo;
	}

	public void setCsNo(int csNo) {
		this.csNo = csNo;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int csNo) {
		this.sex = sex;
	}

	//toString
	@Override
	public String toString() {
		return String.format("Customer [csNo=%s, csName=%s, birth=%s, phoneNo=%s, sex=%s]", csNo, csName, birth,
				phoneNo, sex);
	}
	

	

	
	
	
}
