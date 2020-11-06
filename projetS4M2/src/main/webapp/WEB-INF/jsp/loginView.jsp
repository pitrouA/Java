<%--
  jsp avec scriptlet, old style
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Page de login</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
    <jsp:include page="../templates/Header.jsp"/>
    <table width="100%" border="0" cellspacing="5" cellpadding="5" style="border:1px solid #aaa;word-break: break-word;table-layout: fixed;">
        <colgroup>
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
            <col width="5%"><col width="5%">
        </colgroup>
        <tr>
            <td colspan=3 class="column menu">
                <jsp:include page="../templates/Menu.jsp"/>
            </td rowspan="2">
            <td colspan=14 class="column content">
                <form action="login" method="post">
                    <div>Login : <input name="login" type="text" value=""></input></div>
                    <div>Password : <input name="password" type="password" value=""></input></div>
                    <input type="submit" value="Log In"/>
                </form>
            </td>
            <td colspan=3 class="column logger">
                <jsp:include page="../templates/Logger.jsp"/>
            </td>
        </tr>
    </table>
    <jsp:include page="../templates/Footer.jsp"/>
</body>
</html>
