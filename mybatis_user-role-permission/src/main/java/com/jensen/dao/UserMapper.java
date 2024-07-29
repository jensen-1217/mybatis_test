package com.jensen.dao;

import com.jensen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    public List<User> findUserByPage(@Param("beginIndex") Integer beginIndex, @Param("size") Integer size);

    @Select("select id, username, password, remark, email, createTime, updateTime from t_user")
    public List<User> findAllUser();

}
