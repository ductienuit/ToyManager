<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="<c:url value="/"/>"><i class="fa fa-phone"></i> +0988.546.255</a></li>
                <li><a href="<c:url value="/"/>"><i class="fa fa-envelope-o"></i> toymanager@email.com</a></li>
                <li><a href="<c:url value="/"/>"><i class="fa fa-map-marker"></i> 269 Điện Biên Phủ, Q. Bình Thạnh, TP Hồ Chí Minh</a>
                </li>
            </ul>
            <c:if test="${not empty USERMODEL}">
                <ul class="header-links pull-right">
                    <li><a href="<c:url value="/tai-khoan?id=1"/>"><i class="fa fa-user-o"></i> Tài khoản</a></li>
                    <li><a href="<c:url value="/thoat?action=logout"/>"> Thoát </a></li>
                    <c:if test="${USERMODEL.role.id==2}">
                        <li><a href="<c:url value="/admin-home"/>"> Admin </a></li>
                    </c:if>

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
                        <a href="<c:url value="/"/>" class="logo">
                            <%--                            <img src="<c:url value='/template/web/img/logo.png'/>" alt="">--%>
                            <h1 style="margin-top: 15px; color:white" href="<c:url value="/"/>">Toy Toy</h1>
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
                                <option value="2">Đồ chơi nữ</option>
                                <option value="3">Đồ chơi gỗ</option>
                                <option value="4">Lego</option>
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
                                <c:choose>
                                    <c:when test="${empty cart}">
                                        <div class="qty">0</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="qty">${cart.count}</div>
                                    </c:otherwise>
                                </c:choose>

                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
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
                                                        <h3 class="product-name"><a href="<c:url value="/danh-muc?sanpham=${entry.value.toy.id}"/>">${entry.value.toy.name}</a></h3>
                                                        <h4 class="product-price"><span class="qty">${entry.value.quantity}x</span>${entry.value.toy.price}</h4>
                                                    </div>
                                                    <a class="delete" href="<c:url value='/trang-chu?action=removecart&id=${entry.value.toy.id}'/>"><i class="fa fa-close"></i></a>
                                                </div>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div class="cart-summary">
                                    <c:choose>
                                        <c:when test="${empty cart}">
                                            <h5>Tổng: 0 Đồng </h5>
                                        </c:when>
                                        <c:otherwise>
                                            <h5>Tổng: ${cart.totalPrice} Đồng</h5>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="cart-btns">
                                    <a href="<c:url value="/checkout"></c:url>">Giỏ hàng</a>
                                    <a href="<c:url value="/checkout"></c:url>">Thanh toán <i class="fa fa-arrow-circle-right"></i></a>
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
                <li class="active"><a href="<c:url value="/"/>">Trang chủ</a></li>
                <li><a  href="<c:url value="/danh-muc"/>">Danh mục</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->