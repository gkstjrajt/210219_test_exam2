<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ncs_java_yhs3.dto.Board"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao dao = BoardDao.getInstance();
	
	
	
	
	
	
	
	if(request.getParameter("update").equals("n")){
		int idx = dao.getNextIdx();
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Timestamp conDate = Timestamp.valueOf(LocalDateTime.now());
		Board board = new Board(idx, writer, subject, content, conDate);
%>

<script type="text/javascript">
	alert("게시물 작성 완료");
</script>		

<%		dao.insertBoard(board); %>

<script type="text/javascript">
	location.href = "/ncs_java_yhs3/index.jsp?pp=list";
</script>

<%	} else {	
	int bIdx = Integer.parseInt(request.getParameter("bIdx"));
	Board board = dao.selectBoardByIdx(bIdx);
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	Timestamp conDate = board.getConDate(); 
	
	board = new Board(bIdx, writer, subject, content, conDate);%>
		
<script type="text/javascript">
	alert("게시물 수정 완료");
</script>

<%		dao.updateBoard(board); %>

<script type="text/javascript">
	location.href = "/ncs_java_yhs3/index.jsp?pp=about&idx=<%=bIdx %>"
</script>

<%	}  %>

