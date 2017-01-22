<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <spring:url value="/static/css/main.css" var="mainCSS" ></spring:url>
    <link href="${mainCSS}" rel="stylesheet" />    
</head>
  
<body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
        <section id="menu">
            <tiles:insertAttribute name="menu" />
        </section>
             
        <section id="content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
        
        
        
<!-- JS -->
<spring:url value="/static/js/main.js" var="mainJS" ></spring:url>
<script src="${mainJS}"></script>

        
</body>
</html>