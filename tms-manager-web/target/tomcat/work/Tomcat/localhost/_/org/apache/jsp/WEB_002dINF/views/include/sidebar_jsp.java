/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-23 06:41:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!-- Left side column. contains the sidebar -->\r\n");
      out.write("<aside class=\"main-sidebar\">\r\n");
      out.write("    <!-- sidebar: style can be found in sidebar.less -->\r\n");
      out.write("    <section class=\"sidebar\">\r\n");
      out.write("        <!-- Sidebar user panel -->\r\n");
      out.write("        <p>首页</p>\r\n");
      out.write("        <div class=\"user-panel\">\r\n");
      out.write("            <div class=\"pull-left image\">\r\n");
      out.write("                <img src=\"/static/dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"pull-left info\">\r\n");
      out.write("                <p>Alexander Pierce</p>\r\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 搜索框search form -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <!-- /.search form -->\r\n");
      out.write("        <!-- sidebar menu: : style can be found in sidebar.less -->\r\n");
      out.write("        <ul class=\"sidebar-menu\" data-widget=\"tree\">\r\n");
      out.write("            <li class=\"header\">系统功能</li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == '' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <a href=\"/store\">\r\n");
      out.write("                    <i class=\"fa fa-circle-o\"></i> <span>售票点信息</span>\r\n");
      out.write("                    <span class=\"pull-right-container\">\r\n");
      out.write("                          <small class=\"label pull-right bg-black\">★</small>\r\n");
      out.write("                        </span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"sidebar-menu\" data-widget=\"tree\">\r\n");
      out.write("            <li class=\"header\">系统管理</li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'manager_account' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <a href=\"/manager/account\">\r\n");
      out.write("                    <i class=\"fa fa-circle-o\"></i> <span>账号管理</span>\r\n");
      out.write("                    <span class=\"pull-right-container\">\r\n");
      out.write("                          <small class=\"label pull-right bg-yellow\">★</small>\r\n");
      out.write("                     </span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'manager_role' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <a href=\"/manager/role\">\r\n");
      out.write("                    <i class=\"fa fa-circle-o\"></i> <span>角色管理</span>\r\n");
      out.write("                    <span class=\"pull-right-container\">\r\n");
      out.write("                      <small class=\"label pull-right bg-green\">★</small>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'manager_permission' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <a href=\"/manager/permission\">\r\n");
      out.write("                    <i class=\"fa fa-circle-o\"></i> <span>权限管理</span>\r\n");
      out.write("                    <span class=\"pull-right-container\">\r\n");
      out.write("                      <small class=\"label pull-right bg-red\">★</small>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- /.sidebar -->\r\n");
      out.write("</aside>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
