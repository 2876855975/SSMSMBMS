<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>超市订单系统登录 </title>

    <!-- Bootstrap -->
    <link href="/build/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- NProgress -->
    <%--<link href="/build/nprogress/nprogress.css" rel="stylesheet">--%>
    <%--<!-- Animate.css -->--%>
    <link href="/build/animate.css/animate.min.css" rel="stylesheet">
    <%--<!-- Custom Theme Style -->--%>
    <link href="/build/css/custom.min.css" rel="stylesheet">
    <%--<!-- Font Awesome -->--%>
    <%--<link href="/build/font-awesome/css/font-awesome.min.css" rel="stylesheet">--%>
</head>

<body class="login">
<div>
    <input type="hidden" id="path" value="${path}" >
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="post" action="/loginUser">
                    <h1>系统登录</h1>
                    <h3 style="color: red">${msg}</h3>
                    <div>
                        <input type="text" name="username" value="admin1" class="form-control" placeholder="用户名" required="" />
                    </div>
                    <div>
                        <input type="password" name="userpassword" value="123456" class="form-control" placeholder="密码" required="" />
                    </div>
                    <div>
                        <img src="/getImage" onclick="getImage(this)">
                        <input type="text" name="valideteCode"/>
                    </div>
                    <div>
                        <input type="submit" class="btn btn-default submit" value="登录"/>
                        <%--<a class="" href="frame.jsp">登录</a>--%>
                        <a class="reset_pass" href="#">忘记密码?</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">新用户？
                            <a href="#signup" class="to_register"> 创建帐号！ </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> 超市订单系统!</h1>
                            <p>©2017 All Rights Reserved. Zeliang's supermarket order system USES Bootstrap</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="/user/userCreate" method="post" id="userForm" name="userForm" >
                    <h1>注册用户</h1>
                    <h3 id="error"></h3>
                    <div>
                        <span></span>
                        <input id="userCode" name="userCode" type="text" class="form-control" placeholder="用户名" required="" />

                    </div>
                    <div>
                        <span></span>
                        <input id="userName" name="userName" type="text" class="form-control" placeholder="用户姓名" required="" />
                    </div>
                    <div>
                        <span></span>
                        <input id="userPassword" name="userPassword" type="password" class="form-control" placeholder="密码" required="" />
                    </div>
                    <div>
                        <a class="btn btn-default submit" id="add" name="add" >提交</a>
                    </div>
                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">已经有了账号 ?
                            <a href="#signin" class="to_register"> 登入 </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> 超市订单系统!</h1>
                            <p>©2017 All Rights Reserved. Zeliang's supermarket order system USES Bootstrap</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
<script src="/js/jdy/jquery-1.8.3.min.js"></script>

<script>
     function getImage(i) {
          i.setAttribute("src","/getImage?random="+Math.random().valueOf());
     }
</script>
</body>
</html>