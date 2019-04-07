<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>销售项目信息列表</title>
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
                            <h2>销售项目信息列表</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="text-muted font-13 m-b-30">
                                <form action="/supersaleinfo/getPager" method="post" class="row">
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">用户编号：</label>
                                        <div class="">
                                            <input id="sid" name="sid" type="text" value="<c:if test="${pager.params.user_info.sid}>0">${pager.params.user_info.sid}</c:if>" class="form-control" placeholder="用户编号">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">会员编号：</label>
                                        <div class="">
                                            <input id="dname" name="mid" value="" type="text" class="form-control" placeholder="会员编号">
                                        </div>
                                    </div>

                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <label class="">销售项目编号：</label>
                                        <div class="">
                                            <input id="saleid" name="saleid" value="" type="text" class="form-control" placeholder="销售项目编号">
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
                                    <th>销售项目编号</th>
                                    <th>购买会员</th>
                                    <th>出售用户</th>
                                    <th>销售时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                      <c:forEach items="${pager.datas}" var="xxx">
                                            <tr>
                                                <th>${xxx.saleid}</th>
                                                <th>${xxx.user_info.username}</th>
                                                <th>${xxx.member_manage.mname}</th>
                                                <th><fmt:formatDate value="${xxx.sdate}" pattern="yyyy-MM-dd"/> </th>
                                                <th>
                                                    <a href="/sales/getPagerBySaleid?saleid=${xxx.saleid}">查看详细列表</a>
                                                    <a data-saleid="${xxx.saleid}"  onclick="removeBySaleid(this)">删除</a>
                                                </th>
                                            </tr>
                                      </c:forEach>
                                </tbody>
                            </table>
                            <ul class="pager">
                                <c:if test="${pager.pageNo>1}">
                                    <li class="previous"><a href="/supersaleinfo/getPager?pageIndex=1&sid=${pager.params.user_info.sid}&mid=${pager.params.member_manage.mid}&sdate=${pager.params.sdate}&saleid=${pager.params.saleid}">首页</a></li>
                                    <li class="previous"><a href="/supersaleinfo/getPager?pageIndex=${pager.pageNo-1}&sid=${pager.params.user_info.sid}&mid=${pager.params.member_manage.mid}&sdate=${pager.params.sdate}&saleid=${pager.params.saleid}">上一页</a></li>
                                </c:if>
                                <c:if test="${pager.pageNo<pager.totalPage}">
                                    <li class="next" ><a href="/supersaleinfo/getPager?pageIndex=${pager.totalPage}&sid=${pager.params.user_info.sid}&mid=${pager.params.member_manage.mid}&sdate=${pager.params.sdate}&saleid=${pager.params.saleid}">尾页 &rarr;</a></li>
                                    <li class="next" ><a href="/supersaleinfo/getPager?pageIndex=${pager.pageNo+1}&sid=${pager.params.user_info.sid}&mid=${pager.params.member_manage.mid}&sdate=${pager.params.sdate}&saleid=${pager.params.saleid}">下一页 &rarr;</a></li>+

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


<script src="/js/jdy/SuperSaleInfo.js"></script>

<script>

</script>
</body>
</html>