package com.cssl.service;

import com.cssl.pojo.VoteUser;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<VoteUser> allUsers();
    //新增用户
    int addUser(VoteUser user);
    //根据用户名查询用户是否已存在
    Integer isExist(String userName);
}
