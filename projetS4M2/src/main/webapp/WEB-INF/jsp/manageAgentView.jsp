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
    <title>Gestion des agents</title>
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
                    <th>login</th>
                    <th>Responsable</th>
                    <th>voir détail</th>
                </tr>
                <c:forEach var="agentItem"  items="${agentList}" >
                    <tr>
                        <td>${agentItem.login}</td>
                        <c:if test="${agentItem.responsable == null}">
                            <c:set var="reserveAgentLink">
                                <c:url value="/reserveAgent">
                                    <c:param name="agentId" value="${agentItem.id}"/>
                                </c:url>
                            </c:set>
                            <td><a href="${reserveAgentLink}"><button>Réserver</button></a></td>
                        </c:if>
                        <c:if test="${agentItem.responsable != null}">
                            <c:set var="releaseAgentLink">
                                <c:url value="/releaseAgent">
                                    <c:param name="agentId" value="${agentItem.id}"/>
                                </c:url>
                            </c:set>
                            <td><a href="${releaseAgentLink}"><button>Libérer</button></a></td>
                        </c:if>
                        <td>
                            <c:set var="detailAgentLink">
                                <c:url value="/detailAgent">
                                    <c:param name="userId" value="${agentItem.id}"/>
                                </c:url>
                            </c:set>
                            <a href="${detailAgentLink}"><button>infos</button></a>
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
