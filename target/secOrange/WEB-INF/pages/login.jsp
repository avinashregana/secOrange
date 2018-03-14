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
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />
<link rel="stylesheet" type="text/css"
	href="/WebContent/WEB-INF/resources/css/bootstrap.min.css" />
<script type="text/javascript"
	src="/WebContent/WEB-INF/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Helloo.. Welcome to Spring MVC world!!!!</h1>
	<div class="container">
		<spring:url value="/login" var="loginSubmit" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="loginnnn" action="${loginSubmit}">
			<c:if test="${not empty login }">
				<p style="color: red">
					<c:out value="${login}" />
				</p>
			</c:if>
			<form:input path="username" type="text" class="form-control"
				id="username" placeholder="Username" />
			<form:errors path="username" style="color:red;" />
			<form:password path="password" class="form-control" id="password"
				placeholder="password" />
			<form:errors path="password" style="color:red;" />

			<button type="submit" class="btn-lg btn-primary pull-right">Login
			</button>
		</form:form>
	</div>
	<div>
		New User ? <a href="/secOrange/register">Register Here</a>
	</div>
</body>
</html>