package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private  static DataSource ds ;


    // 利用Druid 工厂
    static {
        try {
            // 加载配置文件
            Properties pro = new Properties() ;
            // 利用ClassLoader 获得字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

           ds =  DruidDataSourceFactory.createDataSource(pro) ;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  连接池对象
    public static DataSource getDataSource() {
        return ds ;
    }




    // Connection 对象
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection() ;

    }

}
