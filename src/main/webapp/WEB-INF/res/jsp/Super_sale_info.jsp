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
    <title>销售项目列表</title>
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
                            <h2>销售项目列表</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="text-muted font-13 m-b-30">
                                <form action="/goods/list" method="post" class="row">
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">销售单号：</label>
                                        <div class="">
                                            <input id="did" name="gid" type="text" value="<c:if test="${pager.params.gid>0}">${pager.params.gid}</c:if>" class="form-control" placeholder="销售单号">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">销售用户编号：</label>
                                        <div class="">
                                            <input id="dname" name="gname" value="${pager.params.gname}" type="text" class="form-control" placeholder="销售用户编号">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">销售会员编号：</label>
                                        <div class="">
                                            <select id="id" name="id">

                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group col-md-3 col-sm-3 col-xs-12" style="margin: 22px 0px">
                                        <input type="submit" class="btn btn-success" value="查询"/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a class="btn" href="/supplier/toAddSupplier">&nbsp;新增&nbsp;</a>
                                    </div>
                                </form>
                            </div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>商品编号</th>
                                    <th>商品名称</th>
                                    <th>商品类型</th>
                                    <th>商品数量</th>
                                    <th>商品售价</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pager.datas}" var="goods">
                                    <tr>
                                        <th>${goods.gid}</th>
                                        <th>${goods.gname}</th>
                                        <th>${goods.gcategroy.name}</th>
                                        <th>${goods.gstock}</th>
                                        <th>${goods.gprice}</th>
                                        <th>
                                            <a href="/goods/toModifyGoodsInfo?gid=${goods.gid}" style="cursor: pointer">修改</a>
                                            <a data-gid="${goods.gid}" onclick="deleteGoodsInfo(this)" style="cursor: pointer">删除</a>
                                        </th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <ul class="pager">
                                <c:if test="${pager.pageNo>1}">
                                    <li class="previous"><a href="/goods/list?pageIndex=1&gname=${pager.params.gname}&gid=${pager.params.gid}&id=${pager.params.gcategroy.id}">首页</a></li>
                                    <li class="previous"><a href="/goods/list?pageIndex=${pager.pageNo-1}&gname=${pager.params.gname}&gid=${pager.params.gid}&id=${pager.params.gcategroy.id}">&larr; 上一页</a></li>
                                </c:if>
                                <c:if test="${pager.pageNo<pager.totalPage}">
                                    <li class="next" ><a href="/goods/list?pageIndex=${pager.totalPage}&gname=${pager.params.gname}&gid=${pager.params.gid}&id=${pager.params.gcategroy.id}">尾页 &rarr;</a></li>
                                    <li class="next" ><a href="/goods/list?pageIndex=${pager.pageNo+1}&gname=${pager.params.gname}&gid=${pager.params.gid}&id=${pager.params.gcategroy.id}">下一页 &rarr;</a></li>+

                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="/common/foot.jsp"/>
</div>

<script src="/build/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/build/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/js/jdy/jquery-1.8.3.min.js"></script>




</body>
</html>