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
    <title>书详情页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <img alt="90*160" width="90" height="160" src="/resources/image/book_img.jpg" />
        </div>
        <div class="col-md-4 column">
            <h4 >
                ISBN ：${bookEntity.bookISBN}
            </h4>
            <h4 >
                作者 ：${bookEntity.bookAuthor}
            </h4>
            <h4 >
                出版社 ：${bookEntity.bookPress}
            </h4>
            <h4 >
            总数量：${bookEntity.totalNumber}
            </h4>
            <h4 >
                剩余数量：${bookEntity.remainingNumber}
            </h4>
            <h4 >
                入库时间：${bookEntity.storageTime}
            </h4>
        </div>
        <div class="col-md-4 column">
            <h3 id="bookName">
                书名 ：${bookEntity.bookName}
            </h3>
            <p id="introduction">
                <em>简介：</em>${bookEntity.bookIntroduction}
            </p>
            <button class="btn btn-info" id="borrowBtn"
                    target="_blank">借阅</button>
            <c:if test="${bookEntity.remainingNumber<=0}">
                <button class="btn btn-info" id="orderBtn"
                        target="_blank">预约</button>
                <span id="orderInfo" class="glyphicon"></span>
            </c:if>
            <span id="borrowInfo" class="glyphicon"></span>
        </div>
    </div>
</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/resources/script/stu.js?v=111" type="text/javascript" charset="GBK"></script>
<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
        stu.book.borrow({
            bookISBN:${bookEntity.bookISBN}
        });
    })
</script>
<script type="text/javascript">
    $(function () {
        stu.book.order({
            bookISBN:${bookEntity.bookISBN}
        })
    })
</script>

</html>
