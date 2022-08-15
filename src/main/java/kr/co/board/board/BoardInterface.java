package kr.co.board.board;

import java.util.ArrayList;

public interface BoardInterface {
	public static int PAGELIMIT = 5;
	
	//모든 리스트 얻어오기
	public ArrayList<BoardDto> getList(int start) throws Exception;
	
	//특정 게시글 보기
	public BoardDto getDetail(Integer boardNum) throws Exception;
	
	//게시글 추가
	public int addBoard(BoardDto boardDto) throws Exception;
	
	//게시글 수정
	public int updateBoard(BoardDto boardDto) throws Exception;
	
	//게시글 삭제
	public int deleteBoard(Integer boardNum) throws Exception;
	
	//전체 게시글 개수
	public int getLength() throws Exception;

}
