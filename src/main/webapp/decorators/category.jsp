<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 21/05/2019
  Time: 10:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Danh mục"/></title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/>"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/slick.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/slick-theme.css'/>"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href='<c:url value='/template/web/css/nouislider.min.css'/>'/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/font-awesome.min.css'/>"/>

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>"/>

</head>
<body>
<!--        header-->
<%@include file="/common/web/header.jsp" %>
<!--body-->
<div class="container">
    <dec:body/>
</div>
<!--footer-->
<%@include file="/common/web/footer.jsp" %>


<!-- jQuery Plugins -->
<script type="text/javascript" src="<c:url value='/template/web/js/jquery.min.js' />"></script>
<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/js/slick.min.js'/>"></script>
<script src="<c:url value='/template/web/js/nouislider.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.zoom.min.js'/>"></script>
<script src="<c:url value='/template/web/js/main.js'/>"></script>
</body>
</html>

