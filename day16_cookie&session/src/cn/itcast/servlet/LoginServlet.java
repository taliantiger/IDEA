package cn.itcast.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 封装User 对象
        User loginUser = new User();
        // 把用户输入的用户名和密码，封装到loginUser中
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        // 再把loginUser 对象，导入到dao.login() 方法中
        UserDao dao = new UserDao();
        User user = dao.login(loginUser) ;


        // checkCode 对应用户自己输入的验证码
        String checkCode = request.getParameter("checkCode");

        // 3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除session 中存储的验证码
        session.removeAttribute("checkCode_session");

        // 3.判断验证码
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode) ) {
            // 忽略大小写
            // 判断用户密码是否一致
            // if(user.getUsername().equals(username) && "123".equals(password) ) {  // 需要查询数据库
            if( user != null ) {  // 需要查询数据库
                // 登录成功
                // 存储用户信息
                session.setAttribute("user",username) ;
                // 重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");

            }  else {
                // 登录失败
                // 存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误") ;
                // 转发登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } else {
            // 验证码不正确
            // 存储提示信息到request
            request.setAttribute("cc_error","验证码错误") ;
            // 转发登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
