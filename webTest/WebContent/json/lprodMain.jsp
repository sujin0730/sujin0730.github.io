<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#lprodBtn").on("click",function(){
		$.ajax({	// → 비동기방식 (ajax는 기본값이 비동기)
			url : "<%=request.getContextPath()%>/lprodList.do",
			type : "post",
			//data : 전송할 데이터가 없으면 생략
			success : function(data) {
				let htmlCode="<table border='1'>";
				htmlCode += "<tr><th>LPROD_ID</th><th>LPROD_GU</th><th>LPROD_NM</th></tr>"
				
				$.each(data, function(i,v){
					htmlCode += "<tr><td>"+v.lprod_id+"</td>";
					htmlCode += "<td>"+v.lprod_gu+"</td>";
					htmlCode += "<td>"+v.lprod_nm+"</td></tr>";
				})
				htmlCode += "</table>";
				
				$("#result").html(htmlCode);
				
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"
		});
	});
	//----------------------------------------------------------
	$("#lprodBtn2").on("click",function(){
		location.href = "<%=request.getContextPath()%>/lprodList2.do";
		
	});
	
	
});


</script>


<body>
<!-- 
처리하는 서블릿 URL Mapping → "/lprodList.do"
 -->
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax이용)">
	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기기(Ajax를 사용하지 않기)">
</form>

<h3>Lprod 자료 목록</h3>
<div id="result"></div>

</body>
</html>