package kr.co.board.members;

import java.util.ArrayList;

public interface MembersDao {

	//모든 회원 조회
	public ArrayList<BoardMembersDto> getList() throws Exception;
	
	//회원가입
	public int setJoin(BoardMembersDto boardMembersDto) throws Exception;
	
	//로그인
	public BoardMembersDto login(String id, String password) throws Exception;
	
}
