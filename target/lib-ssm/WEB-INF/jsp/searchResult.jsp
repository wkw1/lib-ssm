<%--
  Created by IntelliJ IDEA.
  User: 宽伟
  Date: 2017/8/28
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>结果页面</title>
    <%@include file="common/head.jsp"%>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-3 column">
        </div>
        <div class="col-md-9 column">
            <div class="panel header-panel">
                <div class="panel-heading text-center">
                    <h2>结果列表</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>书名</th>
                            <th>ISBN</th>
                            <th>作者</th>
                            <th>出版社</th>
                            <th>剩余数量</th>
                            <th>入库时间</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${searchList}" var="sl">
                            <tr>
                                <td>${sl.bookName}</td>
                                <td>${sl.bookISBN}</td>
                                <td>${sl.bookAuthor}</td>
                                <td>${sl.bookPress}</td>
                                <td>${sl.remainingNumber}</td>
                                <td>
                                    <fmt:formatDate value="${sl.storageTime}"
                                                    pattern="yyyy-MM-dd  HH:MM:SS"/>
                                </td>
                                <td>
                                    <a class="btn btn-info"
                                       href="/lib/stu/${sl.bookISBN}/bookDetail"
                                       target="_blank">详情</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
