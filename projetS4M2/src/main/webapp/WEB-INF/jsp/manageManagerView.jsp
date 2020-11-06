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
                    <th>Login</th>
                    <th>AppAffectees</th>
                    <th>AppLibres</th>
                </tr>

                <c:forEach var="managerItem"  items="${managerList}" >
                    <tr>
                        <td>${managerItem.login}</td>
                        <td>
                            <ul>
                                <c:forEach var="applicationItem"  items="${applicationList}" >
                                    <c:if test="${applicationItem.responsable == managerItem}">
                                        <li>
                                            <c:set var="releaseAppLink">
                                                <c:url value="/releaseApp">
                                                    <c:param name="appId" value="${applicationItem.id}"/>
                                                </c:url>
                                            </c:set>
                                            <a href="${releaseAppLink}"><button>${applicationItem.nom}</button></a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                            <ul>
                                <c:forEach var="applicationItem"  items="${applicationList}" >
                                    <c:if test="${applicationItem.responsable == null}">
                                        <li>
                                            <c:set var="reserveAppLink">
                                                <c:url value="/reserveApp">
                                                    <c:param name="managerId" value="${managerItem.id}"/>
                                                    <c:param name="appId" value="${applicationItem.id}"/>
                                                </c:url>
                                            </c:set>
                                            <a href="${reserveAppLink}"><button>${applicationItem.nom}</button></a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </td>
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
