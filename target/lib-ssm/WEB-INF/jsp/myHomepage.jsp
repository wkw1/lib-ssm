<%--
  Created by IntelliJ IDEA.
  User: 宽伟
  Date: 2017/9/3
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人中心</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<header class="site-header">
    <div class="container ">
        <div class="row clearfix" style="background-color: teal">
            <div class="col-md-4 column">
                <h3>图书馆系统</h3>
            </div>
            <div class="col-md-4 column center-pill">
                <h3>我的主页</h3>
            </div>
            <div class="col-md-4 column right" >
                <button class="btn btn-sm" id="signOutBtn"
                        type="button" >退出登录</button>
            </div>
        </div>
    </div>
</header>
<div class="container" style="background-color: darkgray">
    <div class="row clearfix">
        <div class="col-md-12 column default-color4">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <img class="img-rounded" alt="140x140" width="200" height="200" src="/resources/image/wkw.jpg"/>
                </div>
                <div class="col-md-8 column pull-right">
                    <ul class="nav nav-pills">
                        <li class="active">
                            <a href="/lib/stu/myHomepage">主页</a></li>
                        <li class="double-q"><a href="/lib/stu/borrowList">借书表</a></li>
                        <li><a href="/lib/stu/orderList">预约表</a></li>
                        <li><a href="/lib/stu/order">借书历史</a></li>
                        <li><a href="/lib/stu/search">待定。。</a></li>
                    </ul>

                    <%-- 搜索图书部分页面 --%>
                    <form class="form-horizontal text-center" style="table-layout:auto">
                        <div class="form-group">
                            <label for="searchType" class="col-sm-2 control-label">搜索类型</label>
                            <div class="col-sm-3">
                                <select class="from-control" id="searchType">
                                    <c:forEach items="${searchDto.searchType}" var="st">
                                        <option>${st.info}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="searchKey" class="col-sm-2 control-label">关键字</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="searchKey" placeholder="关键字">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <button id="searchBtn" class="btn btn-default" type="button" >搜索</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <dl>
                <dt>
                    姓名：${myInfo.stuName}
                </dt>
                <dt>
                    ID：${myInfo.stuID}
                </dt>
                <dt>
                    学院：${myInfo.school}
                </dt>
                <dt>
                    借书数量：${myInfo.borrowNumber}
                </dt>
            </dl>
        </div>
    </div>
</div>

<footer class="site-footer">
    <div class="container ">
        <div class="row clearfix" style="background-color: #1b5480">
            <div class="col-md-12 column">
                <h3>Design By WKW</h3>
            </div>
        </div>
    </div>
</footer>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- 交互逻辑 --%>
<script src="/resources/script/login.js?v=11111" type="text/javascript" charset="GBK"></script>
<script src="/resources/script/stu.js?v=11111" type="text/javascript" charset="GBK"></script>
<script type="text/javascript">
    $(function () {
        login.init.sign();
    })
</script>
<script>
    $(function () {
        stu.init.search();
    })
</script>
</html>
