package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    // 声明JDBCTemplate 对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()) ;

    // 暂时先返回一个 User类的对象，目前只包含登录名和密码
    // 如果数据库里有匹配的数据，则返回数据
    // 如果数据库里没有匹配数据，则返回null
    public User login(User loginUser)   {
        try {
            // 1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            // 调用 query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword()
            );
            return user;
        }  catch(DataAccessException e) {
            e.printStackTrace();
            return null ;
        }

//            // 1.编写sql
//            String sql = "select * from user where username = ? and password = ?";
//            // 调用 query方法
//            User user = template.queryForObject(sql,
//                    new BeanPropertyRowMapper<User>(User.class),
//                    loginUser.getUsername(),
//                    loginUser.getPassword()
//            );
//            return user;
    }
}
