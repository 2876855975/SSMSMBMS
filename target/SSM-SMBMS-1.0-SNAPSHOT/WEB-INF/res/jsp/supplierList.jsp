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
    <title>供应商信息列表</title>
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
                            <h2>供应商列表</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="text-muted font-13 m-b-30">
                                <form action="/supplier/list" method="post" class="row">
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">供应商编号：</label>
                                        <div class="">
                                            <input id="did" name="did" type="text" value="<c:if test="${pager.params.did>0}">${pager.params.did}</c:if>" class="form-control" placeholder="供应商编号">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">供应商名称：</label>
                                        <div class="">
                                            <input id="dname" name="dname" value="${pager.params.dname}" type="text" class="form-control" placeholder="供应商名称">
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
                                    <th>供应商编号</th>
                                    <th>供应商名称</th>
                                    <th>供应商电话</th>
                                    <th>供应商邮箱</th>
                                    <th>供应商地址</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pager.datas}" var="supplier">
                                    <tr>
                                        <th>${supplier.did}</th>
                                        <th>${supplier.dname}</th>
                                        <th>${supplier.dtel}</th>
                                        <th>${supplier.demail}</th>
                                        <th>${supplier.daddress}</th>
                                        <th>
                                            <a href="/supplier/toModifySupplier?did=${supplier.did}" style="cursor: pointer">修改</a>
                                            <a onclick="deleteSupplierInfo(this)" data-did="${supplier.did}" style="cursor: pointer">删除</a>
                                        </th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <ul class="pager">
                                <c:if test="${pager.pageNo>1}">
                                    <li class="previous"><a href="/supplier/list?pageIndex=1&dname=${pager.params.dname}&did=${pager.params.did}">首页</a></li>
                                    <li class="previous"><a href="/supplier/list?pageIndex=${pager.pageNo-1}&dname=${pager.params.dname}&did=${pager.params.did}">&larr; 上一页</a></li>
                                </c:if>
                                <c:if test="${pager.pageNo<pager.totalPage}">
                                    <li class="next" ><a href="/supplier/list?pageIndex=${pager.pageNo+1}&dname=${pager.params.dname}&did=${pager.params.did}">下一页 &rarr;</a></li>
                                    <li class="next" ><a href="/supplier/list?pageIndex=${pager.totalPage}&dname=${pager.params.dname}&did=${pager.params.did}">尾页 &rarr;</a></li>
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


<script src="/js/jdy/supplierList.js"></script>


</body>
</html>