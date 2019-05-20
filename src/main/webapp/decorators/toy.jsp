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

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/toy/css/bootstrap.min.css'/>"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/toy/css/slick.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/toy/css/slick-theme.css'/>"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href='<c:url value='/template/toy/css/nouislider.min.css'/>'/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="<c:url value='/template/toy/css/font-awesome.min.css'/>"/>

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/toy/css/style.css'/>"/>

</head>
<body>
<!--        header-->
<%@include file="/common/toy/header.jsp" %>
<!--body-->
<div class="container">
    <dec:body/>
</div>
<!--footer-->
<%@include file="/common/toy/footer.jsp" %>


<!-- jQuery Plugins -->
<script type="text/javascript" src="<c:url value='/template/toy/js/jquery.min.js' />"></script>
<script src="<c:url value='/template/toy/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/toy/js/slick.min.js'/>"></script>
<script src="<c:url value='/template/toy/js/nouislider.min.js'/>"></script>
<script src="<c:url value='/template/toy/js/jquery.zoom.min.js'/>"></script>
<script src="<c:url value='/template/toy/js/main.js'/>"></script>
</body>
</html>
