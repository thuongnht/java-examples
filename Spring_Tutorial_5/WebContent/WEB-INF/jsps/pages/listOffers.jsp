<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>OFFER LIST</h3>
<p/>

<div>

<table>
<thead><td>ID</td><td>Name</td><td>Email</td><td>Offer</td><td> </td><td> </td>
</thead>
<c:forEach var="offer" items="${offers}">
<tr>
<td><input type="hidden" name="id" value="${ offer.id }" />
<a href="${pageContext.request.contextPath}/offer/list/?id=${offer.id}">${offer.id }</a></td>
<td><input name="name" type="text" value="${ offer.name }" /></td> 
<td><input name="mail" type="text" value="${ offer.mail }" /></td> 
<td><textarea rows="1" cols="20" name="text">${ offer.text }</textarea></td> 
<td>
<a href="${pageContext.request.contextPath}/offer/delete/?id=${offer.id}">delete</a>
</td>
<td>
<a href="${pageContext.request.contextPath}/offer/update/?id=${offer.id}">update</a>
</td>
</tr>
</c:forEach>
</table>


</div>

