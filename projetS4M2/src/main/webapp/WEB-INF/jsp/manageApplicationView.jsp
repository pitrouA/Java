<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Gestion des Managers</title>
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
            <table class="table">
                <tr>
                    <th>NomAppli</th>
                    <th>Description</th>
                    <c:if test="${user.admin}">
                        <th>Responsable</th>
                        <th></th>
                    </c:if>
                </tr>

                <c:forEach var="applicationItem"  items="${applicationList}" >
                    <tr>
                        <form:form method="POST" action="/changeApplication" modelAttribute="application">
                            <td><form:label path="nom">${applicationItem.nom}</form:label></td>
                            <td><form:label path="description">${applicationItem.description}</form:label></td>
                            <form:hidden path="nom" value="${applicationItem.nom}"/>
                            <form:hidden path="id" value="${applicationItem.id}"/>
                            <c:if test="${user.admin}">
                                <td>
                                    <form:select path="responsable">
                                        <c:forEach var="managerItem"  items="${managerList}" >
                                            <c:if test="${applicationItem.responsable.id == managerItem.id}">
                                                <form:option selected="true" label="${managerItem.login}" value="${managerItem.id}" />
                                            </c:if>
                                            <c:if test="${applicationItem.responsable.id != managerItem.id}">
                                                <form:option label="${managerItem.login}" value="${managerItem.id}" />
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                </td>
                                <td><input type="submit" value="Submit"/></td>
                            </c:if>
                        </form:form>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td colspan=3 class="column logger">
            <jsp:include page="../templates/Logger.jsp"/>
        </td>
    </tr>
</table>
<jsp:include page="../templates/Footer.jsp"/>
</body>
</html>
