function insert(){
	document.getElementById("insert").submit();
}

function toInsert(){
	alert("게시물 작성");
	window.location.href="/ncs_java_yhs3/index.jsp?pp=insert";
}

function toList(){
	alert("목록으로");
	window.location.href="/ncs_java_yhs3/index.jsp?pp=list";
}

function insertCom(){
	alert("댓글작성 완료");
	document.getElementById("insertCom").submit();
}

function updateBoard(){
	document.getElementById("update").submit();
}

function okUpdate(){
	document.getElementById("toUpdate").submit();
}

function toBack(){
	window.history.back();
}

function okDelete(){
	alert("삭제완료");
	window.location.href="/ncs_java_yhs3/index.jsp?pp=list";
}