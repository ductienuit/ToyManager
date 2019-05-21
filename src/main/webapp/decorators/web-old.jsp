<%--
    Document   : web
    Created on : May 8, 2019, 2:49:13 PM
    Author     : DucTien
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Trang chủ"/></title>

    <!--        css-->
    <link href="<c:url value='/template/web-old/css/styles.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web-old/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"
          media="all"/>

</head>
<body>
<!--        header-->
<%@include file="/common/web-old/header.jsp" %>
<!--body-->
<div class="container">
    <dec:body/>
</div>
<!--footer-->
<%@include file="/common/web-old/footer.jsp" %>
<scipt type="text/javascript" src="<c:url value='/template/web-old/jquery/jquery.min.js'/>"></scipt>
<scipt type="text/javascript" src="<c:url value='/template/web-old/bootstrap/js/bootstrap.bundle.min.js'/>"></scipt>
</body>
</html>
