<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao dao = BoardDao.getInstance();
	int idx = dao.getNextIdx();
%>
<h2>게시물 작성</h2>
<form action="/ncs_java_yhs3/write.jsp?update=n&idx=<%=idx %>" method="post" id="insert">
	<table border="1px solid black">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="writer"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" id="content"></textarea></td>
		</tr>
	</table>
</form>
<div>
	<button type="button" onclick="toList()">목록</button>
	<button type="submit" onclick="insert(); return false">완료</button>
</div>