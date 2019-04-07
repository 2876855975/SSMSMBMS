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
    <title>修改用户密码</title>
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
                            <h2>修改用户密码<small>请填写：</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <form action="/user/domodifyUserPassword" id="userForm" name="userForm" class="form-horizontal form-label-left"  method="post" >
                                <!-- 错误信息-->
                                <!--<span class="section"><code >出错拉！</code></span>-->

                                <input type="hidden" value="${sid}" name="sid" id="sid">
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="olduserpassword">用户旧密码：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input value=""  class="form-control" type="password" name="olduserpassword" id="olduserpassword">
                                        <!-- 放置提示信息 -->
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userCode">用户新密码：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input value=""  class="form-control" type="password" name="userpassword" id="userpassword">
                                        <!-- 放置提示信息 -->
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="reuserpassword">确认新密码：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input value=""  class="form-control" type="password" name="reuserpassword" id="reuserpassword">
                                        <!-- 放置提示信息 -->
                                        <span color="red"></span>
                                    </div>
                                </div>



                                <div class="ln_solid"></div>
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

<script type="text/javascript" src="/build/calendar/WdatePicker.js"></script>
<script src="/js/jdy/usermodify.js"></script>

</body>
</html>