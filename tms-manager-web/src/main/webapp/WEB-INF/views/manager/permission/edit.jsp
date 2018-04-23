<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 编辑权限</title>
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
                <div class="box-header with-border">
                    <h3 class="box-title">权限列表</h3>
                    <div class="box-tools">
                        <a href="/manager/permission" class="btn btn-success btn-sm"><i class="fa fa-arrow-right"></i> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>权限名称</label>
                            <input type="text" name="permissionsName" value="${permissions.permissionsName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>权限代号</label>
                            <input type="text" name="permissionsCode" value="${permissions.permissionsCode}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>资源URL</label>
                            <input type="text" name="url" value="${permissions.url}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>权限类型</label>
                            <select name="permissionsType" class="form-control">
                                <option value="${permissions.id}">${permissions.permissionsType}</option>
                                <option >-----------------</option>
                                <option value="菜单">菜单</option>
                                <option value="按钮">按钮</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>父权限</label>
                            <select name="parentId" class="form-control">
                                <option value="${permissions.parentId}">${permissions.permissionsName}</option>
                                <option>-----------------</option>
                                <c:forEach items="${permissionList}" var="permission">
                                    <option value="${permission.id}">${permission.permissionsName}</option>
                                </c:forEach>
                            </select>
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