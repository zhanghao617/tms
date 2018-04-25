<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 综合管理系统</title>
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
        <jsp:param name="menu" value="ticket_store"/>
    </jsp:include>
    <!-- =============================================== -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>添加售票点</h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">售票点列表</h3>
                    <div class="box-tools">
                        <a href="/store" class="btn btn-success btn-sm"><i class="fa fa-arrow-right"></i> 返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <input type="hidden" name="id" value="${store.id}">
                        <input type="hidden" id="storeIdcardFront" name="storeIdcardFront" value="${store.storeIdcardFront}">
                        <input type="hidden" id="storeProof" name="storeProof" value="${store.storeProof}">
                        <input type="hidden" name="storeAccountId" value="${store.storeAccountId}">
                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" name="storeName" value="${store.storeName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input type="text" name="storeMobile" value="${store.storeMobile}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>法人</label>
                            <input type="text" name="storeAdmin" value="${store.storeAdmin}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" name="storeAddress" value="${store.storeAddress}" class="form-control">
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div id="picker">选择联系人身份证照片</div>
                                <div class="photo" id="adminPhoto"><img src="http://p7mbomeo6.bkt.clouddn.com/${store.storeIdcardFront}-preview" alt=""></div>
                            </div>
                            <div class="col-md-6">
                                <div id="picker2">选择营业执照照片</div>
                                <div class="photo" id="storePhoto"><img src="http://p7mbomeo6.bkt.clouddn.com/${store.storeProof}-preview" alt=""></div>
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
            $("#storeIdcardFront").val(fileName);
            layer.msg("上传成功");
        });
        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index);
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
            pick: '#picker2',
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
            $("#storePhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src","http://p7mbomeo6.bkt.clouddn.com/"+fileName+"-preview");
            $img.appendTo($("#storePhoto"));
            //将key存放到隐藏域中
            $("#storeProof").val(fileName);
            layer.msg("上传成功");
        });
        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });
    })
</script>
</body>
</html>
