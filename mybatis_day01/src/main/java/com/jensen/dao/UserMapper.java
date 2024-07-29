package com.jensen.dao;

import com.jensen.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAllUser();

    public int addUser(User user);

    public User findUser(Integer id);

    public int updateUser(User user);

    public int deleteUserById(Integer id);
}
