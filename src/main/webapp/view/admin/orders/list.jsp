<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 22/05/2019
  Time: 3:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách thể loại</title>
</head>

<body>
<div class="main-content">
    <form action="<c:url value='/admin-order'/>" id="formSubmit" method="get">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Mã đơn hàng</th>
                                            <th>Ngày đặt hàng</th>
                                            <th>Người đặt</th>
                                            <th>Tổng tiền</th>
                                            <th>Trạng thái đơn hàng</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>1</td>
                                                <td>${item.title}</td>
                                                <td>${item.shortDescriptions}</td>
                                                <td>${item.title}</td>
                                                <td>
                                                    <span class="label label-sm label-warning">Đang chờ</span>
                                                    <span class="label label-sm label-warning">Đang giao</span>
                                                    <span class="label label-sm label-success">Đã giao</span>
                                                    <span class="label label-sm label-danger">Đã hủy</span>
                                                </td>
                                                <td>
                                                    <c:url var="detailURL" value="/admin-order">
                                                        <c:param name="type" value="edit"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>

                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Chi tiết đơn hàng" href='${detailURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- /.main-content -->
<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var visiblePages = 3; //Số phân trang
    var limit = 4;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('title');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
</body>

</html>
