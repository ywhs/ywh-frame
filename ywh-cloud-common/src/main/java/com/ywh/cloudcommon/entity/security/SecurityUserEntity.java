package com.ywh.cloudcommon.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * CreateTime: 2019-06-30 17:36
 * ClassName: SecurityUserEntity
 * Package: com.ywh.cloudcommon.entity.security
 * Describe:
 * security用户实体类
 *
 * @author YWH
 */
public class SecurityUserEntity implements UserDetails {

    /**
     * 用户的密码
     */
    private String password;

    /**
     * 用户的名字
     */
    private String username;

    /**
     * 用户状态，1 表示有效用户， 0表示无效用户
     */
    private Integer state;

    /**
     * 用户的权限，可以把用户的角色信息的集合先放进来，角色代表着权限
     */
    private Collection<? extends GrantedAuthority> authorties;


    public SecurityUserEntity(String password, String username, Integer state, Collection<? extends GrantedAuthority> authorties) {
        this.password = password;
        this.username = username;
        this.state = state;
        this.authorties = authorties;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorties;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 指示用户的帐户是否已过期。过期的帐户无法通过身份验证。
     * @return true如果用户的帐户有效（即未过期）， false如果不再有效（即已过期）
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是锁定还是解锁。锁定的用户无法进行身份验证。
     * @return true是未锁定，false是已锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示用户的凭据（密码）是否已过期。过期的凭据会阻止身份验证
     * @return true如果用户的凭证有效（即未过期）， false如果不再有效（即已过期）
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 指示用户是启用还是禁用。禁用的用户无法进行身份验证。
     * @return true用户已启用，false用户已经禁用
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return state == 1;
    }

}
