<%@page import="ncs_java_yhs3.dao.CommentDao"%>
<%@page import="ncs_java_yhs3.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardDao dao = BoardDao.getInstance();
	CommentDao cDao = CommentDao.getInstance();
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	dao.deleteBoard(idx);
	cDao.deleteCommentByBIdx(idx);
	
%>
<script type="text/javascript">
	location.href = "/ncs_java_yhs3/index.jsp?pp=list";
</script>