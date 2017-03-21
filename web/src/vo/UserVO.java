package vo;

import java.sql.Date;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String addr;
	private int point;
	private Date regdate;
	
	public UserVO () {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "UserVO [아이디: " + id + ", 비밀번호: " + pwd + ", 이름: " + name + ", 전화번호: " + phone + ", 주소: " + addr
				+ ", 포인트: " + point + ", 날짜: " + regdate + "]";
	}
	
}
