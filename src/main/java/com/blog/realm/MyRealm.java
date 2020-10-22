package com.blog.realm;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import com.blog.util.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private BloggerService bloggerService;
    /**
     * 获取授权信息的函数，因为后台不做对权限的分类，只要登录后台就有了后台的所有权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录验证
     * @param authenticationToken 基于用户名、密码的令牌
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        从令牌中取出用户名
        String userName = (String)authenticationToken.getPrincipal();
//        让Shiro去验证帐号密码
        Blogger blogger = bloggerService.getByUserName(userName);
        if(blogger != null){
            SecurityUtils.getSubject().getSession().setAttribute(Const.CURRENT_USER, blogger);
            AuthenticationInfo authenInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), getName());
            return authenInfo;
        }
        return null;
    }
}
