<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 综合管理系统</title>
    <%@include file="../../include/css.jsp"%>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp"%>
    <!-- =============================================== -->
    <jsp:include page="../../include/sidebar.jsp">
        <jsp:param name="menu" value="manager_permission"/>
    </jsp:include>
    <!-- =============================================== -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>添加权限</h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
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
                            <input type="text" name="permissionsName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>权限代号</label>
                            <input type="text" name="permissionsCode" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>资源URL</label>
                            <input type="text" name="url" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>权限类型</label>
                            <select name="permissionsType" class="form-control">
                                <option value="菜单">菜单</option>
                                <option value="按钮">按钮</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>父权限</label>
                            <select name="parentId" class="form-control">
                                <option value="0">顶级菜单</option>
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

    <%@include file="../../include/footer.jsp"%>
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
