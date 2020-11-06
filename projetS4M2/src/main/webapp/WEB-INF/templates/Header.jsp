<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 20/05/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <!--<link rel="stylesheet" href="style.css" type="text/css"/>-->
</head>
<body>
    <header class="ribbon">
        <table width="100%">
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
                <!--<td colspan=18 width="100%"><img width="100%" height="100%" src="../images/back1.jpg" alt="ruban"/></td>-->
                <td colspan=18 class="title">Covida</td>
                <c:if test="${user != null}">
                    <td colspan=2 width="100%"><a href="/disconnect"><img src="../images/signOut.png" width="150px" alt="C"/></a></td>
                </c:if>
                <c:if test="${user == null}">
                    <td colspan=2 width="100%"><a href="/login"><img src="../images/signIn.png" width="150px" alt="B"/></a></td>
                </c:if>
            </tr>
            <tr>
                <td colspan=20 width="100%" class="sous-titre">
                    L'expert de la maintenance applicative et du jeu vidéo
                </td>
            </tr>
        </table>
    </header>
</body>
</html>
