<%--
    Document   : login
    Created on : May 19, 2019, 4:05:22 PM
    Author     : DucTien
--%>

<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <div class="login-form">
        <div class="main-div">

            <form action="<c:url value='/dang-nhap?action=login'/>" id="formSubmit" method="post">
                <div class="panel">
                    <h2>Đăng nhập</h2>
                    <p>Please enter your email and password</p>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}" role="alert">
                            ${message}
                    </div>
                </c:if>

                <form id="Login">
                    <div class="form-group">

                        <input type="text" class="form-control" id="inputEmail" placeholder="Tên đăng nhập"
                               name="userName">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Mật khẩu"
                               name="password">
                    </div>
                    <input type="hidden" value="login" name="userName"/>
                    <input type="hidden" value="" id="maxPageItem" name="password"/>

                    <button type="submit" class="btn btn-primary">Login</button>

                </form>
            </form>
        </div>
        <p class="botto-text"> Designed by Toy Manager</p>
    </div>
</div>
</body>
</html>
