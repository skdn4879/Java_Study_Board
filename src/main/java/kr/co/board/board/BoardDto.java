package kr.co.board.board;

import java.util.Date;
import java.util.Calendar;

public class BoardDto {

	private Integer boardNum;
	private String title;
	private String contents;
	private String writer;
	private Date writeDate = Calendar.getInstance().getTime();
	private Integer viewCount = 1;
	
	public BoardDto() {}

	public BoardDto(Integer boardNum, String title, String contents, String writer, Date writeDate, Integer viewCount) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
	}

	public Integer getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "BoardDto [boardNum=" + boardNum + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", viewCount=" + viewCount + "]";
	}
	
}
