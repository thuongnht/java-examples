<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>CREATE ORDER</h3>
<p/>

<div>

<form:form method="post" commandName="offer" action="${pageContext.request.contextPath}/offer/form/create">

<table>
<tr>
<td>Name: </td>
<td><form:input path="name" />
</td>
<td><form:errors path="name" cssClass="error"/>
</td>
</tr>
<tr>
<td>Email: </td>
<td><form:input path="mail" />
</td>
<td><form:errors path="mail" cssClass="error"/>
</td>
</tr>
<tr>
<td>Offer: </td>
<td><form:textarea rows="10" cols="20" path="text"></form:textarea></td>
<td><form:errors path="text" cssClass="error"/></td>
</tr>
<tr>
<td> </td>
<td><div class="status"><c:out value="${status==null?'':status}" escapeXml="false"></c:out></div></td>
<td> </td>
</tr>
<tr>
<td> </td>
<td><input type="submit" name="submit" /></td>
<td> </td>
</tr>

</table>

</form:form>

</div>
