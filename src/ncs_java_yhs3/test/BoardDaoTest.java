package ncs_java_yhs3.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ncs_java_yhs3.dao.BoardDao;
import ncs_java_yhs3.dto.Board;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoTest {
	BoardDao dao = BoardDao.getInstance();
	
	@Test
	public void test2SelectBoardByAll() {
		System.out.println("testSelectBoardByAll");
		List<Board> list = dao.selectBoardByAll();
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test5SelectBoardByIdx() {
		System.out.println("testSelectBoardByIdx");
		Board selBoard = dao.selectBoardByIdx(11);
		System.out.println(selBoard);
	}
	
	@Test
	public void test1GetNextIdx() {
		System.out.println("testGetNextIdx");
		int nextIdx = dao.getNextIdx();
		System.out.println(nextIdx);
	}
	
	@Test
	public void test3InsertBoard() {
		System.out.println("testInsertBoard");
		int idx = dao.getNextIdx();
		String writer = "윤한석";
		String subject = "이번엔따자";
		String content = "아자아자아자젤";
		Timestamp conDate = Timestamp.valueOf(LocalDateTime.now());
		Board board = new Board(idx, writer, subject, content, conDate);
		int res = dao.insertBoard(board);
		System.out.println(res);
	}
	
	@Test
	public void test4UpdateBoard() {
		System.out.println("testUpdateBoard");
		Board board = dao.selectBoardByIdx(11);
		board.setWriter("윤따란석");
		board.setSubject("이미딴듯!");
		int res = dao.updateBoard(board);
		System.out.println(res);
	}
	
	@Test
	public void test6DeleteBoard() {
		System.out.println("testDeleteBoard");
		int res = dao.deleteBoard(11);
		System.out.println(res);
	}
}














