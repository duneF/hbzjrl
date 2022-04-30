 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%--    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>--%>
    <title>张杰人力管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="box">
    <div class="login-box">
        <div class="login-title text-center">
            <h1>
                <small>张杰人力管理系统</small>
            </h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form id="formlogin" class="form-horizontal was-validated" action="/user/login" method="post">
                    <!-- 用户名输入 -->
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
									<span class="input-group-addon"><span
                                            class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="loginname" name="username" class="form-control" placeholder="用户名" required>
                            </div>
                        </div>
                    </div>

                    <!-- 密码输入 -->
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
									<span class="input-group-addon"><span
                                            class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="nloginpwd" name="password" class="form-control"
                                       placeholder="密码" required>
                            </div>
                        </div>
                    </div>

                    <!-- 用户类型选择 -->
                    <div class="radio-group">
                        <input type="radio" name="radioname" id="radioname1" value="员工" checked="checked">员工&nbsp;
                        <input type="radio" name="radioname" id="radioname2" value="客服">客服&nbsp;
                        <input type="radio" name="radioname" id="radioname3" value="代理">代理
                    </div>

                    <!-- 登录重置按钮 -->
                    <div class="form-group form-actions">
                        <div class="col-xs-12 text-center">
                            <button type="submit" id="login" class="btn btn-sm btn-success">
                                <span class="fa fa-check-circle"></span>登录
                            </button>
                            <button type="reset" id="reset" class="btn btn-sm btn-danger">
                                <span class="fa fa-close"></span> 重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<!--完整显示-->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>