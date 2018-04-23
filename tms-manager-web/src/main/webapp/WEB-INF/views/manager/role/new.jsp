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
            <h1>添加角色</h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">角色列表</h3>
                    <div class="box-tools">
                        <a href="/manager/role" class="btn btn-success btn-sm"><i class="fa fa-arrow-right"></i> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>角色名称</label>
                            <input type="text" name="roleName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>角色代号</label>
                            <input type="text" name="roleCode" class="form-control">
                        </div>
                        <table class="table tree">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>权限名称</th>
                                    <th>权限代号</th>
                                    <th>资源URL</th>
                                    <th>类型</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${permissionList}" var="permissions">
                                    <c:choose>
                                        <c:when test="${permissions.parentId == 0}">
                                            <tr class="treegrid-${permissions.id} treegrid-expanded">
                                                <th>
                                                    <input type="checkbox" name="permissionId" value="${permissions.id}">
                                                </th>
                                                <td>${permissions.permissionsName}</td>
                                                <td>${permissions.permissionsCode}</td>
                                                <td>${permissions.url}</td>
                                                <td>${permissions.permissionsType}</td>

                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr class="treegrid-${permissions.id} treegrid-expanded treegrid-parent-${permissions.parentId}">
                                                <th>
                                                    <input type="checkbox" name="permissionId"  value="${permissions.id}">
                                                </th>
                                                <td>${permissions.permissionsName}</td>
                                                <td>${permissions.permissionsCode}</td>
                                                <td>${permissions.url}</td>
                                                <td>${permissions.permissionsType}</td>
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

    <%@include file="../../include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
        $('.tree').treegrid();
    })
</script>
</body>
</html>
