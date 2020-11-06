<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Créer un utilisateur</title>
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
                    <form:form method="POST" action="${mode == 'create' ? '/createUser' : '/updateUser'}" modelAttribute="userModel">
                        <tr>
                            <td><form:label  path="login">Login</form:label></td>
                            <td><form:input path="login" value="${userModel.login}"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="password">Password</form:label></td>
                            <td><form:input path="password" value="${userModel.password}"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="birthDate">BirthDate</form:label></td>
                            <td><form:input path="birthDate" type="date" value="2020-05-23"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="admin">isAdmin</form:label></td>
                            <c:if test="${userModel.admin}">
                                <td><form:checkbox path="admin" value="admin" checked="checked"/></td>
                            </c:if>
                            <c:if test="${not userModel.admin}">
                                <td><form:checkbox path="admin" value="admin"/></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td><form:label path="manager">isManager</form:label></td>
                            <c:if test="${userModel.manager}">
                                <td><form:checkbox path="manager" value="manager" checked="checked"/></td>
                            </c:if>
                            <c:if test="${not userModel.manager}">
                                <td><form:checkbox path="manager" value="manager"/></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td><form:label path="agent">isAgent</form:label></td>
                            <c:if test="${userModel.agent}">
                                <td><form:checkbox path="agent" value="agent" checked="checked"/></td>
                            </c:if>
                            <c:if test="${not userModel.agent}">
                                <td><form:checkbox path="agent" value="agent"/></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td><form:label path="customer">isCustomer</form:label></td>
                            <c:if test="${userModel.customer}">
                                <td><form:checkbox path="customer" value="customer" checked="checked"/></td>
                            </c:if>
                            <c:if test="${not userModel.customer}">
                                <td><form:checkbox path="customer" value="customer"/></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit"/></td>
                        </tr>
                    </form:form>
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
