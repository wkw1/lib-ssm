<%--
  Created by IntelliJ IDEA.
  User: 宽伟
  Date: 2017/8/31
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel handle-panel">
        <div class="panel-heading text-center">
            <h2>请登录</h2>
        </div>
    </div>
    <div class="panel panel-body">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="user" class="col-sm-2 control-label">用户</label>
                <div class="col-sm-3">
                    <input type="text" class="text-input" id="user" placeholder="关键字">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-3">
                    <input type="password" class="password-field" id="password" placeholder="关键字">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%--验证信息--%>
                    <span id="loginMessage" class="glyphicon"> </span>
                    <button id="signInBtn" type="button" class="btn btn-default">登录</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%--验证信息--%>
                    <span id="registerInfo" class="glyphicon"> </span>
                    <button id="registerBtn" type="button"
                            class="btn btn-default">注册</button>
                </div>
            </div>
        </form>

    </div>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%-- 交互逻辑 --%>
<script src="/resources/script/login.js?v=1" type="text/javascript" charset="GBK"></script>
<script type="text/javascript">
    $(function () {
        login.init.sign();
    })
</script>

</html>
