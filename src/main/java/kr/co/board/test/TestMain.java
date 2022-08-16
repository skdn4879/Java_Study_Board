package kr.co.board.test;

import java.util.ArrayList;

import kr.co.board.board.BoardDao;
import kr.co.board.board.BoardDto;
import kr.co.board.members.BoardMembersDao;
import kr.co.board.members.BoardMembersDto;

public class TestMain {

	public static void main(String[] args) {
		
		BoardMembersDao boardMembersDao = new BoardMembersDao();
		BoardDao boardDao = new BoardDao();
		try {
			ArrayList<BoardMembersDto> ar = boardMembersDao.getList();
			
			for(BoardMembersDto boardMembersDto : ar) {
				System.out.println(boardMembersDto);
			}
			
			ArrayList<BoardDto> ar2 = boardDao.getList(0);
			
			for(BoardDto boardDto : ar2) {
				System.out.println(boardDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
