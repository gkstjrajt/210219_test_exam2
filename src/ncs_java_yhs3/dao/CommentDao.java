package ncs_java_yhs3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ncs_java_yhs3.ds.JdbcUtil;
import ncs_java_yhs3.dto.Comment;

public class CommentDao {
	private static final CommentDao instance = new CommentDao();

	public CommentDao() {
	}

	public static CommentDao getInstance() {
		return instance;
	}

	public List<Comment> selectListByBidx(int bIdx) {
		String sql = "SELECT IDX, BIDX, WRITER, CONTENT, COMDATE FROM COMMENT_TBL WHERE BIDX = ? ORDER BY COMDATE";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bIdx);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Comment> list = new ArrayList<Comment>();
					do {
						list.add(getComment(rs));
					} while (rs.next());
					return list;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private Comment getComment(ResultSet rs) throws SQLException {
		int idx = rs.getInt("IDX");
		int bIdx = rs.getInt("BIDX");
		String writer = rs.getString("WRITER");
		String content = rs.getString("CONTENT");
		Timestamp comDate = rs.getTimestamp("COMDATE");
		return new Comment(idx, bIdx, writer, content, comDate);
	}
	
	public int getNextIdx() {
		String sql = "SELECT MAX(IDX)+1 FROM COMMENT_TBL";
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
	
	public int insertComment(Comment comment) {
		String sql = "INSERT INTO COMMENT_TBL VALUES (?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, comment.getIdx());
				pstmt.setInt(2, comment.getbIdx());
				pstmt.setString(3, comment.getWriter());
				pstmt.setString(4, comment.getContent());
				pstmt.setTimestamp(5, comment.getComDate());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteComment(int idx) {
		String sql = "DELETE FROM COMMENT_TBL WHERE IDX = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, idx);
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Comment selectCommentsByBIdx(int bIdx) {
		String sql = "SELECT IDX, BIDX, WRITER, CONTENT, COMDATE FROM COMMENT_TBL WHERE BIDX = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, bIdx);
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return getComment(rs);
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int deleteCommentByBIdx(int bIdx) {
		String sql = "DELETE FROM COMMENT_TBL WHERE BIDX = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, bIdx);
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}














