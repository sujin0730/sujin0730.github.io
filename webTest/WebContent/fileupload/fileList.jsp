<%@page import="kr.or.ddit.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 서블릿에서 보내온 자료를 받는다.
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileList");
%>


<body>
<h3>전체 파일 목록</h3><br><hr>

<a href="<%=request.getContextPath() %>/fileUpload.do">파일 업로드</a><br>

<table border="1">
<thead>
	<tr>
		<th>번호</th><th>작성자</th><th>저장파일명</th><th>원래의 파일명</th>
		<th>파일 크기</th><th>날짜</th><th>비고</th>
	</tr>

</thead>

<%
	if(fileList==null || fileList.size()==0) {
%>
	<tr>
		<td colspan="7">파일 목록이 하나도 없습니다...</td>
	</tr>		
<%		
	} else {
		for(FileInfoVO fvo : fileList) {
%>
	<tr>
		<th><%=fvo.getFile_no() %></th>
		<th><%=fvo.getFile_writer() %></th>
		<th><%=fvo.getSave_file_name() %></th>
		<th><%=fvo.getOrigin_file_name() %></th>
		<th><%=fvo.getFile_size() %></th>
		<th><%=fvo.getFile_date() %></th>
		<th><a href="<%=request.getContextPath()%>/fileDownload.do?fileno=<%=fvo.getFile_no()%>">Download</a></th>
	</tr>
	
<%			
		}
	}
%>
</table>
</body>
</html>