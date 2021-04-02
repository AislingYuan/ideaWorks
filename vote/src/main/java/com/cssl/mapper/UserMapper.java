package com.cssl.mapper;

import com.cssl.pojo.VoteUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户
    List<VoteUser> allUsers();
    //新增用户
    int addUser(VoteUser user);
    //根据用户名查询用户是否已存在
    Integer isExist(String userName);
}
