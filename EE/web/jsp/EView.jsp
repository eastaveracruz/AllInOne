
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--экспрешены не будут компилированться--%>
<%--<%@ page isELIgnored="true" %>--%>

<%--экспрешены не будут компилированться--%>
<%--web.xml--%>
<%--<jsp-config>--%>
    <%--<jsp-property-group>--%>
        <%--<url-pattern>/jsp/*jsp</url-pattern>--%>
        <%--<el-ignored>true</el-ignored>--%>
    <%--</jsp-property-group>--%>
<%--</jsp-config>--%>

<%--запрет на использование скриптов--%>
<%--<jsp-config>--%>
    <%--<jsp-property-group>--%>
        <%--<url-pattern>/jsp/*jsp</url-pattern>--%>
        <%--<scripting-invalid>true</scripting-invalid>--%>
    <%--</jsp-property-group>--%>
<%--</jsp-config>--%>

<html>
<head>
    <title>EView</title>
</head>
<body>

${ stud.name}<br>
${ stud["age"]}<br>
${ requestScope.stud.title}<br>

${list[1]}<br>


${map.two}<br>
${map["one"]}<br>
<br>
${1 + 3 / 4}<br>
<br>
${map.two == "three"}<br>

${map.two > 1 ? "p":"l"}<br>

${cookie.JSESSIONID}


</body>
</html>
