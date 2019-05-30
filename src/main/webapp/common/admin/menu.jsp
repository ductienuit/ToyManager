<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state" data-sidebar="true">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list flex-column">
        <li>
            <a href="/ToyManager/admin-order?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc">
                <i class="menu-icon fa fa-caret-right"></i>
                Danh sách đơn hàng
            </a>
            <b class="arrow"></b>
        </li>
        <li>
            <a href="/ToyManager/admin-products?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc">
                <i class="menu-icon fa fa-caret-right"></i>
                Danh sách sản phẩm
            </a>
            <b class="arrow"></b>
        </li>
        <li>
            <a href="/ToyManager/admin-category?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc">
                <i class="menu-icon fa fa-caret-right"></i>
                Danh sách loại đồ chơi
            </a>
            <b class="arrow"></b>
        </li>
        <li>
            <a href="/ToyManager/admin-accounts?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc">
                <i class="menu-icon fa fa-caret-right"></i>
                Quản lí tài khoản
            </a>
            <b class="arrow"></b>
        </li>
        <li>
            <a href="/ToyManager/admin-products?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc">
                <i class="menu-icon fa fa-caret-right"></i>
                Thống kê
            </a>
            <b class="arrow"></b>
        </li>
    </ul>

</div>