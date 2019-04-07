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
    <title>添加商品信息</title>
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
                            <h2>添加商品信息<small>请填写：</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <form action="/goods/doaddGoodsInfo" id="userForm" name="userForm" class="form-horizontal form-label-left"  method="post" >
                                <!-- 错误信息-->
                                <!--<span class="section"><code >出错拉！</code></span>-->


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userName">商品名称：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 ">
                                        <input maxlength="20"  value="${goods.gname}" class="form-control" type="text" name="gname" id="gname" >
                                        <span color="red"></span>
                                    </div>
                                </div>


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">商品数量：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input  value="${goods.gstock}" type="number" class="form-control" type="number" name="gstock" id="gStock">
                                        <span color="red"></span>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品积分：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input value="${goods.gpoints}" class="form-control" name="gpoints" id="gpoints"  >
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品售价：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input value="${goods.gprice}" type="number" class="form-control" name="gprice" id="gPrice"  >
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品成本价：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input value="${goods.gprice}" type="number" class="form-control" name="gcost_price" id="gcost_price"  >
                                    </div>
                                </div>


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品类别：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="gcategroy.id">
                                            <c:forEach items="${categorys}" var="cate">
                                                <option value="${cate.id}" <c:if test="${cate.id==goods.gcategroy.id}">selected</c:if>>${cate.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品折扣：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="gdiscount">
                                             <option value="1.0">无折扣</option>
                                             <option value="0.9">九折</option>
                                             <option value="0.8">八折</option>
                                             <option value="0.7">七折</option>
                                             <option value="0.6">六折</option>
                                             <option value="0.5">五折</option>
                                             <option value="0.4">四折</option>
                                             <option value="0.3">三折</option>
                                             <option value="0.2">二折</option>
                                             <option value="0.1">一折</option>
                                        </select>
                                    </div>
                                </div>


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">商品单位：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select name="gunit" id="gunit">
                                            <option value="个">个</option>
                                             <option value="只">只</option>
                                             <option value="箱">箱</option>
                                             <option value="条">条</option>
                                             <option value="桶">桶</option>
                                             <option value="袋">袋</option>
                                        </select>
                                        <span color="red"></span>
                                    </div>
                                </div>


                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">商品备注：</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <textarea name="gremark" maxlength="100">${goods.gremark}</textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-4 ">
                                        <input name="save" id="save" type="submit" class="btn btn-danger" value="保存" />
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
<script type="text/javascript" src="/build/calendar/WdatePicker.js"></script>


</body>
</html>