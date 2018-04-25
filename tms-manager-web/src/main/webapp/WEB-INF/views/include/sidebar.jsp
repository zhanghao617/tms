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
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- 搜索框search form -->
        <%--<form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>--%>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">系统功能</li>
            <li class="${param.menu == 'ticket_store' ? 'active' : ''}">
                <a href="/store">
                    <i class="fa fa-circle-o"></i> <span>售票点信息</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-black">★</small>
                        </span>
                </a>
            </li>
        </ul>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">系统管理</li>
            <li class="${param.menu == 'manager_account' ? 'active' : ''}">
                <a href="/manager/account">
                    <i class="fa fa-circle-o"></i> <span>账号管理</span>
                    <span class="pull-right-container">
                          <small class="label pull-right bg-yellow">★</small>
                     </span>
                </a>
            </li>
            <li class="${param.menu == 'manager_role' ? 'active' : ''}">
                <a href="/manager/role">
                    <i class="fa fa-circle-o"></i> <span>角色管理</span>
                    <span class="pull-right-container">
                      <small class="label pull-right bg-green">★</small>
                    </span>
                </a>
            </li>
            <li class="${param.menu == 'manager_permission' ? 'active' : ''}">
                <a href="/manager/permission">
                    <i class="fa fa-circle-o"></i> <span>权限管理</span>
                    <span class="pull-right-container">
                      <small class="label pull-right bg-red">★</small>
                    </span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>