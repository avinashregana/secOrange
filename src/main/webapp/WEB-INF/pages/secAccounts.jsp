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
<title>Secure Accounts</title>
</head>
<body>
	<h1>Your Secure Accounts</h1>
	<spring:url value="/lazy" var="addressUrl" />
	<spring:url value="/sortByDate" var="dateSort" />
	<spring:url value="/sortByCompany" var="companySort" />
	<table>
		<tr>
			<td><a href="${companySort}">Company</a></td>
			<td><c:out value="AccountUserName"></c:out></td>
			<td><c:out value="AccountPassword"></c:out></td>
			<td><c:out value="Email"></c:out></td>
			<td><c:out value="companyUrl"></c:out></td>
			<td><c:out value="CustomerUserName"></c:out></td>
			<td><c:out value="AccountId"></c:out></td>
			<td><c:out value="Country"></c:out></td>
			<td><c:out value="CreateDate"></c:out></td>
			<td><c:out value="UpdateDate"></c:out></td>
			<td><c:out value="Address"></c:out></td>
		</tr>
		<c:forEach items="${SecAccountsList}" var="account">
			<tr>


				<td><c:out value="${account.getCompanyName()}" /></td>
				<td><c:out value="${account.getAccountUserName()}" /></td>
				<td><c:out value="${account.getAccountPassword()}" /></td>
				<td><c:out value="${account.getAccountEmail()}" /></td>
				<td><c:out value="${account.getCompanyUrl()}" /></td>
				<td><c:out value="${account.getCustomerUserName()}" /></td>
				<td><c:out value="${account.getId()}" /></td>
				<td><c:out value="${account.getCountry()}" /></td>
				<td><c:out value="${account.createDate}" /></td>
				<td><c:out value="${account.updateDate}" /></td>


				<c:choose>
					<c:when
						test="${(not empty AccId) &&(not empty account.addressPOJO)&&(account.id eq AccId)}">
						<td><c:out value="${account.addressPOJO.addr_line1}" />,<c:out
								value="${account.addressPOJO.city}" />,<c:out
								value="${account.addressPOJO.country}" /></td>
					</c:when>
					<c:otherwise>
						<td><a href="${addressUrl}?AccId=${account.id}">Address</a></td>
					</c:otherwise>
				</c:choose>

			</tr>


		</c:forEach>
	</table>

	<spring:url value="/SearchString" var="searchKey" />
	<form:form class="form-horizontal" method="post"
		modelAttribute="string" action="${searchKey}">
		<table>
			<tr>
				<td><form:input type="text" path="search" placeholder="search"
						id="searchParm" /></td>
				<td><button type="submit">search</button></td>
			</tr>
		</table>
	</form:form>

<br>
	<div>
		<a href="${dateSort}">sort by date</a>
	</div>


</body>
</html>