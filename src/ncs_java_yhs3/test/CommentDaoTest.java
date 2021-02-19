package ncs_java_yhs3.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ncs_java_yhs3.dao.CommentDao;
import ncs_java_yhs3.dto.Comment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommentDaoTest {
	CommentDao dao = CommentDao.getInstance();

	@Test
	public void test3SelectListByBidx() {
		System.out.println("testSelectListByBidx");
		List<Comment> list = dao.selectListByBidx(10);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test1GetNextIdx() {
		System.out.println("testGetNextIdx");
		int idx = dao.getNextIdx();
		System.out.println(idx);
	}
	
	@Test
	public void test2InsertComment() {
		System.out.println("testInsertComment");
		int idx = dao.getNextIdx();
		int bIdx = 10;
		String writer = "윤땀석";
		String content = "화이팅!";
		Timestamp comDate = Timestamp.valueOf(LocalDateTime.now());
		Comment comment = new Comment(idx, bIdx, writer, content, comDate);
		int res = dao.insertComment(comment);
		System.out.println(res);
	}
	
	@Test
	public void test4DeleteComment() {
		System.out.println("testDeleteComment");
		int res = dao.deleteComment(11);
		System.out.println(res);
	}
	
	@Test
	public void test5SelectCommentsByBIdx() {
		System.out.println("test5SelectCommentsByBIdx");
		for(int i = 0; i < dao.selectListByBidx(3).size(); i++) {
			Comment comment = dao.selectCommentsByBIdx(3);
			System.out.println(comment);
		}
	}

}



