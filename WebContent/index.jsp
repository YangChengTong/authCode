<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reloadImage(){
		document.getElementById('btn').disabled = true;
		document.getElementById('identity').src = 'authCode/authCodeServlet?ts='+new Date().getTime();
	}
</script>
</head>
<body>
	<img alt="this is my authcode" src="authCode/authCodeServlet" id="identity" onclick="btn.disabled = false;" />
	<a href="#" onclick="reloadImage()" id="btn">看不清楚？换一张</a>
</body>
</html>