<%--
  Created by IntelliJ IDEA.
  User: 宽伟
  Date: 2017/8/27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>搜索页面</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel header-panel">
        <div class="panel-heading text-center">
            <h1>搜索页面</h1>
        </div>
    </div>
    <div class="panel panel-body">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="searchType" class="col-sm-2 control-label">关键字</label>
                <select class="from-control" id="searchType">
                    <c:forEach items="${searchDto.searchType}" var="st">
                        <option>${st}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="searchKey" class="col-sm-2 control-label">关键字</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="searchKey" placeholder="关键字">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">搜索</button>
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
</html>
