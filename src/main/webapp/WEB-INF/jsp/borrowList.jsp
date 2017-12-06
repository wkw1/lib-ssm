<%--
  Created by IntelliJ IDEA.
  User: 宽伟
  Date: 2017/9/3
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>借书</title>
    <%@include file="common/head.jsp"%>
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
            <div class="col-md-4 column ">
                <button class="btn btn-sm tab-down-button" type="button">按钮</button>
                <button class="btn btn-sm" type="button">退出登录</button>
            </div>
        </div>
    </div>
</header>
<div class="container">
    <div class="row clearfix">
        <div class="row clearfix">
            <div class="col-md-4 column">
                <img class="img-rounded" alt="140x140" width="200" height="200" src="/resources/image/wkw.jpg"/>
                <dl>
                    <dt>
                        这是我的信息
                    </dt>
                    <dd>
                        有待完成
                    </dd>
                </dl>
            </div>
            <div class="col-md-8 column">
                <ul class="nav nav-pills">
                    <li><a href="/lib/stu/myHomepage">Home</a></li>
                    <li class="active"><a href="/lib/stu/borrow">借书表</a></li>
                    <li><a href="/lib/stu/orderList">预约表</a></li>
                    <li><a href="/lib/stu/order">借书历史</a></li>
                    <li><a href="/lib/stu/search">待定。。</a></li>
                </ul>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>借阅编号</th>
                        <th>ISBN</th>
                        <th>书名</th>
                        <th>借阅时间</th>
                        <th>预计归时间</th>
                        <th>详情</th>
                        <th>归还</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${borrowList}" var="list">
                        <tr>
                            <td>${list.borrowID}</td>
                            <td>${list.bookISBN}</td>
                            <td>${list.book.bookName}</td>
                            <td>
                                <fmt:formatDate value="${list.borrowTime}"
                                                pattern="yyyy-MM-dd"/>
                            </td>
                            <td>
                                <fmt:formatDate value="${list.expectReturnTime}"
                                                pattern="yyyy-MM-dd"/>
                            </td>
                            <td>
                                <a class="btn btn-info"
                                   href="/lib/stu/${list.bookISBN}/bookDetail"
                                   target="_blank">详情</a>
                            </td>
                            <td>
                                <a class="btn btn-info"
                                   onclick="stu.book.returnBook(${list.borrowID})">归还</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
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
<script src="/resources/script/stu.js?v=111" type="text/javascript" charset="GBK"></script>
</html>
