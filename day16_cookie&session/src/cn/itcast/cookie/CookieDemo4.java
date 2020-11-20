package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie 快速入门
 */

@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建cookie 对象
        Cookie c1 = new Cookie("msg", "setMaxAge") ;
        // 2.设置cookie 存活时间
       //  c1.setMaxAge(30);  // 持久化到硬盘30s

//        c1.setMaxAge(-1);

        // 清空cookie
        c1.setMaxAge(0);



        // 发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
