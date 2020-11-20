package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Cookie 快速入门
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应体格式和编码
        response.setContentType("text/html;charset=utf-8") ;

        // 1.获取所有Cookie
        Cookie[] cookies = request.getCookies() ;
        boolean flag = false;  // 代表没有 cookie 为lastTime
        // 2.遍历cookie 数组
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                // 3. 获取cookie 名称
                String name = cookie.getName() ;
                // 判断名称是否为lastTime
                if("lastTime".equals(name)) {
                    // 有该Cookie,不是第一次访问
                    flag = true ;

                    // 设置Cookie 的Value
                    // 获取当前时间字符串，重新设置Cookie ，重发cookie
                    Date date = new Date() ;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
                    String str_date = sdf.format(date);

                    System.out.println("编码前：" + str_date);
                    
                    // URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + str_date);

                    cookie.setValue(str_date);
                    response.addCookie(cookie);

                    // 设置cookie的存活使劲按
                    cookie.setMaxAge(60*60*24*30); // 一个月
                    response.addCookie(cookie);

                    //响应数据
                    // 获取Cookie 的value
                    String value = cookie.getValue();

                    System.out.println("解码前:" + value);
                    // URL 解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);

                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>") ;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag == false) {
            // 第一次访问
            Date date = new Date() ;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
            String str_date = sdf.format(date);


            System.out.println("编码前：" + str_date);
            // URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + str_date);


            // 重新构造一个cookie
            Cookie cookie = new Cookie("lastTime",str_date) ;
            cookie.setValue(str_date);
            response.addCookie(cookie);

            // 设置cookie的存活使劲按
            cookie.setMaxAge(60*60*24*30); // 一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>") ;

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
