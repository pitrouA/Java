<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
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
            <div><a href="createUser"><button>Créer Utilisateur</button></a></div>
            <table class="table">
                <tr>
                    <th>login</th>
                    <th>admin</th>
                    <th>manager</th>
                    <th>agent</th>
                    <th>customer</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                <c:forEach var="userItem"  items="${userList}" >
                    <tr>
                        <td><input type="text" value="${userItem.login}"/></td>
                        <td>${userItem.isAdmin()}</td>
                        <td>${userItem.isManager()}</td>
                        <td>${userItem.isAgent()}</td>
                        <td>${userItem.isCustomer()}</td>
                        <c:set var="modifyUserLink">
                            <c:url value="/updateUser">
                                <c:param name="userId" value="${userItem.id}"/>
                            </c:url>
                        </c:set>
                        <td><a href="${modifyUserLink}"><button>+</button></a></td>
                        <c:set var="deleteUserLink">
                            <c:url value="/deleteUser">
                                <c:param name="userId" value="${userItem.id}"/>
                            </c:url>
                        </c:set>
                        <td><a href="${deleteUserLink}"><button>-</button></a></td>
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
