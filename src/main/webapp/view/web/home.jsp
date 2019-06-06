<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<!-- SECTION CATEGORY-->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./img/shop01.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Laptop<br>Collection</h3>
                        <a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./img/shop03.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Accessories<br>Collection</h3>
                        <a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./img/shop02.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Cameras<br>Collection</h3>
                        <a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">ĐỒ CHƠI MỚI</h3>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab1" class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <c:forEach var="item" items="${newToys.listResult}">
                                    <!-- product -->
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                            <div class="product-label">
                                                <span class="new">NEW</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${item.category.name}</p>
                                            <h3 class="product-name"><a href="#">${item.name}</a></h3>
                                            <h4 class="product-price">${item.price}VND
                                            </h4>
                                            <div class="product-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span
                                                        class="tooltipp">add to wishlist</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span
                                                        class="tooltipp">add to compare</span></button>
                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"/>
                                            <a href="<c:url value='/trang-chu?action=addcart&id=${item.id}'/>" >
                                                <i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng
                                            </a>
                                            </button>
                                        </div>
                                    </div>
                                    <!-- /product -->
                                </c:forEach>
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">BÁN CHẠY</h3>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">

                                <c:forEach var="item" items="${sellerToys.listResult}">
                                    <!-- product -->
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                            <div class="product-label">
                                                <span class="new">NEW</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${item.category.name}</p>
                                            <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                            <h4 class="product-price">${item.price}VND
                                            </h4>
                                            <div class="product-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span
                                                        class="tooltipp">add to wishlist</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span
                                                        class="tooltipp">add to compare</span></button>
                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn">
                                                <a href="<c:url value='/trang-chu?action=addcart&id=${item.id}'/>" >
                                                <i class="fa fa-shopping-cart"></i>
                                                Thêm vào giỏ hàng</a>
                                            </button>
                                        </div>
                                    </div>
                                    <!-- /product -->
                                </c:forEach>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top bán chạy</h4>
                    <div class="section-nav">
                        <div id="slick-nav-3" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-3">
                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>

                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top bán chạy</h4>
                    <div class="section-nav">
                        <div id="slick-nav-4" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-4">
                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>

                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="clearfix visible-sm visible-xs"></div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top bán chạy</h4>
                    <div class="section-nav">
                        <div id="slick-nav-5" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-5">
                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>

                    <div>
                        <c:forEach var="item" items="${threeSellerToys.listResult}">
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="<c:url value="/template/web/img/${item.imageUri}"></c:url>" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${item.category.name}</p>
                                    <h3 class="product-name"><a href="<c:url value='/danh-muc?sanpham=${item.id}'/>">${item.name}</a></h3>
                                    <h4 class="product-price">${item.price}VND
                                    </h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->
</body>
</html>
