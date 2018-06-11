<%@ page import="jsp.Student" %><%--
  Created by IntelliJ IDEA.
  User: Protsko
  Date: 11.06.2018
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyView</title>
</head>
<body>

    <%--req.setAttribute("Student", student);--%>
    <jsp:useBean id="Student" class="jsp.Student" scope="request"/>


    <%--req.getSession().setAttribute("Student", student);--%>
    <%--<jsp:useBean id="student" class="jsp.Student" scope="session"/>--%>

    <%--req.getServletContext().setAttribute("Student", student);--%>
    <%--<jsp:useBean id="student" class="jsp.Student" scope="application"/>--%>
    <jsp:getProperty name="Student" property="title"/>
    <br>
    <jsp:getProperty name="Student" property="name"/>
    <br>
    <%= ((Student) request.getAttribute("Student")).getAge() %>
    <br>

</body>
</html>
