
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
<title>register</title>
</head>
<body>
	<h1>you can register here!</h1>

	<br>
	<div>
		<spring:url value="/register" var="registerSubmit" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="register" action="${registerSubmit}">
			<table>
				<tr>
					<td>User Name</td>
					<td><form:input path="username" type="text"
							class="form-control" id="username" placeholder="Username" /></td>
							<td><form:errors path="username" style="color:red;" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" class="form-control"
							id="password" placeholder="password" /></td>
						<td>	<form:errors path="password" style="color:red;" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstname" type="text"
							class="form-control" id="firstname" placeholder="firstname" /></td>
						<td>	<form:errors path="firstname" style="color:red;" /></td>
							
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastname" type="text"
							class="form-control" id="lastname" placeholder="lastname" /></td>
						<td>	<form:errors path="lastname" style="color:red;" /> </td>
				</tr>
				<tr>
					<td>Gender*</td>
					<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
							path="gender" value="F" />Female</td>
						<td>	<form:errors path="gender" style="color:red;" /></td>
				<tr>
					<td>SSN</td>
					<td><form:input path="ssn" type="text" id="ssn"
							placeholder="ssn" /></td>
						<td>	<form:errors path="ssn" style="color:red;" /></td>
				</tr>

				<tr>
					<td>Email*</td>
					<td><form:input path="email" type="text" id="email"
							placeholder="email" /></td>
						<td>	<form:errors path="email" style="color:red;" /></td>
				</tr>

				<tr>
					<td>DOB*</td>
					<td><form:input path="dob" type="text" id="dob"
							placeholder="dob" />
						<td>	<form:errors path="dob" style="color:red;" /></td>
				</tr>

				<tr>
					<td></td>
					<td>
						<button type="submit">Register</button>
					</td>
				</tr>
			</table>
			<c:if test="${not empty result }">
				<p style="color: red">
					<c:out value="${result}" />
				</p>
			</c:if>
			<c:if test="${not empty userNameErr }">
				<p style="color: red">
					<c:out value="${userNameErr}" />
				</p>
			</c:if>
			<c:if test="${not empty passwordErr }">
				<p style="color: red">
					<c:out value="${passwordErr}" />
				</p>
			</c:if>
		</form:form>
	</div>
</body>
</html>