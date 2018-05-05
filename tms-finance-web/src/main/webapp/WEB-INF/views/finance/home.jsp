<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点缴费</title>
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="finance"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点缴费
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-body">
                    <form class="form-inline">
                        <select name="state" class="form-control">
                            <option ${param.state == '未支付' ? 'selected' : ''} value="未支付">未支付</option>
                            <option ${param.state == '已支付' ? 'selected' : ''} value="已支付">已支付</option>
                        </select>
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">缴费列表</h3>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>下发时间</th>
                            <th>下发网点</th>
                            <th>内容</th>
                            <th>起始票号</th>
                            <th>截至票号</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>总价</th>
                            <th>支付方式</th>
                            <th>下发人</th>
                            <th>状态</th>
                            <th>收款人</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty page.list}">
                            <tr>
                                <td colspan="13">暂无记录</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${page.list}" var="record">
                            <tr>
                                <td><fmt:formatDate value="${record.createTime}"/></td>
                                <td>${record.storeAccountName}</td>
                                <td>${record.content}</td>
                                <td>${record.beginTicketNum}</td>
                                <td>${record.endTicketNum}</td>
                                <td>${record.totalNum}</td>
                                <td>${record.price}</td>
                                <td>${record.totalPrice}</td>
                                <td>${record.payType}</td>
                                <td>${record.outAccountName}</td>
                                <td>
                                    <span class="label ${record.state == '未支付' ? 'label-danger' : 'label-success'}">${record.state}</span>
                                </td>
                                <td>${record.financeAccountName}</td>
                                <td>
                                    <c:if test="${record.state == '未支付'}">
                                        <a href="/finance/${record.id}/new" class="btn btn-sm btn-success">支付</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${pageInfo.pages > 1}">
                        <ul id="pagination-demo" class="pagination pull-right"></ul>
                    </c:if>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/page/jquery.twbsPagination.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        $('#pagination-demo').twbsPagination({
            totalPages: ${page.pages},
            visiblePages: 10,
            first:'首页',
            last:'末页',
            prev:'←',
            next:'→',
            href:"?p={{number}}"
        });
    });
</body>
</html>