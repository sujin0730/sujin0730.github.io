<%@page import="kr.or.ddit.session.login.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%

	// JSP문서에서의 세션은 'session'이라는 이름으로 저장되어 있다.
	// loginMember의 session은 처음은 null값저장
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");

%>

<body>

<%

	if(loginMember==null) {	//로그인이 안 된 상태
		
%>	

<form action="<%=request.getContextPath()%>/login.do" method="post"> <!-- post방식으로 이동 -->
<table style = "margin : 0 auto;" border = "1">
	<tr>
		<td>ID : </td>
		<td><input type="text" placeholder="ID를 입력하세요" name="userid"></td>
	</tr>
	<tr>
		<td>PASS : </td>
		<td><input type="password" placeholder="PASSWORD를 입력하세요" name="userpass"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center"><input type="submit" value="Login"></td>
	</tr>
</table>

</form>

<%		
	} else {	// 로그인이 되었을때

%>

	<h2><%=loginMember.getMem_name() %>님 반갑습니다.</h2>
	<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
	
<%

	} 

%>
</body>
</html>