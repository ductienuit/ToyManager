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
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}" role="alert">
                        ${message}
                </div>
            </c:if>
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

                                                    <form id="insertCategoryForm" method="post"
                                                          action="<c:url value='/admin-category'/>">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;
                                                        </button>
                                                        <h4 class="blue bigger">Thêm loại đồ chơi</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-xs-12">
                                                                <div class="form-group">
                                                                    <label >Tên loại đồ
                                                                        chơi</label>
                                                                    <div>
                                                                        <input type="text" name="name" required/>
                                                                    </div>
                                                                </div>
                                                                <div class="space-4"></div>
                                                                <div class="form-group">
                                                                    <label >Code</label>
                                                                    <div>
                                                                        <input type="text" name="code" id="macode" placeholder="Vi du: the-thao" required/>
                                                                        <input type="hidden" name="command" value="insert">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button class="btn btn-sm btn-primary" onclick="addCategory()" >
                                                            <i class="ace-icon fa fa-check"></i>
                                                            Thêm
                                                        </button>
                                                        <button class="btn btn-sm" data-dismiss="modal">
                                                            <i class="ace-icon fa fa-times"></i>
                                                            Hủy
                                                        </button>
                                                    </div>
                                                </form>
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
                                            <th>Id</th>
                                            <th>Tên loại đồ chơi</th>
                                            <th>Code</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td>${item.name}</td>
                                                <td>${item.code}</td>
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
                                    <form action="<c:url value='/admin-category'/>" id="formSubmit" method="get">
                                        <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<!-- /.main-content -->
<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var visiblePages = 3; //Số phân trang
    var limit = 10;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('id');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });

    function addCategory() {
        //insertCategoryForm
        $('#insertCategoryForm').submit();
    }
</script>
</body>

</html>