<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 22/05/2019
  Time: 3:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thêm tài khoản</title>
</head>

<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Tài khoản</li>
            </ul><!-- /.breadcrumb -->

            <div class="nav-search" id="nav-search">
                <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off">
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="ace-settings-container" id="ace-settings-container">
                <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                    <i class="ace-icon fa fa-cog bigger-130"></i>
                </div>

                <div class="ace-settings-box clearfix" id="ace-settings-box">
                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <div class="pull-left">
                                <select id="skin-colorpicker" class="hide">
                                    <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                    <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                    <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                    <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                </select>
                                <div class="dropdown dropdown-colorpicker"><a data-toggle="dropdown"
                                                                              class="dropdown-toggle"><span
                                        class="btn-colorpicker" style="background-color:#438EB9"></span></a>
                                    <ul class="dropdown-menu dropdown-caret">
                                        <li><a class="colorpick-btn selected" style="background-color:#438EB9;"
                                               data-color="#438EB9"></a></li>
                                        <li><a class="colorpick-btn" style="background-color:#222A2D;"
                                               data-color="#222A2D"></a></li>
                                        <li><a class="colorpick-btn" style="background-color:#C6487E;"
                                               data-color="#C6487E"></a></li>
                                        <li><a class="colorpick-btn" style="background-color:#D0D0D0;"
                                               data-color="#D0D0D0"></a></li>
                                    </ul>
                                </div>
                            </div>
                            <span>&nbsp; Choose Skin</span>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
                                   id="ace-settings-navbar" autocomplete="off">
                            <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
                                   id="ace-settings-sidebar" autocomplete="off">
                            <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
                                   id="ace-settings-breadcrumbs" autocomplete="off">
                            <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"
                                   autocomplete="off">
                            <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
                                   id="ace-settings-add-container" autocomplete="off">
                            <label class="lbl" for="ace-settings-add-container">
                                Inside
                                <b>.container</b>
                            </label>
                        </div>
                    </div><!-- /.pull-left -->

                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover"
                                   autocomplete="off">
                            <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact"
                                   autocomplete="off">
                            <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight"
                                   autocomplete="off">
                            <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                        </div>
                    </div><!-- /.pull-left -->
                </div><!-- /.ace-settings-box -->
            </div><!-- /.ace-settings-container -->

            <div class="page-header">
                <h1>
                    Tài khoản
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        Sửa tài khoản
                    </small>
                </h1>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form class="form-horizontal" role="form" id="addAccount" method="post">
                        <input type="hidden" name="command" value="edit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="username"> Tài
                                khoản</label>

                            <div class="col-sm-9">
                                <input type="text" name="username" placeholder="Username"
                                       class="col-xs-10 col-sm-5" id="username" value="${model.username}" readonly>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="fullName"> Họ và
                                tên </label>

                            <div class="col-sm-9">
                                <input type="text" id="fullName" placeholder="Họ và tên" name="fullName"
                                       class="form-control" value="${model.fullName}">
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="password"> Mật
                                khẩu </label>

                            <div class="col-sm-9">
                                <input type="password" id="password" placeholder="Nhập mật khẩu" name="password"
                                       class="col-xs-10 col-sm-5" value="${model.password}">
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="address"> Địa
                                chỉ </label>

                            <div class="col-sm-9">
                                <input type="text" id="address" placeholder="Địa chỉ" name="address"
                                       class="form-control" value="${model.address}">
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="email"> Email </label>

                            <div class="col-sm-9">
                                <input type="email" id="email" placeholder="Nhập email" name="email"
                                       class="form-control" value="${model.email}">
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-5">
                                Số điện thoại </label>

                            <div class="col-sm-9">
                                <input type="number" id="form-field-5" placeholder="Nhập số điện thoại"
                                       name="phoneNumber"
                                       class="form-control" value="${model.phoneNumber}">
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="quyen">
                                Phân quyền </label>
                            <div class="col-sm-9">
                                <select class="form-control"
                                        id="quyen">
                                    <c:choose>

                                        <c:when test = "${model.role.priority > 1}">
                                            <option value="1">Người dùng</option>
                                            <option value="2" selected="selected">Quản trị viên</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="1" selected="selected">Người dùng</option>
                                            <option value="2">Quản trị viên</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" id="roleId" name="roleId">

                        <div class="space-4"></div>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button class="btn btn-info" type="button" onclick="submitEditUser()">
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Submit
                                </button>
                                <button class="btn" type="reset" onclick="history.go(0)">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Reset
                                </button>
                            </div>
                        </div>

                    </form>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div>
<!-- /.main-content -->

<script type="text/javascript">

    $("input#username").on({
        keydown: function (e) {
            if (e.which === 32)
                return false;
        },
        change: function () {
            this.value = this.value.replace(/\s/g, "");
        }
    });
    var selectedCountry = 1;
    $("select.form-control").change(function () {

        var selectedCountry = $(this).children("option:selected").val();
    });

    function submitEditUser() {
        $('#roleId').val(selectedCountry);
        $('#addAccount').submit();
    }

</script>
</body>

</html>


