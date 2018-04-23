<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 编辑账号</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sidebar.jsp">
        <jsp:param name="menu" value="manage_roles"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                账号管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">编辑账号</h3>
                    <div class="box-tools">
                        <a href="/manager/account" class="btn btn-primary btn-sm fa fa-arrow-right "> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <input type="hidden" name="id" value="${account.id}">
                        <div class="form-group">
                            <label>账号名称</label>
                            <input type="text" name="accountName" class="form-control" value="${account.accountName}">
                        </div>
                        <div class="form-group">
                            <label>手机号码(用于登录)</label>
                            <input type="text" name="accountMobile" class="form-control" value="${account.accountMobile}">
                        </div>
                        <div class="form-group">
                            <label>角色</label>
                            <div>
                                <c:forEach items="${roleList}" var="role">
                                    <c:set var="flag" value="false"/>
                                    <c:forEach items="${accountRole}" var="accountRoleList">
                                        <c:choose>
                                            <c:when test="${role.id == accountRoleList.id}">
                                                <c:set var="flag" value="true"/>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                    <div class="checkbox-inline">
                                        <input type="checkbox" value="${role.id}" ${flag ? 'checked':''}  name="roleId"> ${role.roleName}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn pull-right btn-primary" id="saveBtn">保存</button>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
    })
</script>
</body>
</html>