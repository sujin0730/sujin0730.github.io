<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function(){	// 현재 페이지를 웹브라우저가 읽어서 DOM객체로 구성한 후 실행되는 영역
	
	// 문자열처리
	$("#srtBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=str", 		// 서버로 보낼 데이터 → 파라미터
			// 서블릿으로 요청한 처리의 응답이 성공적으로 반환이 되었을때
			success : function(data){	// data → 응답으로 온 데이터 자동으로 저장된다.
				$("#result").html(data);
			},
			error : function(xhr){
				alert("오류...");
			},
			dataType : "json"	// 응답으로 온 데이터의 타입 → success처리된 데이터
		});
		
	});
	
	// 배열처리
	$("#arrayBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=array", 		// 서버로 보낼 데이터 → 파라미터
			// 서블릿으로 요청한 처리의 응답이 성공적으로 반환이 되었을때
			success : function(data){	// data → 응답으로 온 데이터 자동으로 저장된다.
				let htmlCode="";
				$.each(data, function(i, v){	// i : index / v : i번째 데이터
					htmlCode += i+"번째 값 : "+ v+"<br>";
				});
				
				$("#result").html(htmlCode);
			},
			error : function(xhr){
				alert("오류...");
			},
			dataType : "json"	// 응답으로 온 데이터의 타입 → success처리된 데이터
		});
	});
	
	// 객체처리
	$("#objBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
				type : "post",
				data : "choice=object", // 서버로 보낼 데이터 → 파라미터
				// 서블릿으로 요청한 처리의 응답이 성공적으로 반환이 되었을때
				success : function(data) { // data → 응답으로 온 데이터 자동으로 저장된다.
					//data → {"num":"10","name":"홍길동"}
					let htmlCode = "번호 : " + data.num + "<br>"
					htmlCode += "이름 : " + data.name + "<br>"

					$("#result").html(htmlCode);

				},
				error : function(xhr) {
					alert("오류...");
				},
				dataType : "json" // 응답으로 온 데이터의 타입 → success처리된 데이터
			});
		});

		// List데이터 처리
		$("#listBtn").on("click", function() {
			$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
				type : "post",
				data : "choice=list", // 서버로 보낼 데이터 → 파라미터
				// 서블릿으로 요청한 처리의 응답이 성공적으로 반환이 되었을때
				success : function(data) { // data → 응답으로 온 데이터 자동으로 저장된다.
					//data →[{"num":100,"name":"강감찬"},{"num":200,"name":"이순신"}
					//		{"num":300,"name":"성춘향"},{"num":400,"name":"이몽룡"}]

					let htmlCode = "";
					$.each(data, function(i, v) {
						htmlCode += i + "번째 자료<br>";
						htmlCode += "번호 : " + v.num + "<br>";
						htmlCode += "이름 : " + v.name + "<hr>";

					});

					$("#result").html(htmlCode);

				},
				error : function(xhr) {
					alert("오류...");
				},
				dataType : "json" // 응답으로 온 데이터의 타입 → success처리된 데이터
			});
		});
		
		//Map데이터 처리
		$("#mapBtn").on("click", function() {
			$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
				type : "post",
				data : "choice=map", // 서버로 보낼 데이터 → 파라미터
				// 서블릿으로 요청한 처리의 응답이 성공적으로 반환이 되었을때
				success : function(data) { // data → 응답으로 온 데이터 자동으로 저장된다.
					//data →{"name":"이순신","tel":"010-1234-5678","addr":"대전시 중구 오류동"}
					
					let htmlCode = "이  름 : " + data.name + "<br>"
						htmlCode += "전화번호 : " + data.tel + "<br>"
						htmlCode += "주  소 : " + data.addr + "<br>"

					$("#result").html(htmlCode);

				},
				error : function(xhr) {
					alert("오류...");
				},
				dataType : "json" // 응답으로 온 데이터의 타입 → success처리된 데이터
			});
		});

	});
</script>
<form>
	<input type = "button" id="srtBtn" value="문자열">
	<input type = "button" id="arrayBtn" value="배  열">
	<input type = "button" id="objBtn" value="객  체">
	<input type = "button" id="listBtn" value="리스트">
	<input type = "button" id="mapBtn" value="Map">
</form>
<h3>[응답결과]</h3>
<div id="result"></div>



</body>
</html>