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

@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *   在cookieDemo5 的请求头中出现的序列号，可能是IDEA 相关的版本好
         *   导致 cookieDemo2 中获取的cookie 中，也出现了版本号代码
         */


        // 1. 创建cookie 对象 ,输出中文
        Cookie c1 = new Cookie("msg", "你好!") ;

        // 设置cookie 路径
        // 让服务器下部署的所有项目共享cookie
         c1.setPath("/");

        // 发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
