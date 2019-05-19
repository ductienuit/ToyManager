<%--
    Document   : web
    Created on : May 8, 2019, 2:49:13 PM
    Author     : DucTien
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><dec:title default="Đăng nhập"/></title>
        <!--css-->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="<c:url value='/template/login/styles.css'/>" rel="stylesheet" type="text/css" media="all"/>
    </head>
    <body id="LoginForm">
        <!--body-->
        <div class="container">
            <dec:body/>
        </div>
    </body>
</html>
