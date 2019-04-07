<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增用户</title>
    <!-- Bootstrap -->
    <link href="/build/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/build/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/build/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="/build/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/build/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/build/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="/common/head.jsp"/>
        <div class="right_col" role="main">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>新增用户<small>请填写：</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <form id="userForm" name="userForm" class="form-horizontal form-label-left" action="/user/doaddUser" method="post" >

                                <!-- 错误信息-->
                                <!--<span class="section"><code >出错拉！</code></span>-->
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="username">用户名称：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input maxlength="20" class="form-control" type="text" name="username" id="username" value="">
                                        <!-- 放置提示信息 -->
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userpassword">用户密码：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input class="form-control" type="password" name="userpassword" id="userpassword" value="">
                                        <span color="red"></span>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ruserPassword">确认密码：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input class="form-control" type="password" name="ruserPassword" id="ruserPassword" value="">
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ruserPassword">用户类型：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <select name="userType.tid">
                                             <c:forEach items="${usertype}" var="type">
                                                 <option value="${type.tid}">${type.tname}</option>
                                             </c:forEach>
                                        </select>
                                        <span color="red"></span>
                                    </div>
                                </div>


                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-4 ">
                                        <input name="add" id="add" type="button" class="btn btn-danger" value="提交" />
                                        <input id="back" name="back" type="button" class="btn btn-primary" value="返回"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <jsp:include page="/common/foot.jsp"/>
</div>

<script src="/js/jdy/useradd.js"></script>


</body>
</html>