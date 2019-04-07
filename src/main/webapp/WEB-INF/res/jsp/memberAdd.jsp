<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增会员信息</title>
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
                            <h2>新增会员信息<small>请填写：</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <form action="/member/doaddMember" id="userForm" name="userForm" class="form-horizontal form-label-left"  method="post" >
                                <!-- 错误信息-->
                                <!--<span class="section"><code >出错拉！</code></span>-->

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userName">会员姓名：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input MAXLENGTH="15" value="" class="form-control" type="text" name="mname" id="mname" >
                                        <span color="red"></span>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">会员电话：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input value="" class="form-control" type="text" name="mtel" id="mtel">
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="msex">会员性别：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="radio" checked="checked" name="msex" value="男"   />男
                                        <input type="radio" name="msex" value="女"  />女
                                    </div>
                                </div>


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">会员类型：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="mgrade.gid">
                                            <c:forEach items="${grades}" var="grade">
                                                <option value="${grade.gid}">${grade.mgrade}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-4 ">
                                        <input name="save" id="save" type="button" class="btn btn-danger" value="保存" />
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

<script src="/js/jdy/jquery-1.8.3.min.js"></script>
<script src="/js/jdy/memberAdd.js"></script>

</body>
</html>