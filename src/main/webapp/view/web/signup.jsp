<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 22/05/2019
  Time: 9:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <h3 class="breadcrumb-header">Đăng ký</h3>
                <ul class="breadcrumb-tree">
                    <li><a href="<c:url value="/trang-chu" ></c:url>">Trang chủ</a></li>
                    <li class="active">Đăng ký</li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="row">
                <div class="col-sm-10">
                    <h1>Thông tin đăng ký</h1>
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" role="alert">
                                ${message}
                        </div>
                    </c:if>
                </div>

            </div>
            <div class="row">
                <!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Thông tin đăng ký</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form" action="<c:url value='/dang-ky?action=signup'/>" method="post" id="registrationForm">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="username">
                                            <h4>Tên tài khoản</h4>
                                        </label>
                                        <input type="text" class="form-control" name="username" id="username"
                                               placeholder="Tài khoản">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="fullName">
                                            <h4>Họ và tên</h4>
                                        </label>
                                        <input type="text" class="form-control" name="fullName" id="fullName"
                                               placeholder="Họ và tên">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phoneNumber">
                                            <h4>Số điện thoại</h4>
                                        </label>
                                        <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                                               placeholder="Nhập số điện thoại">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email">
                                            <h4>Email</h4>
                                        </label>
                                        <input type="email" class="form-control" name="email" id="email"
                                               placeholder="you@email.com">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="address">
                                            <h4>Địa chỉ</h4>
                                        </label>
                                        <input type="text" class="form-control" id="address" name="address"
                                               placeholder="Nhập địa chỉ giao hàng">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="password">
                                            <h4>Mật khẩu mới</h4>
                                        </label>
                                        <input type="password" class="form-control" name="password" id="password"
                                               placeholder="Mật khẩu mới" title="Nhập mật khẩu mới">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success" type="submit">Đăng ký</button>
                                    </div>
                                </div>
                            </form>

                            <hr>

                        </div>
                    </div>
                    <!--/tab-pane-->
                </div>
                <!--/tab-content-->

            </div>
            <!--/col-9-->
        </div>
        <!--/row-->
    </div>
    <!-- /row -->
</div>
<!-- /container -->
</div>
<!-- /SECTION -->
</body>
</html>



