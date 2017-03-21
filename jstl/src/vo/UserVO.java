package vo;

public class UserVO {
	private int no;
	private String name;
	private String id;
	private String pw;

	public UserVO() {
	}

	public UserVO(int no, String name, String id, String pw) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
