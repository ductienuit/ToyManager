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
    <form action="<c:url value='/admin-category'/>" id="formSubmit" method="get">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Loại đồ chới</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                                data-target="#myModal"><span>                                                   <i
                                                class="fa fa-plus-circle bigger-100 purple"></i>
                                                    </span>Thêm
                                        </button>

                                        <div id="myModal" class="modal" tabindex="-1">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;
                                                        </button>
                                                        <h4 class="blue bigger">Thêm loại đồ chơi</h4>
                                                    </div>

                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-xs-12">
                                                                <div class="form-group">
                                                                    <label for="form-field-username">Tên loại đồ
                                                                        chơi</label>

                                                                    <div>
                                                                        <input type="text" id="form-field-username"
                                                                               placeholder="Tên loại đồ chơi"/>
                                                                    </div>
                                                                </div>

                                                                <div class="space-4"></div>

                                                                <div class="form-group">
                                                                    <label for="form-field-first">Code</label>

                                                                    <div>
                                                                        <input type="text" id="form-field-first"
                                                                               placeholder="Mã code loại đồ chơi"/>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button class="btn btn-sm" data-dismiss="modal">
                                                            <i class="ace-icon fa fa-times"></i>
                                                            Cancel
                                                        </button>

                                                        <button class="btn btn-sm btn-primary">
                                                            <i class="ace-icon fa fa-check"></i>
                                                            Save
                                                        </button>
                                                        <button class="btn btn-sm">
                                                            <i class="ace-icon fa fa-times"></i>
                                                            Cancel
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Tên loại đồ chơi</th>
                                            <th>Code</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>${item.title}</td>
                                                <td>${item.shortDescriptions}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin-category">
                                                        <c:param name="type" value="edit"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>

                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật loại đồ chơi" href='${editURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <c:url var="deleteURL" value="/admin-category">
                                                        <c:param name="type" value="delete"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-danger btn-edit" data-toggle="tooltip"
                                                       title="Xóa thể loại" href='${deleteURL}'><i
                                                            class="fa fa-trash-o" aria-hidden="true"></i>
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