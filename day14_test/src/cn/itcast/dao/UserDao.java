package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import com.alibaba.druid.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  操作数据库User 表的类
 */

public class UserDao {
   // 生命JDBCTemplate 对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource() ) ;


    /**
     *  登录方法
     * @param loginUser 只有用户名和密码
     * @return   user 包含用户全部数据
     *                   如果没有获取信息，则返回null ;
     */
    public User login(User loginUser) {
        try {
            // 编写sql
            String sql = "select * from user where username = ? and password = ?" ;
            // 调用query 方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword()
            );
            return  user ;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null ;
        }
    }
}
