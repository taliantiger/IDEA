package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        // 创建一个 User
        // 相当于在这里手动输入一个用户名和密码
        // 等一下判断用户名或密码又没错误
        User loginuser = new User() ;
        loginuser.setUsername("superbaby");
        loginuser.setPassword("1233");


        UserDao dao = new UserDao() ;
        // 把构建的loginuser 导入UserDao 的登录方法
        User user = dao.login(loginuser) ;
        System.out.println(user);
    }


}
