package com.xgit.iot.security;

import com.xgit.iot.service.system.JiahuaUserService;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbUserDetailsService implements UserDetailsService {

    private final JiahuaUserService userService;

    @Autowired
    DbUserDetailsService(JiahuaUserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JiahuaUserVO userVO = userService.selectByUserName(username);
        if (userVO == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(userVO.getUserName(), userVO.getPassword(), simpleGrantedAuthorities);
    }

}
