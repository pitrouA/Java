<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Gestion des tickets</title>
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
            <c:if test="${sessionScope.user.isCustomer()}">
                <div><a href="createTicket"><button>Créer Ticket</button></a></div>
            </c:if>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>titre</th>
                    <th>date</th>
                    <th>description</th>
                    <th>Etat</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="ticketItem"  items="${ticketList}" >
                    <tr>
                        <td>${ticketItem.id}</td>
                        <td>${ticketItem.title}</td>
                        <td>${ticketItem.date}</td>
                        <td>${ticketItem.description}</td>
                        <c:if test="${not sessionScope.user.isAgent()}">
                            <c:if test="${ticketItem.reservedBy != null}">
                                <td>En cours de résolution</td>
                            </c:if>
                            <c:if test="${ticketItem.reservedBy == null}">
                                <td>Non résolu</td>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.user.isAgent()}">
                            <c:if test="${ticketItem.reservedBy == null}">
                                <c:set var="reserveTicketLink">
                                    <c:url value="/reserveTicket">
                                        <c:param name="ticketId" value="${ticketItem.id}"/>
                                    </c:url>
                                </c:set>
                                <td><a href="${reserveTicketLink}"><button>Réserver</button></a></td>
                            </c:if>
                            <c:if test="${ticketItem.reservedBy != null}">
                                <c:if test="${user.equals(ticketItem.reservedBy)}">
                                    <c:set var="releaseTicketLink">
                                        <c:url value="/releaseTicket">
                                            <c:param name="ticketId" value="${ticketItem.id}"/>
                                        </c:url>
                                    </c:set>
                                    <td><a href="${releaseTicketLink}"><button>liberer</button></a></td>
                                    <td>
                                        <c:set var="resolveTicket">
                                            <c:url value="/resolveTicket">
                                                <c:param name="ticketId" value="${ticketItem.id}"/>
                                            </c:url>
                                        </c:set>
                                        <a href="${resolveTicket}"><button>Résoudre</button></a>
                                    </td>
                                </c:if>
                                <c:if test="${not user.equals(ticketItem.reservedBy)}">
                                    <td>Reservé par : ${ticketItem.reservedBy.login}</td>
                                </c:if>
                            </c:if>
                        </c:if>
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
