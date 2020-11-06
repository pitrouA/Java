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
    <title>Créer un ticket</title>
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
                <form:form method="POST" action="/createTicket" modelAttribute="ticket">
                    <form:hidden path="postedBy" value="${user.id}"/>
                    <table>
                        <tr>
                            <td><form:label path="title">Titre</form:label></td>
                            <td><form:input path="title" value="Aidez-moi"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="description">Description</form:label></td>
                            <td><form:input path="description" value="Une breve description"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="date">Date</form:label></td>
                            <td><form:input path="date" type="date" value="2020-05-23"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="application">Application</form:label></td>
                            <td>
                                <form:select path="application">
                                    <!--<form:option value="-1">Application</form:option>-->
                                    <form:options items="${applicationList}" itemLabel="nom" itemValue="id" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit"/></td>
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
