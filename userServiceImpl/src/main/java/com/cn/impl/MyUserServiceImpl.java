package com.cn.impl;


import com.cn.entity.SecurityUser;
import com.cn.entity.User;
import com.cn.service.MyUserService;
import com.cn.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyUserServiceImpl implements UserDetailsService, MyUserService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        String name = user.getName();
        String password = user.getPassword();
        String authority = user.getAccount();
        return new SecurityUser(name, password, AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
    }
}
