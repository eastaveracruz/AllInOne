<%@ page import="jsp.Student" %>
<%@ page import="jsp.MyThread" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:text>This is action</jsp:text>

<%--при редеректе форвардом сервер сразу послылает другую страницу (в отличии от редиректа)--%>
<%--<jsp:forward page="hello.jsp"/>--%>

<%--подключить бин/ параметр scope=page - бин виден только на этой странице--%>
<%--scope=request - бин будет виден на подключенных страничках--%>
<%--scope=session - пока работает сессия бин будет виден--%>
<%--scope=aplication - самый большой скоуп, виден везде и всегда--%>
<jsp:useBean id="person" class="jsp.Person"/>
<%--установить свойство--%>
<jsp:setProperty name="person" property="name" value="Tom"/>
<%--получить свойство--%>
<jsp:getProperty name="person" property="name"/>


<jsp:useBean id="thread" class="jsp.MyThread" type="java.lang.Runnable"/>
<% Runnable runnable = new MyThread(); %>

<jsp:useBean id="stud" class="jsp.Student" scope="session"/>
<% Student student = new Student(); %>

<jsp:setProperty name="stud" property="name" value="Max" />
<% stud.setName("Max"); %>

<jsp:getProperty name="stud" property="name"/>
<%= stud.getName() %>

<%! String name="Validol"; %>
<jsp:setProperty name="stud" property="name" value="<%= name %>"/>

<%--<jsp:setProperty name="stud" property="title" value="<%= request.getParameter("title") %>"/>--%>


<%--сетать все параметры из реквеста--%>
<%--<jsp:setProperty name="stud" property="*"/>--%>


<jsp:useBean id="stud2" class="jsp.Student" scope="session">
    <%--заходит сюда один раз при создании--%>
    <jsp:setProperty name="stud2" property="name" value="Max"/>
</jsp:useBean>
<br>
<jsp:getProperty name="stud2" property="name"/>


</body>
</html>
