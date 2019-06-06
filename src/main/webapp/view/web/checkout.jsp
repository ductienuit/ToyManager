<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 22/05/2019
  Time: 9:20 SA
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
                <h3 class="breadcrumb-header">Giỏ hàng</h3>
                <ul class="breadcrumb-tree">
                    <li><a href="<c:url value='/trang-chu'/>">Trang chủ</a></li>
                    <li class="active">Giỏ hàng</li>
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

            <div class="col-md-7">
                <!-- Billing Details -->
                <div class="billing-details">
                    <div class="section-title">
                        <h3 class="title">Thông tin địa chỉ giao hàng</h3>
                    </div>
                    <c:choose>
                        <c:when test="${empty USERMODEL.fullName}">
                            <div class="form-group">
                                <input class="input" type="text" name="yourname" placeholder="Tên" readonly>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <input readonly class="input" type="text" value="${USERMODEL.fullName}" name="yourname" placeholder="Tên">
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty USERMODEL.email}">
                            <div class="form-group">
                                <input readonly class="input" type="email" name="email" placeholder="Email">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <input readonly class="input" type="email" value="${USERMODEL.email}" name="email" placeholder="Email">
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty USERMODEL.address}">
                            <div class="form-group">
                                <input readonly class="input" type="text" name="address" placeholder="Địa chỉ">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <input readonly class="input" type="text" value="${USERMODEL.address}" name="address" placeholder="Địa chỉ">
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty USERMODEL.phoneNumber}">

                            <div class="form-group">
                                <input readonly class="input" type="tel" name="tel" placeholder="Điện thoại">
                            </div>
                        </c:when>
                        <c:otherwise>

                            <div class="form-group">
                                <input readonly class="input" type="tel" value="${USERMODEL.phoneNumber}" name="tel" placeholder="Điện thoại">
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- /Billing Details -->

                <!-- Order notes -->
                <div class="order-notes">
                    <textarea class="input" placeholder="Lưu ý cho đơn hàng"></textarea>
                </div>
                <!-- /Order notes -->
            </div>

            <!-- Order Details -->
            <div class="col-md-5 order-details">
                <div class="section-title text-center">
                    <h3 class="title">ĐƠN HÀNG</h3>
                </div>
                <div class="order-summary">
                    <div class="order-col">
                        <div><strong>SẢN PHẨM</strong></div>
                        <div><strong>THÀNH TIỀN</strong></div>
                    </div>
                    <div class="order-products">
                        <c:choose>
                            <c:when test="${empty cart}">

                            </c:when>
                            <c:otherwise>
                                <c:forEach var="entry" items="${cart.cartItems}">
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="<c:url value='/template/web/img/${entry.value.toy.imageUri}'/>" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name">
                                                <a href="<c:url value='/danh-muc?sanpham=${entry.value.toy.id}'/>">${entry.value.toy.name}</a>
                                            </h3>
                                            <h4 class="product-price"><span class="qty">${entry.value.quantity}x</span>${entry.value.toy.price}</h4>
                                        </div>
                                        <button class="delete"><i class="fa fa-close"></i></button>
                                    </div>

                                    <div class="order-col">
                                        <div>${entry.value.quantity}x ${entry.value.toy.name}</div>
                                        <div>${entry.value.toy.price} VND</div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="order-col">
                        <div>Phí ship</div>
                        <div><strong>Miễn phí</strong></div>
                    </div>
                    <div class="order-col">
                        <div><strong>TỔNG ĐƠN HÀNG</strong></div>
                        <c:choose>
                            <c:when test="${empty cart}">
                                <div><strong class="order-total">0</strong></div>
                            </c:when>
                            <c:otherwise>
                                <div><strong class="order-total"> ${cart.totalPrice} VND</strong></div>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="payment-method">
                    <div class="input-radio">
                        <input type="radio" name="payment" id="payment-2">
                        <label for="payment-2">
                            <span></span>
                            Trả tiền khi nhận hàng
                        </label>
                    </div>
                </div>
                <form id="submit" name="submit" method="post">
                    <input type="hidden" name="checkout" value="checkout">
                </form>
                <a class="primary-btn order-submit" onclick="submitCheckout()">THANH TOÁN</a>
            </div>
            <!-- /Order Details -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->
<script>
    function submitCheckout() {
        $('#submit').submit();
    }
</script>
</body>
</html>


