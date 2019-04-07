<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
%>
<input type="hidden" id="path" value="${path}" >
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>超市订单系统</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <img src="/images/img.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span>Welcome,</span>
                <h2>${user.username}</h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>系统管理员</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> 会员管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/member/list">会员列表</a></li>
                            <li><a href="/member/toaddMember">增加会员</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> 用户管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/user/list">用户列表</a></li>
                            <li><a href="/user/tomodifyuserpassword?sid=${user.sid}">修改密码</a></li>

                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> 供应商管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/supplier/list">供应商列表</a></li>
                            <li><a href="/supplier/toAddSupplier">新增供应商</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> 商品管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/goods/list">商品列表</a></li>
                            <li><a href="/goods/toaddGoodsInfo">新增商品</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i>销售信息管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/supersaleinfo/getPager">查看销售信息列表</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
        <!-- /sidebar menu -->


        <!-- /menu footer buttons -->
    </div>
</div>

<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="/images/img.jpg" alt="">${userSession.userName}
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="/user/loginout"><i class="fa fa-sign-out pull-right"></i> 注销 </a></li>
                    </ul>
                </li>

                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
