import com.jensen.dao.BrandMapper;
import com.jensen.pojo.Brand;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BrandMapperTest {

    @Test
    public void testDeleteBrand(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids,5,6,7,8,9,10,11,12,13);
        int count = brandMapper.deleteBrandByIds(ids);
        if (count>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("删除成功！");
        }
    }

    @Test
    public void testUpdateBrand(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        //brand.setBrandName("苹果123");
        //brand.setCompanyName("苹果股份有限公司");
        brand.setDescription("过时了");
        brand.setOrdered(99);
        brand.setStatus(1);
        brand.setId(4);
        int count = brandMapper.updateBrand(brand);
        if (count>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("修改成功！");
        }
    }

    @Test
    public void testAddBrand(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("苹果");
        brand.setCompanyName("苹果股份有限公司");
        brand.setDescription("好用");
        brand.setOrdered(9);
        brand.setStatus(1);
        int i = brandMapper.addBrand(brand);
        if (i>0){
            MyBatisUtil.closeSqlSession(sqlSession);
            System.out.println("添加成功");
        }
    }

    @Test
    public void testFindBrandByCondition3() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Map map = new HashMap();
//        map.put("brandname", "华为");
//        map.put("companyname", "华为技术有限公司");
        map.put("status", 1);
        List<Brand> brandList = brandMapper.findBrandByCondition3(map);
        MyBatisUtil.closeSqlSession(sqlSession);
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }

    @Test
    public void testFindBrandByCondition2(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand1 = new Brand();
        brand1.setBrandName(null);
        brand1.setCompanyName("华为技术有限公司");
        brand1.setStatus(1);
        List<Brand> brandList = brandMapper.findBrandByCondition2(brand1);
        MyBatisUtil.closeSqlSession(sqlSession);
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }

    @Test
    public void testFindBrandByCondition(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.findBrandByCondition(null, "三只松鼠股份有限公司", 0);
        MyBatisUtil.closeSqlSession(sqlSession);
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }

    @Test
    public void testFindBrandById(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.findBrandById(1);
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(brand);
    }

    @Test
    public void testFindAllBrand(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList= brandMapper.findAllBrand();
        MyBatisUtil.closeSqlSession(sqlSession);
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }
}
