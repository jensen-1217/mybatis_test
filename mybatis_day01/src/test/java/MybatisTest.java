import com.jensen.dao.UserMapper;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class MybatisTest {



    @Test
    public void testDeleteUserById(){
        SqlSession sqlSession = MyBatisUtil.openSession();

        //利用SqlSession对象，创建一个代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



        int i = userMapper.deleteUserById(8);

        MyBatisUtil.closeSqlSession(sqlSession);

        System.out.println(i);
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();

        //利用SqlSession对象，创建一个代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUser(9);
//        User user = new User(8, "白龙马",null, "男", "东海龙宫");
        user.setUsername("白岩");
        user.setSex("女");
        user.setAddress("厕所");
        int i = userMapper.updateUser(user);
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(i);
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();

        //利用SqlSession对象，创建一个代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null, "白龙马2", new Date(System.currentTimeMillis()), "男", "东海龙宫");
        int i = userMapper.addUser(user);

//        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println(i);
    }

    @Test
    public  void testFindAllUserById() throws IOException {

        SqlSession sqlSession = MyBatisUtil.openSession();

        //利用SqlSession对象，创建一个代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        User user = userMapper.findUser(1);

        MyBatisUtil.closeSqlSession(sqlSession);

        System.out.println(user);
    }

    @Test
    public  void testFindAllUser() throws IOException {

        SqlSession sqlSession = MyBatisUtil.openSession();

        //利用SqlSession对象，创建一个代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //使用代理对象，调用方法查询用户数据
        List<User> userList = userMapper.findAllUser();

        MyBatisUtil.closeSqlSession(sqlSession);

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
