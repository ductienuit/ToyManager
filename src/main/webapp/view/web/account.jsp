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
                    <h1>Lê Đức Tiến</h1>
                </div>

            </div>
            <div class="row">
                <div class="col-sm-3">
                    <!--left col-->

                    <div class="text-center">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                             class="avatar img-circle img-thumbnail" alt="avatar">
                        <h6>Tải lên ảnh đại diện</h6>
                        <input type="file" class="text-center center-block file-upload">
                    </div>
                    </hr><br>

                </div>
                <!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Thông tin cá nhân</a></li>
                        <li><a data-toggle="tab" href="#messages">Đơn hàng của bạn</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form" action="##" method="post" id="registrationForm">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="username">
                                            <h4>Họ và tên</h4>
                                        </label>
                                        <input type="text" class="form-control" name="first_name" id="first_name"
                                               placeholder="Họ và tên">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone">
                                            <h4>Số điện thoại</h4>
                                        </label>
                                        <input type="text" class="form-control" name="phone" id="phone"
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
                                        <label for="email">
                                            <h4>Địa chỉ</h4>
                                        </label>
                                        <input type="email" class="form-control" id="location"
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
                                    <th>Sản phẩm</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>Feb 12</td>
                                    <td>
                                        <a href="#">Đồ chơi búp bê siêu tốc</a>
                                    </td>
                                    <td>$45</td>

                                    <td class="hidden-480">
                                        <!-- <span class="label label-sm label-warning">Expiring</span> -->
                                        <!-- <span class="label label-sm label-success">Registered</span> -->
                                        <span class="label label-sm label-danger">Important</span>
                                    </td>

                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button class="btn btn-xs btn-success">
                                                <i class="ace-icon fa fa-check bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-info">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-danger">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Feb 12</td>
                                    <td>
                                        <a href="#">Đồ chơi búp bê siêu tốc</a>
                                    </td>
                                    <td>$45</td>

                                    <td class="hidden-480">
                                        <!-- <span class="label label-sm label-warning">Expiring</span> -->
                                        <!-- <span class="label label-sm label-success">Registered</span> -->
                                        <span class="label label-sm label-danger">Important</span>
                                    </td>

                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button class="btn btn-xs btn-success">
                                                <i class="ace-icon fa fa-check bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-info">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-danger">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Feb 12</td>
                                    <td>
                                        <a href="#">Đồ chơi búp bê siêu tốc</a>
                                    </td>
                                    <td>$45</td>

                                    <td class="hidden-480">
                                        <!-- <span class="label label-sm label-warning">Expiring</span> -->
                                        <!-- <span class="label label-sm label-success">Registered</span> -->
                                        <span class="label label-sm label-danger">Important</span>
                                    </td>

                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button class="btn btn-xs btn-success">
                                                <i class="ace-icon fa fa-check bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-info">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-danger">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
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



