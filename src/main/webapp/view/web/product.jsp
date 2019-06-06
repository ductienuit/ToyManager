<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 21/05/2019
  Time: 10:41 SA
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
                <ul class="breadcrumb-tree">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">All Categories</a></li>
                    <li class="active">${model.category.name}</li>
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
            <!-- Product main img -->
            <div class="col-md-5">
                <div id="product-main-img">
                    <div class="product-preview">
                        <img src="<c:url value="/template/web/img/${model.imageUri}"></c:url>" alt="">
                    </div>
                </div>
            </div>
            <!-- /Product main img -->

            <!-- Product details -->
            <div class="col-md-5">
                <div class="product-details">
                    <h2 class="product-name">${model.name}</h2>
                    <div>
                        <div class="product-rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-o"></i>
                        </div>
                    </div>
                    <div>
                        <h3 class="product-price">${model.price}VND
                        </h3>
                    </div>
                    <p>${model.description}</p>
                    <div class="add-to-cart">
                        <form id="submit" action="<c:url value="/danh-muc"></c:url>" method="get">
                        <div class="qty-label">
                            Qty
                            <div class="input-number">
                                <input type="number" value="1" name="quantity">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                            <input type="hidden" value="addcart" name="action">
                            <input type="hidden" value="${model.id}" name="sanpham">
                        <button class="add-to-cart-btn" type="submit" form="submit"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng</button>
                        </form>
                    </div>

<%--                        <input type="hidden" id="quantity" name="quantity">--%>
<%--                    </form>--%>
<%--                    <script>--%>
<%--                        function submitInsert(){--%>
<%--                            document.getElementById('quantity').value--%>
<%--                            $('#quantity').val('#quantity');--%>
<%--                            $('#addAccount').submit();--%>
<%--                        }--%>
<%--                    </script>--%>

                </div>
            </div>
            <!-- /Product details -->

            <div class="col-md-12">
                <div id="product-tab">
                    <!-- product tab nav -->
                    <ul class="tab-nav">
                        <li class="active"><a data-toggle="tab" href="#tab1" aria-expanded="true">Description</a></li>
                    </ul>
                    <!-- /product tab nav -->

                    <!-- product tab content -->
                    <div class="tab-content">
                        <!-- tab1  -->
                        <div id="tab1" class="tab-pane fade active in">
                            <div class="row">
                                <div class="col-md-12">
                                    <p>${model.description}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /product tab content  -->
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- Section -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <div class="col-md-12">
                <div class="section-title text-center">
                    <h3 class="title">BÁN CHẠY</h3>
                </div>
            </div>
            <c:forEach var="item" items="${sellerToys.listResult}">
                <div class="col-md-3 col-xs-6">
                    <div class="product">
                        <div class="product-img">
                            <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                        </div>
                        <div class="product-body">
                            <p class="product-category">${item.category.name}</p>
                            <h3 class="product-name"><a href="#">${item.category.name}</a></h3>
                            <h4 class="product-price">${item.price}VND</h4>
                            <div class="product-btns">
                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span>
                                </button>
                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span>
                                </button>
                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                </button>
                            </div>
                        </div>
                        <div class="add-to-cart">
                            <button class="add-to-cart-btn">
                                <a href="<c:url value='/danh-muc?action=addcart&sanpham=${item.id}&quantity=1'/>" >
                                    <i class="fa fa-shopping-cart"></i>
                                    Thêm vào giỏ hàng</a>
                            </button>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /Section -->
</body>
</html>

