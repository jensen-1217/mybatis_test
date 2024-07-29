package com.jensen.service;

import com.jensen.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> queryUserByPage(Integer currentPage,Integer pageSize);

}
