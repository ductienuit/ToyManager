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
                        <a href="#">Đơn hàng ${model.id}</a>
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
                                            <th>Mã đồ chơi</th>
                                            <th>Ngày đặt hàng</th>
                                            <th>Tên đồ chơi</th>
                                            <th>Đơn giá</th>
                                            <th>Số lượng</th>
                                            <th>Tổng tiền</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.orderDetails}">
                                            <tr>
                                                <td>${item.toy.id}</td>
                                                <td>${model.orderDate}</td>
                                                <td>${item.toy.name}</td>
                                                <td>${item.toy.price}</td>
                                                <td>${item.quantity}</td>
                                                <td>${item.totalPrice}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <form action="<c:url value='/admin-order'/>" id="formSubmit" method="post">
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                    <input type="hidden" value="edit" id="command" name="command"/>
                                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                                        <input type="hidden" value="" id="idOrderStatus" name="idOrderStatus"/>

                                    <h1>Tổng hóa đơn: ${model.totalPrice} VND</h1>
                                    <hr>
                                    <div>
                                        <label for="form-field-select-1">Tình trạng đơn hàng hiện tại</label>
                                        <select class="form-control" id="form-field-select-1">
                                            <c:choose>
                                                <c:when test = "${model.orderStatus.id == 1}">
                                                    <option value="1" selected="selected">Đang chờ</option>
                                                    <option value="2">Đang giao</option>
                                                    <option value="3">Đã giao</option>
                                                    <option value="4">Hủy đơn hàng</option>
                                                </c:when>
                                                <c:when test = "${model.orderStatus.id == 2}">
                                                    <option value="1" >Đang chờ</option>
                                                    <option value="2" selected="selected">Đang giao</option>
                                                    <option value="3">Đã giao</option>
                                                    <option value="4">Hủy đơn hàng</option>
                                                </c:when>
                                                <c:when test = "${model.orderStatus.id == 3}">
                                                    <option value="1" >Đang chờ</option>
                                                    <option value="2">Đang giao</option>
                                                    <option value="3" selected="selected">Đã giao</option>
                                                    <option value="4">Hủy đơn hàng</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="1">Đang chờ</option>
                                                    <option value="2">Đang giao</option>
                                                    <option value="3">Đã giao</option>
                                                    <option value="4" selected="selected">Hủy đơn hàng</option>
                                                </c:otherwise>
                                            </c:choose>

                                        </select>
                                    </div>
                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-info" onclick="submitEdit()">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Xác nhận
                                            </button>

                                            &nbsp; &nbsp; &nbsp;
                                            <button class="btn" type="reset">
                                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                                Reset
                                            </button>
                                        </div>
                                    </div>
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
    var selectedCountry = ${model.orderStatus.id};
    $("select.form-control").change(function () {
        selectedCountry = $(this).children("option:selected").val();
        console.log(selectedCountry);
    });

    function submitEdit() {
        $('#idOrderStatus').val(selectedCountry);

        $('#formSubmit').submit();
    }
</script>
</body>

</html>
