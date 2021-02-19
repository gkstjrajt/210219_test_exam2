package ncs_java_yhs3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ncs_java_yhs3.ds.JdbcUtil;
import ncs_java_yhs3.dto.Board;

public class BoardDao {
	private static final BoardDao instance = new BoardDao();

	public BoardDao() {
	}

	public static BoardDao getInstance() {
		return instance;
	}

	public List<Board> selectBoardByAll() {
		String sql = "SELECT IDX, WRITER, SUBJECT, CONTENT, CONDATE FROM BOARD_TBL ORDER BY IDX";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Board> list = new ArrayList<Board>();
				do {
					list.add(getBoard(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Board getBoard(ResultSet rs) throws SQLException {
		int idx = rs.getInt("IDX");
		String writer = rs.getString("WRITER");
		String subject = rs.getString("SUBJECT");
		String content = rs.getString("CONTENT");
		Timestamp conDate = rs.getTimestamp("CONDATE");
		return new Board(idx, writer, subject, content, conDate);
	}

	public Board selectBoardByIdx(int idx) {
		String sql = "SELECT IDX, WRITER, SUBJECT, CONTENT, CONDATE FROM BOARD_TBL WHERE IDX = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, idx);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBoard(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public int getNextIdx() {
		String sql = "SELECT MAX(IDX)+1 FROM BOARD_TBL";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return rs.getInt(1);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertBoard(Board board) {
		String sql = "INSERT INTO BOARD_TBL VALUES (?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, board.getIdx());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getSubject());
				pstmt.setString(4, board.getContent());
				pstmt.setTimestamp(5, board.getConDate());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateBoard(Board board) {
		String sql = "UPDATE BOARD_TBL SET WRITER = ?, SUBJECT = ?, CONTENT = ? WHERE IDX = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, board.getWriter());
				pstmt.setString(2, board.getSubject());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getIdx());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteBoard(int idx) {
		String sql = "DELETE FROM BOARD_TBL WHERE IDX = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, idx);
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}


















