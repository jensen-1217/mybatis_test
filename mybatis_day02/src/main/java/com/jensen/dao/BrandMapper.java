package com.jensen.dao;

import com.jensen.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface  BrandMapper {

    public int deleteBrandByIds(@Param("ids") List<Integer> ids);

    public int updateBrand(Brand brand);

    public int addBrand(Brand brand);

    public List<Brand> findBrandByCondition3(Map paramMap);

    public List<Brand> findBrandByCondition2(Brand brand);

    //当方法中传递的参数有两个或以上时，需要使用@Param注解声明占位符参数
    public List<Brand> findBrandByCondition(@Param("brandName") String brandName,@Param("companyName") String companyName,@Param("status") int status);

    public Brand findBrandById(@Param("id") Integer id);

    public List<Brand> findAllBrand();
}
