package cn.itcast.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *  Cookie 快速入门
 */

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session 共享数据

        // 注意 JsessionID只有在关闭浏览器后，再打开，第一次访问服务器时
        // 才会出现再浏览器的响应头里。

        // google : JSESSIONID=DCFA04E8E2A66AD432D3FF3348763C8D;
        // google : JSESSIONID=58EF8D5A9D7D6438C188C7DE6BD8801D;
        // 360 :    JSESSIONID=3529D0D220A350D9C4605788534D7DBC;
        // 360 :    JSESSIONID=70C6DA30047CABE5F1BAC8DAC6505EC2;
        HttpSession session = request.getSession();

        session.setAttribute("msg","hello session");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
