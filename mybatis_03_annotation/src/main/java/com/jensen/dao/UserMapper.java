package com.jensen.dao;

import com.jensen.pojo.User;
import org.apache.ibatis.annotations.*;
import sun.nio.cs.US_ASCII;

import java.util.List;

public interface UserMapper {

    //@Select("select id,user_name,password,name,age,sex from tb_user where sex=1 and name like concat('%',#{name},'%')")
    @SelectProvider(type = SqlProvider.class,method = "findUserByName2")//接收组装后的sql语句
    @ResultMap(value = "userMap")
    public List<User> findUserByLike(@Param("name") String name);

    @Insert("insert into tb_user(user_name, password, name, age, sex)  "+
            "values (#{userName},#{password},#{name},#{age},#{age})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int addUserGetPK(User user);

    @Update("update tb_user set password=#{password} where user_name=#{username}")
    public int updateUser(@Param("username") String username, @Param("password") String password);

    @Select("select id ,user_name, password,name,age,sex from tb_user")
    @Results(id = "userMap",
            value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "user_name",property = "userName")})
    public List<User> findAllUser();

    @Insert("insert into tb_user(user_name, password, name, age, sex)  "+
            "values (#{userName},#{password},#{name},#{age},#{age})")
    public int addUser(User user);

    @Select("select id,user_name,password,name,age,sex from tb_user where id=#{id}")
    @ResultMap(value = "userMap")
    public User findUserById(Integer id);

}
