<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Résoudre un ticket</title>
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
            <form:form method="POST" action="/resolveTicket" modelAttribute="resolution">
                <table height="100%">
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
                    <tr>
                        <td colspan=17><form:input path="description" value="La solution était simple : c'était ..."/></td>
                        <form:hidden path="resolvedBy" value="${user.id}"/>
                        <form:hidden path="ticket" value="${ticketItem.id}"/>
                        <td colspan=3><input type="submit" value="Résoudre"/></td>
                    </tr>
                </table>
            </form:form>
        </td>
        <td colspan=3 class="column logger">
            <jsp:include page="../templates/Logger.jsp"/>
        </td>
    </tr>
</table>
<jsp:include page="../templates/Footer.jsp"/>
</body>
</html>
