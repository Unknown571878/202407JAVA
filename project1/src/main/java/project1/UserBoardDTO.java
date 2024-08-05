package project1;

public class UserBoardDTO {
	private int boardnum;
	private String title;
	private String content;
	private String writer;
	private String regtime;
	private int usernum;

	public UserBoardDTO(int boardnum, String title, String content, String writer, String regtime, int usernum) {
		super();
		this.boardnum = boardnum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regtime = regtime;
		this.usernum = usernum;
	}

	@Override
	public String toString() {
		return "UserBoardDTO [boardnum=" + boardnum + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regtime=" + regtime + ", usernum=" + usernum + "]";
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

}
