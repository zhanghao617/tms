<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 编辑角色</title>
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
                角色管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">编辑角色</h3>
                    <div class="box-tools">
                        <a href="/manager/role" class="btn btn-primary btn-sm fa fa-arrow-right "> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <input type="hidden" name="id" value="${role.id}">
                        <div class="form-group">
                            <label>角色名称</label>
                            <input type="text" name="roleName" class="form-control" value="${role.roleName}">
                        </div>
                        <div class="form-group">
                            <label>角色代号</label>
                            <input type="text" name="roleCode" class="form-control" value="${role.roleCode}">
                        </div>
                        <table class="table tree">
                            <thead>
                            <tr>
                                <th></th>
                                <th>权限名称</th>
                                <th>权限代号</th>
                                <th>资源URL</th>
                                <th>权限类型</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${permissionsMap}" var="entry">
                                <c:choose>
                                    <c:when test="${entry.key.parentId == 0}">
                                        <tr class="treegrid-${entry.key.id} treegrid-expanded">
                                            <th>
                                                <input type="checkbox" name="permissionsId" ${entry.value ? 'checked' : ''} value="${entry.key.id}">
                                            </th>
                                            <td>${entry.key.permissionsName}</td>
                                            <td>${entry.key.permissionsCode}</td>
                                            <td>${entry.key.url}</td>
                                            <td>${entry.key.permissionsType}</td>

                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="treegrid-${entry.key.id} treegrid-expanded treegrid-parent-${entry.key.parentId}">
                                            <th>
                                                <input type="checkbox" name="permissionId" ${entry.value ? 'checked' : ''} value="${entry.key.id}">
                                            </th>
                                            <td>${entry.key.permissionsName}</td>
                                            <td>${entry.key.permissionsCode}</td>
                                            <td>${entry.key.url}</td>
                                            <td>${entry.key.permissionsType}</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>
                            </tbody>
                        </table>
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
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
        $('.tree').treegrid();
        $('input[type=checkbox]').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    })
</script>
</body>
</html>