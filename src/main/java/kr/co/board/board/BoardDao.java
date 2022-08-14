package kr.co.board.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.board.util.DBConnector;

public class BoardDao {
	
	public ArrayList<BoardDto> getList() throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM board";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<BoardDto> ar = new ArrayList<BoardDto>();
		
		while(rs.next()) {
			ar.add(new BoardDto(rs.getInt("boardnum"), rs.getString("title"), rs.getString("contents"), rs.getString("writer"), rs.getDate("writedate"), rs.getInt("viewcount")));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}

}
