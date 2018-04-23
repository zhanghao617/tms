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
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
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
            <h1>
                权限管理
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">权限列表</h3>
                    <div class="box-tools">
                        <a href="/manager/permission/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增权限</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table tree">
                        <thead>
                            <tr>
                                <th>权限名称</th>
                                <th>权限代号</th>
                                <th>URL</th>
                                <th>类型</th>
                                <th>#</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${permissionList}" var="permissions">
                                <c:choose>
                                    <c:when test="${permissions.parentId == 0}">
                                        <tr class="treegrid-${permissions.id} treegrid-expanded">
                                            <td>${permissions.permissionsName}</td>
                                            <td>${permissions.permissionsCode}</td>
                                            <td>${permissions.url}</td>
                                            <td>${permissions.permissionsType}</td>
                                            <td>
                                                <a class="btn btn-primary btn-xs" href="/manager/permission/${permissions.id}/edit" title="编辑"><i class="fa fa-pencil"></i></a>
                                                <a class="btn btn-danger btn-xs delLink" rel="${permissions.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="treegrid-${permissions.id} treegrid-expanded treegrid-parent-${permissions.parentId}">
                                            <td>${permissions.permissionsName}</td>
                                            <td>${permissions.permissionsCode}</td>
                                            <td>${permissions.url}</td>
                                            <td>${permissions.permissionsType}</td>
                                            <td>
                                                <a class="btn btn-primary btn-xs" href="/manager/permission/${permissions.id}/edit" title="编辑"><i class="fa fa-pencil"></i></a>
                                                <a class="btn btn-danger btn-xs delLink" rel="${permissions.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <%@include file="../../include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function() {
        $('.tree').treegrid();

        $(".delLink").click(function(){
            var id = $(this).attr("rel");
            layer.confirm("确定要删除吗",function (index) {
                layer.close(index);
                $.get("/manager/permission/"+id+"/del").done(function (result) {
                    if(result.status == 'success') {
                        window.history.go(0);
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                });
            })
        });
    });
</script>
</body>
</html>
