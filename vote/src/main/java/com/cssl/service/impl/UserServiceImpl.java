package com.cssl.service.impl;

import com.cssl.mapper.UserMapper;
import com.cssl.pojo.VoteUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public List<VoteUser> allUsers() {
        return um.allUsers();
    }

    @Override
    public int addUser(VoteUser user) {
        return um.addUser(user);
    }

    @Override
    public Integer isExist(String userName) {
        return um.isExist(userName);
    }
}
