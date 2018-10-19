package com.skyeye.managesystem.config;

import com.skyeye.managesystem.domain.po.User;
import com.skyeye.managesystem.mapper.StaffManageMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/10/18 下午3:04
 * @since JDK 1.8
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private StaffManageMapper staffManageMapper;

    /**
     * 鉴权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();


        return null;
    }

    /**
     * 认证
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User find = staffManageMapper.findUserByUsername(username);
        if (find==null) return null;
        return new SimpleAuthenticationInfo(username,find.getPassword(),getName());
    }

}
