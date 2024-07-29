package com.jensen.service.impl;

import com.jensen.dao.UserMapper;
import com.jensen.pojo.User;
import com.jensen.service.UserService;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUserByPage(Integer currentPage, Integer pageSize) {

        if (currentPage==null && pageSize==null){
            throw new RuntimeException("传递的参数不能为空");
        }

        //计算起始索引：起始索引=（页码-1）*条数
        int beginIndex=(currentPage-1)*pageSize;

        //调用dao层方法
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByPage(beginIndex, pageSize);
        sqlSession.close();

        return userList;
    }
}
