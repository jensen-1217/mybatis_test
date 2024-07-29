package com.jensen.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SqlProvider {

    public String findUserByName2(@Param("name") String name){
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_user").WHERE("sex=1");
        if (name!=null){
            sql.AND().WHERE("name like concat('%',#{name},'%')");
        }
        return sql.toString();
    }

    public String findUserByName(@Param("name") String name){
        String sql="select id,user_name,password,name,age,sex from tb_user where sex=1";
        if (name!=null && !"".equals(name)){
            sql+=" and name like concat('%',#{name},'%')";
        }
        return sql;
    }
}
