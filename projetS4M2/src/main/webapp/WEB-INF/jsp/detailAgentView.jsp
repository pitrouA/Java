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
    <title>Détail Agent</title>
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
                <div><a href="/manageAgent"><img src="../images/return.png" width="30px" alt="C"/></a>Infos de ${agent.login}</div>
                <div>Responsable : ${agent.responsable.login}</div>

                <table class="table">
                    <tr>
                        <th>Applications(${applicationList.size()})</th>
                        <th>ticketsPrisEnCharge(${ticketList.size()})</th>
                        <th>resolutions(${resolutionList.size()})</th>
                    </tr>
                    <tr>
                        <td>
                            <ul width="100%" height="100%">
                                <c:forEach var="applicationItem"  items="${applicationList}" >
                                    <li>${applicationItem.nom}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                            <ul width="100%" height="100%">
                                <c:forEach var="ticketItem"  items="${ticketList}" >
                                    <li>${ticketItem.title}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                            <ul width="100%" height="100%">
                                <c:forEach var="resolutionItem"  items="${resolutionList}" >
                                    <li>${resolutionItem.description}</li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
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
