package kr.co.board.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.board.util.DBConnector;

public class BoardDao implements BoardInterface {
	
	@Override
	public ArrayList<BoardDto> getList(int start) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY writedate DESC) NUM, BOARD.* FROM BOARD ORDER BY writedate DESC) WHERE NUM > ? AND NUM <= ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, start + 5);
		
		ResultSet rs = st.executeQuery();
		ArrayList<BoardDto> ar = new ArrayList<BoardDto>();
		
		while(rs.next()) {
			ar.add(new BoardDto(rs.getInt("boardnum"), rs.getString("title"), rs.getString("contents"), rs.getString("writer"), rs.getDate("writedate"), rs.getInt("viewcount")));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}

	@Override
	public BoardDto getDetail(Integer boardNum) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String viewCountAddSql = "UPDATE board SET viewcount = viewcount + 1 WHERE boardnum = ?";
		
		PreparedStatement st = con.prepareStatement(viewCountAddSql);
		st.setInt(1, boardNum);
		st.executeUpdate();
		
		String sql = "SELECT * FROM board WHERE boardnum=?";
		
		st = con.prepareStatement(sql);
		
		st.setInt(1, boardNum);
		
		ResultSet rs = st.executeQuery();
		
		BoardDto result = null;
		
		if(rs.next()) {
			result = new BoardDto(rs.getInt("boardnum"), rs.getString("title"), rs.getString("contents"), rs.getString("writer"), rs.getDate("writedate"), rs.getInt("viewcount"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}

	@Override
	public int addBoard(BoardDto boardDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO board(title, contents, writer) VALUES(?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDto.getTitle());
		st.setString(2, boardDto.getContents());
		st.setString(3, boardDto.getWriter());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql="UPDATE board SET title = ?, contents = ?, viewcount = viewcount - 1 WHERE boardnum = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDto.getTitle());
		st.setString(2, boardDto.getContents());
		st.setInt(3, boardDto.getBoardNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int deleteBoard(Integer boardNum) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "DELETE FROM board WHERE boardnum = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardNum);
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int getLength() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT COUNT(*) FROM board";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		int length = 0;
		
		if(rs.next()) {
			length = rs.getInt("COUNT(*)");
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return length;
	}

}
