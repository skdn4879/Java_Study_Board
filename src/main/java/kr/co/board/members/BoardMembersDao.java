package kr.co.board.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.board.util.DBConnector;

public class BoardMembersDao implements MembersDao {
	
	@Override
	public ArrayList<BoardMembersDto> getList() throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM boardmembers";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<BoardMembersDto> ar = new ArrayList<BoardMembersDto>();
		
		while(rs.next()) {
			ar.add(new BoardMembersDto(rs.getString("id"), rs.getString("name")));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}

	@Override
	public int setJoin(BoardMembersDto boardMembersDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO boardmembers VALUES(?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, boardMembersDto.getId());
		st.setString(2, boardMembersDto.getPassword());
		st.setString(3, boardMembersDto.getName());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public BoardMembersDto login(String id, String password) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM boardmembers WHERE id = ? AND password = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		BoardMembersDto boardMembersDto = null;
		
		if(rs.next()) {
			boardMembersDto = new BoardMembersDto(rs.getString("id"), rs.getString("name"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return boardMembersDto;
	}

}
