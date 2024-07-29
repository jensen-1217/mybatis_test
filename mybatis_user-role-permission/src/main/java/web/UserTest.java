package web;

import com.jensen.pojo.Role;
import com.jensen.pojo.User;
import com.jensen.service.UserService;
import com.jensen.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void testQueryUserByPage(){
        UserService userService=new UserServiceImpl();
        List<User> userList = userService.queryUserByPage(2, 3);
        for (User user : userList) {
            List<Role> roleList = user.getRoles();
            System.out.println("用户信息："+user);
            for (Role role : roleList) {
                System.out.println("角色信息："+role);
            }
        }
    }

}
