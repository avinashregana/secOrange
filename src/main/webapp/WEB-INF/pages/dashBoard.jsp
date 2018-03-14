<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome to dashBoard</title>
</head>
<body>
	<c:if test="${not empty sucessMessage}">
			<p style="color:red">
				<h3><c:out value="${sucessMessage}" /></h3>
			</p>
		</c:if>
	<br>
	<h2>welcome to dashBoard</h2>

	<br>
	<a href="/secOrange/SecAccounts">SECURE VAULT ACCOUNTS</a>
<br>
	<a href="/secOrange/AddAccount">Add crediantials of new account</a>
	
	
		
</body>
</html>