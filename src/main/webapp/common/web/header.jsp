<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +0988.546.255</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> toymanager@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> 269 Điện Biên Phủ, Q. Bình Thạnh, TP Hồ Chí Minh</a>
                </li>
            </ul>
            <c:if test="${not empty USERMODEL}">
                <ul class="header-links pull-right">
                    <li><a href="<c:url value="/tai-khoan?id=1"/>"><i class="fa fa-user-o"></i> Tài khoản</a></li>
                </ul>
            </c:if>
            <c:if test="${empty USERMODEL}">
                <ul class="header-links pull-right">
                    <li><a href="<c:url value="/dang-nhap?action=login"/>"><i class="fa fa-user-o"></i>Đăng nhập</a>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="#" class="logo">
                            <%--                            <img src="<c:url value='/template/web/img/logo.png'/>" alt="">--%>
                            <h1 style="margin-top: 15px; color:white" href="#">Toy Toy</h1>
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
                            <select class="input-select">
                                <option value="0">Danh mục</option>
                                <option value="1">Đồ chơi nam</option>
                                <option value="1">Đồ chơi nữ</option>
                                <option value="1">Đồ chơi gỗ</option>
                                <option value="1">Lego</option>
                            </select>
                            <input class="input" placeholder="Nhập từ khóa">
                            <button class="search-btn">Tìm kiếm</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Giỏ hàng</span>
                                <div class="qty">3</div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="<c:url value='/template/web/img/product01.png'/>" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                                        </div>
                                        <button class="delete"><i class="fa fa-close"></i></button>
                                    </div>

                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="<c:url value='/template/web/img/product02.png'/>" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
                                        </div>
                                        <button class="delete"><i class="fa fa-close"></i></button>
                                    </div>
                                </div>
                                <div class="cart-summary">
                                    <small>3 sản phẩm</small>
                                    <h5>Tổng: $2940.00</h5>
                                </div>
                                <div class="cart-btns">
                                    <a href="#">Giỏ hàng</a>
                                    <a href="#">Thanh toán <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="#">Trang chủ</a></li>
                <li><a href="#">Hot Deals</a></li>
                <li><a href="#">Đồ chơi nam</a></li>
                <li><a href="#">Đồ chơi nữ</a></li>
                <li><a href="#">Đồ chơi gỗ</a></li>
                <li><a href="#">Đồ chơi búp bê</a></li>
                <li><a href="#">Lego</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->