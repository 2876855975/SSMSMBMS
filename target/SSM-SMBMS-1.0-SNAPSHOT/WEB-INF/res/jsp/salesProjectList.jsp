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
    <title>销售项目明细列表</title>
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
                            <h2>销售项目明细列表</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>销售单号</th>
                                    <th>销售商品名称</th>
                                    <th>销售数量</th>
                                    <th>商品售价</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pager.datas}" var="xxx">
                                    <tr>
                                        <th>${xxx.superSaleInfo.saleid}</th>
                                        <th>${xxx.goods_info.gname}</th>
                                        <th>${xxx.snum}</th>
                                        <th>${xxx.goods_info.gprice}</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <ul class="pager">
                                <c:if test="${pager.pageNo>1}">
                                    <li class="previous"><a href="/sales/getPagerBySaleid?pageIndex=1&saleid=${pager.params.superSaleInfo.saleid}">首页</a></li>
                                    <li class="previous"><a href="/sales/getPagerBySaleid?pageIndex=${pager.pageNo-1}&saleid=${pager.params.superSaleInfo.saleid}">&larr; 上一页</a></li>
                                </c:if>
                                <c:if test="${pager.pageNo<pager.totalPage}">
                                    <li class="next" ><a href="/sales/getPagerBySaleid?pageIndex=${pager.totalPage}&saleid=${pager.params.superSaleInfo.saleid}">尾页 &rarr;</a></li>
                                    <li class="next" ><a href="/sales/getPagerBySaleid?pageIndex=${pager.pageNo+1}&saleid=${pager.params.superSaleInfo.saleid}">下一页 &rarr;</a></li>+
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


<script src="/js/jdy/goodsList.js"></script>

<script>

</script>
</body>
</html>