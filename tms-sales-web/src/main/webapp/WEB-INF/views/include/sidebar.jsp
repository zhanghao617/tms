<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <p>首页</p>
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>首页</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">售票点管理</li>
            <li class="${param.menu == 'ticket_new' ? 'active' : ''}">
                <a href="/ticket/new">
                    <i class="fa fa-circle-o"></i> <span>年票办理</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-aqua">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_out' ? 'active' : ''}">
                <a href="/ticket/out">
                    <i class="fa fa-circle-o"></i> <span>年票续费</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_store' ? 'active' : ''}">
                <a href="/store">
                    <i class="fa fa-circle-o"></i> <span>年票挂失</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_chart' ? 'active' : ''}">
                <a href="/ticket/chart">
                    <i class="fa fa-circle-o"></i> <span>年票解挂</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_chart' ? 'active' : ''}">
                <a href="/ticket/chart">
                    <i class="fa fa-circle-o"></i> <span>年票补办</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_chart' ? 'active' : ''}">
                <a href="/ticket/chart">
                    <i class="fa fa-circle-o"></i> <span>年票更换</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
            <li class="${param.menu == 'ticket_chart' ? 'active' : ''}">
                <a href="/ticket/chart">
                    <i class="fa fa-circle-o"></i> <span>办理统计</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>