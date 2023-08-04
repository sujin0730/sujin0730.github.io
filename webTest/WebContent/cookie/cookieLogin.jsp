<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 로그인</title>
<style>

</style>
</head>
<%	
// 입력은 html에 자바명령으로 하는것 처럼 보이지만 jsp로 실행될때는 servlet으로 바뀜
// request객체, response객체를 쓸수 있음
Cookie[] cookieArr = request.getCookies();		// request로 쿠키 전체정보를 가져옴
String cookieUserId = "";						// 쿠키에 저장된 userid값이 저장될 변수
String chk = "";								// 체크박스의 체크여부를 나타낼 변수


if(cookieArr != null) {					
	for(Cookie cookie : cookieArr) {		// 쿠키배열 갯수만큼 반복
		String name = cookie.getName();
		if("USERID".equals(cookie.getName())) {	// 원하는 쿠키이름 찾기	
			cookieUserId = cookie.getValue();	// 쿠키값 구하기
			chk = "checked";
		
		}
	}
}

%>

<body>
<h3 style="text-align:center">Login 페이지</h3><hr>
	<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
		<table style="margin: 0 auto;">
			<tr>
				<td>ID :</td>
				<td><input type="text" placeholder="ID를 입력하세요" name="userid" value="<%=cookieUserId%>"></td>
			</tr>
			<tr>
				<td>PASS :</td>
				<td><input type="password" placeholder="PassWord를 입력하세요" name="userpass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="chkid" value="check" <%=chk%>> id 기억하기</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>