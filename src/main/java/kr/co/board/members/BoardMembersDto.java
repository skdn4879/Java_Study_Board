package kr.co.board.members;

public class BoardMembersDto {
	
	private String id;
	private String password;
	private String name;
	public BoardMembersDto() {}
	
	public BoardMembersDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public BoardMembersDto(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BoardMembersDto [id=" + id + ", name=" + name + "]";
	}

}
