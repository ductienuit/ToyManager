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
                <h3 class="breadcrumb-header">Tài khoản</h3>
                <ul class="breadcrumb-tree">
                    <li><a href="#">Trang chủ</a></li>
                    <li class="active">Tài khoản</li>
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
                    <h1>${USERMODEL.fullName}</h1>
                </div>

            </div>
            <div class="row">
                <!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Thông tin cá nhân</a></li>
                        <li><a data-toggle="tab" href="#messages">Đơn hàng của bạn</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form" action="<c:url value='/tai-khoan?action=edit_account'/>" method="post" id="registrationForm">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name">
                                            <h4>Họ và tên</h4>
                                        </label>
                                        <input type="text" class="form-control" name="fullName" id="first_name"
                                               placeholder="Họ và tên" value="${USERMODEL.fullName}">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone">
                                            <h4>Số điện thoại</h4>
                                        </label>
                                        <input type="number" class="form-control" name="phoneNumber" id="phone"
                                               placeholder="Nhập số điện thoại" value="${USERMODEL.phoneNumber}">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email">
                                            <h4>Email</h4>
                                        </label>
                                        <input type="email" class="form-control" name="email" id="email"
                                               placeholder="you@email.com" value="${USERMODEL.email}">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email">
                                            <h4>Địa chỉ</h4>
                                        </label>
                                        <input type="text" class="form-control" id="location" name="address"
                                               placeholder="Nhập địa chỉ giao hàng" value="${USERMODEL.address}">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="password">
                                            <h4>Mật khẩu mới</h4>
                                        </label>
                                        <input value="${USERMODEL.password}" type="password" class="form-control" name="password" id="password"
                                               placeholder="Mật khẩu mới" name="password" title="Nhập mật khẩu mới">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="password2">
                                            <h4>Nhập lại mật khẩu mới</h4>
                                        </label>
                                        <input type="password" class="form-control" name="password2" id="password2"
                                               placeholder="password2" title="enter your password2.">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success" type="submit">Lưu</button>
                                        <button class="btn btn-lg" type="reset"> Hủy</button>
                                    </div>
                                </div>
                            </form>

                            <hr>

                        </div>
                        <!--/tab-pane-->
                        <div class="tab-pane" id="messages">
                            <table id="simple-table" class="table  table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Ngày mua</th>
                                    <th>Mã đơn hàng</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>

                                <tbody>

                                    <c:forEach var="item" items="${orderList}">
                                    <tr>
                                        <td>${item.orderDate}</td>
                                        <td>
                                            <a href="<c:url value="/checkout?id=${item.id}"></c:url> ">${item.id}</a>
                                        </td>
                                        <td>${item.totalPrice}VND</td>

                                        <td class="hidden-480">
                                                <c:choose>
                                                    <c:when test="${item.orderStatus.id == 1}">
                                                        <span class="label label-sm label-warning">Đang chờ</span>
                                                    </c:when>
                                                    <c:when test="${item.orderStatus.id == 2}">
                                                        <span class="label label-sm label-warning">Đang giao</span>
                                                    </c:when>
                                                    <c:when test="${item.orderStatus.id == 3}">
                                                        <span class="label label-sm label-success">Đã giao</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="label label-sm label-danger">Đã hủy</span>
                                                    </c:otherwise>
                                                </c:choose>
                                        </td>

                                        <td>
                                            <c:choose>
                                                <c:when test="${item.orderStatus.id == 1}">
                                                    <div class="hidden-sm hidden-xs btn-group">
                                                        <form action="<c:url value="/tai-khoan"></c:url>" method="post">
                                                            <button class="btn btn-xs btn-danger" type="submit">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                            <input type="hidden" value="deleteOrder" name="action">
                                                            <input type="hidden" value="${item.id}" name="id">
                                                        </form>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                </c:otherwise>
                                            </c:choose>

                                        </td>
                                    </tr>
                                    </c:forEach>


                                </tbody>
                            </table>

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



