<%@ page import="java.io.BufferedWriter" %><%--
  Created by IntelliJ IDEA.
  User: Talian
  Date: 2020/11/19
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
        <font size="20" color="red">Talian, welcome back!</font>

        <br>

        <% response.getWriter().write("response") ; %>

        <br>

        <%
            System.out.println("hello jsp");
            int i = 5;
            String contextPath = request.getContextPath();
            System.out.println(contextPath);

            out.print(contextPath);
        %>

        <br>



        <br>

        <%!
            int i = 3 ;
        %>

        <br>

        <%=i%>

        <h1>hi ~ jsp!<br>
            I am used to reduce the complexity of Page.<br>
            Jsp is equivalent to Servlet!
        </h1>
</body>
</html>
