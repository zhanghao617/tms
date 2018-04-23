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
        <jsp:param name="menu" value="manager_role"/>
    </jsp:include>
    <!-- =============================================== -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>角色管理</h1>
        </section>
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">角色列表</h3>
                    <div class="box-tools">
                        <a href="/manager/role/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增角色</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table tree">
                        <tbody>
                        <c:forEach items="${roleList}" var="role">
                            <tr class="bg-blue">
                                <td>
                                    角色名称：<strong>${role.roleName}</strong>
                                        <span class="pull-right">
                                                <a style="color: #fff;" href="/manager/role/${role.id}/edit"><i class="fa fa-pencil"></i></a>
                                                <a style="color: #fff;" class="delLink" rel="${role.id}" href="javascript:;"><i class="fa fa-trash"></i></a>
                                        </span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <c:forEach items="${role.permissionList}" var="per">
                                        <i class="fa fa-key fa-fw"></i> ${per.permissionsName}
                                    </c:forEach>
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
    <%@include file="../../include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="../../include/js.jsp"%>

<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        $('.tree').treegrid();
        //删除
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除该角色？",function (index) {
                layer.close(index);
                $.get("/manager/role/"+id+"/del").done(function (result) {
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
