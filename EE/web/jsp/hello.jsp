<%-- Установи утилиту LiveEdit которая позволит отображать изменения hnml перегрузкой сраницы браузера--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello guys</h1>
<%! int i = 5; //declaration%>
<%! private void fun() {
    System.out.println("some fun/");
}%>
<%= i + 1 + 2 %> <%-- expression --%>
<%= new Date()%>
<% class dog {          // screplet
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}%>

<% if ((Math.random() * 10) > 5){   // html v operatore sravntniya%>
 <p>Hello World</p>
<%}%>

<%= request.getHeader("")%>
<%= session.getId()%>
<%= response.getStatus()%>

</body>
</html>
