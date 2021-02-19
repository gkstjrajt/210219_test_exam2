<%@page import="ncs_java_yhs3.dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao dao = BoardDao.getInstance();
	List<Board> list = dao.selectBoardByAll();
	int count = dao.getNextIdx()-1;
%>
<div>
	총 <%=count %>개의 게시물이 있습니다.
		<table border="1px solid black">
			<thead>
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<% for(Board board : list) { %>
					<tr>
						<td><%=board.getIdx() %></td>
						<td><%=board.getWriter() %></td>
						<td><a href="/ncs_java_yhs3/index.jsp?pp=about&idx=<%=board.getIdx()%>"><%=board.getSubject() %></a></td>
						<td><%=board.getConDate() %></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<div>
		<button type="button" onclick="toInsert()">작성</button>
	</div>
</div>