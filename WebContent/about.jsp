<%@page import="ncs_java_yhs3.dto.Comment"%>
<%@page import="java.util.List"%>
<%@page import="ncs_java_yhs3.dto.Board"%>
<%@page import="ncs_java_yhs3.dao.CommentDao"%>
<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao bDao = BoardDao.getInstance();
	CommentDao cDao = CommentDao.getInstance();
	
	int bIdx = Integer.parseInt(request.getParameter("idx"));
	Board board = bDao.selectBoardByIdx(bIdx);
	List<Comment> list = cDao.selectListByBidx(bIdx);
%>
<div>
	<h2>게시물 조회</h2>
	<form action="/ncs_java_yhs3/index.jsp?pp=updateBoard&idx=<%=bIdx%>" method="post" id="toUpdate">
		<table>
			<tr>
				<td colspan="2">제목 : <%=board.getSubject() %></td>
			</tr>
			<tr>
				<td>작성자 : <%=board.getWriter() %></td>
				<td>작성일 : <%=board.getConDate() %></td>
			</tr>
			<tr>
				<td colspan="2"><%=board.getContent() %></td>
			</tr>
		</table>
	</form>
</div>
<div>
	<table>
		<tr>
			<td colspan="2">댓글조회</td>
		</tr>
		<% if(list != null){ %>
			<% for(Comment comment : list){  %>
				<tr>
					<td><%=comment.getWriter() %> / <%=comment.getContent() %> / <%=comment.getComDate() %> / </td>
					<td><a href="/ncs_java_yhs3/deleteCom.jsp?delete=y&idx=<%=comment.getIdx()%>&bIdx=<%=comment.getbIdx()%>">삭제</a></td>
				</tr>
			<% } %>
		<% } %>
	</table>
</div>
<div>
	<form action="/ncs_java_yhs3/deleteCom.jsp?delete=n&bIdx=<%=bIdx%>" method="post" id="insertCom">
		<table>
			<tr>
				<td colspan="2">댓글 작성 / 성함 : <input type="text" name="writer" id="writer"></td>
			</tr>
			<tr>
				<td><input type="text" name="content" id="content"></td>
				<td><button type="submit" onclick="insertCom(); return false">작성완료</button></td>
			</tr>
		</table>
	</form>
</div>
<form action="/ncs_java_yhs3/deleteBoard.jsp?idx=<%=bIdx %>" method="post" id="toDelete">
</form>
<div>
	<button type="button" onclick="toList()">목록</button>
	<button type="submit" onclick="okUpdate()">수정</button>
	<button type="submit" onclick="okDelete()" >삭제</button>
</div>






