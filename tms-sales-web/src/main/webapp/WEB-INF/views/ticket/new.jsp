<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点系统</title>
    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        .photo {
            width: 100%;
            height: 300px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 300px;
        }
    </style>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/header.jsp"%>
    <!-- =============================================== -->
    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="ticket_new"/>
    </jsp:include>
    <!-- =============================================== -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>年票办理</h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">客户信息</h3>
                    <div class="box-tools">
                        <a href="/home" class="btn btn-success btn-sm"><i class="fa fa-arrow-right"></i> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <input type="hidden" id="photo" name="photo">
                        <input type="hidden" id="customerIdCardPhoto" name="customerIdCardPhoto">
                        <input type="hidden" id="customerIdCardPhotoBack" name="customerIdCardPhotoBack">
                        <div class="form-group">
                            <label>办卡人</label>
                            <input type="text" name="storeName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input type="text" name="customerMobile" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <input type="text" name="Sex" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" name="customerAddress" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>身份证号</label>
                            <input type="text" name="customerIdCard" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>年票卡号</label>
                            <input type="text" name="ticketId" class="form-control">
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div id="picker">办卡人身份证正面照片</div>
                                <div class="photo" id="adminPhoto"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker2">办卡人身份证反面照片</div>
                                <div class="photo" id="backPhoto"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker3">办卡人照片</div>
                                <div class="photo" id="customerPhoto"></div>
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

    <%@include file="../include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="../include/js.jsp"%>
<script src="/static/plugins/uploader/webuploader.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });

        // 初始化Web Uploader
        var uploader = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: 'http://upload-z1.qiniup.com',
            fileVal:'file',
            formData:{
                "token":"${upToken}"
            },
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader.on( 'uploadSuccess', function( file,response ) {
            $("#adminPhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src","http://p7mbomeo6.bkt.clouddn.com/"+fileName+"-preview");
            $img.appendTo($("#adminPhoto"));
            //将key存放到隐藏域中
            $("#customerIdCardPhoto").val(fileName);
            layer.msg("上传成功");
        });
        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });

        // 初始化Web Uploader
        var uploader2 = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: 'http://upload-z1.qiniup.com',
            fileVal:'file',
            formData:{
                "token":"${upToken}"
            },
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker2',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        uploader2.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader2.on( 'uploadSuccess', function( file,response ) {
            $("#backPhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src","http://p7mbomeo6.bkt.clouddn.com/"+fileName+"-preview");
            $img.appendTo($("#backPhoto"));
            //将key存放到隐藏域中
            $("#customerIdCardPhotoBack").val(fileName);
            layer.msg("上传成功");
        });
        uploader2.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader2.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });

        // 初始化Web Uploader
        var uploader3 = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: 'http://upload-z1.qiniup.com',
            fileVal:'file',
            formData:{
                "token":"${upToken}"
            },
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker3',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        uploader3.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader3.on( 'uploadSuccess', function( file,response ) {
            $("#customerPhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src","http://p7mbomeo6.bkt.clouddn.com/"+fileName+"-preview");
            $img.appendTo($("#customerPhoto"));
            //将key存放到隐藏域中
            $("#photo").val(fileName);
            layer.msg("上传成功");
        });
        uploader3.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader3.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });
    })
</script>
</body>
</html>
