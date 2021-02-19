<%@page import="ncs_java_yhs3.dto.Board"%>
<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao dao = BoardDao.getInstance();
	int bIdx = Integer.parseInt(request.getParameter("idx"));
	Board board = dao.selectBoardByIdx(bIdx);
%>
<h2>게시물 작성</h2>
<form action="/ncs_java_yhs3/write.jsp?update=y&bIdx=<%=bIdx %>" method="post" id="update">
	<table border="1px solid black">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="writer" value="<%=board.getWriter() %>"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject" value="<%=board.getSubject() %>"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" id="content"><%=board.getContent() %></textarea></td>
		</tr>
	</table>
</form>
<div>
	<button type="button" onclick="toBack()">취소</button>
	<button type="submit" onclick="updateBoard(); return false">완료</button>
</div>