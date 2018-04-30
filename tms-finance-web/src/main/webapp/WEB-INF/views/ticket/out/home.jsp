<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 年票下发</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sidebar.jsp">
        <jsp:param name="menu" value="ticket_out"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票下发
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">下发列表</h3>
                    <div class="box-tools">
                        <a href="/ticket/out/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增</a>
                    </div>
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
                            <c:if test="${empty ticketOutStores}">
                                <tr>
                                    <td colspan="13">暂无记录</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${ticketOutStores}" var="ticket">
                                <tr>
                                    <td><fmt:formatDate value="${ticket.createTime}"/></td>
                                    <td>${ticket.storeAccountName}</td>
                                    <td>${ticket.content}</td>
                                    <td>${ticket.beginTicketNum}</td>
                                    <td>${ticket.endTicketNum}</td>
                                    <td>${ticket.totalNum}</td>
                                    <td>${ticket.price}</td>
                                    <td>${ticket.totalPrice}</td>
                                    <td>${ticket.payType}</td>
                                    <td>${ticket.outAccountName}</td>
                                    <td>
                                        <span class="label ${ticket.state == '未支付' ? 'label-danger' : 'label-success'}">${ticket.state}</span>
                                    </td>
                                    <td>${ticket.financeAccountName}</td>
                                    <td>
                                        <c:if test="${ticket.state == '未支付'}">
                                            <a href="javascript:;" rel="${ticket.id}" class="del" title="取消"><i class="fa fa-trash text-danger"></i></a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function() {
        $(".del").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要取消吗",function (index) {
                layer.close(index);
                $.get("/ticket/out/"+id+"/del").done(function (result) {
                    if(result.status == 'success') {
                        layer.msg("删除成功");
                        window.history.go(0);
                    }
                }).error(function () {
                    layer.msg("服务器异常");
                });
            });
        });
    });
</body>
</html>