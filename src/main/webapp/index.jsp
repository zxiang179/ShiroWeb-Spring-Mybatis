<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login.do" method="post">
	username:<input value="${user.username }" type="text" name="userName"><br>
	password:<input value="${user.password }" type="password" name="password"><br>
	<input type="submit" value="登录"> <font color="red">${errorMsg }</font>
</form>

</body>
</html>