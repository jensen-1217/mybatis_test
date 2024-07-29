import com.jensen.dao.UserMapper;
import com.jensen.pojo.Role;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void testFindUserByPage(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByPage(0, 3);
        sqlSession.close();
        for (User user : userList) {
            List<Role> roleList = user.getRoles();
            System.out.println("用户信息："+user);
            for (Role role : roleList) {
                System.out.println("角色信息："+role);
            }
        }
    }

    @Test
    public void testFindAllUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllUser();
        for (User user : userList) {
            sqlSession.close();
            System.out.println(user);
        }
    }

}
