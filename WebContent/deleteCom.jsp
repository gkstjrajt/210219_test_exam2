<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ncs_java_yhs3.dto.Comment"%>
<%@page import="ncs_java_yhs3.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	int bIdx = Integer.parseInt(request.getParameter("bIdx"));
	CommentDao dao = CommentDao.getInstance();
	String delete = request.getParameter("delete");
	
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	Timestamp comDate = Timestamp.valueOf(LocalDateTime.now());
	Comment comment = new Comment(dao.getNextIdx(), bIdx, writer, content, comDate);
	
	
	if(delete.equals("y")){
		int idx = Integer.parseInt(request.getParameter("idx"));
		dao.deleteComment(idx);
	} else {
		dao.insertComment(comment);
	}
%>

<script type="text/javascript">
	window.location.href="/ncs_java_yhs3/index.jsp?pp=about&idx=<%=bIdx%>"
</script>