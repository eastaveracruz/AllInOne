<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@include file="hello.jsp" %> &lt;%&ndash; предпроцессорная на этапе компиляции &ndash;%&gt;-- не рекомендовано к использованию%>
<jsp:include page="hello.jsp"/> <%-- на этапе реквеста --%>
<jsp:include page="/hello"/>
</body>
</html>
