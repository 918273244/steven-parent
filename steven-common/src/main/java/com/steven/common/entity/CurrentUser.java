package com.steven.common.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by Steven on 2017/4/17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private  User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public CurrentUser(User users) {
        super(users.getUsername(), users.getUserpassword(), AuthorityUtils.createAuthorityList(users.getRole()));
        this.users = users;
    }

    public CurrentUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
