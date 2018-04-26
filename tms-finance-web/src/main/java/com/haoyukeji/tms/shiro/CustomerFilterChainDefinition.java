package com.haoyukeji.tms.shiro;

import com.haoyukeji.tms.entity.Permissions;
import com.haoyukeji.tms.service.RolePermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 动态定义权限和URL的关系
 */
public class CustomerFilterChainDefinition{

    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);

    @Autowired
    private RolePermissionService rolePermissionService;

    private String filterChainDefinitions;
    private AbstractShiroFilter shiroFilter;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    @PostConstruct
    public synchronized void init() {
        logger.info("------------初始化Url权限-----------");
        //清除原有的url权限
        getFilterChainManager().getFilterChains().clear();
        load();
        logger.info("------------初始化Url权限完成-----------");
    }

    //重新加载url权限
    public synchronized void updateUelPermission() {
        logger.info("------------刷新Url权限-----------");
        //清除原有的url权限
        getFilterChainManager().getFilterChains().clear();
        load();
        logger.info("------------刷新Url权限完成-----------");

    }

    //加载url和权限的对应关系
    public synchronized void load() {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        List<Permissions> permissionsList = rolePermissionService.findAllPermission();
        Ini.Section section = ini.get(Ini.DEFAULT_SECTION_NAME);

        for (Permissions permissions : permissionsList) {
            section.put(permissions.getUrl(), "perms[" + permissions.getPermissionsCode() + "]");
        }
        section.put("/**", "user");
        System.out.println("_______________----------加载url权限完成-----------_______________");

        //URL和权限的关系设置到shiroFilter中
        DefaultFilterChainManager defaultFilterChainManager = getFilterChainManager();
        for(Map.Entry<String,String> entry : section.entrySet()) {
            defaultFilterChainManager.createChain(entry.getKey(),entry.getValue());
        }
    }

    private DefaultFilterChainManager getFilterChainManager() {
        PathMatchingFilterChainResolver pathMatchingFilterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) pathMatchingFilterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }

}
