<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 19/05/2020
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Applications</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<jsp:include page="../templates/Header.jsp">
    <jsp:param name="year" value="2010"/>
</jsp:include>

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
            <h3>Nos applications chez Covida</h3>
            <table class="table">
                <tr>
                    <td><img src="../images/app2.jpg" alt="B" width="140px"/></td>
                    <td>Ib</td>
                </tr>
                <tr>
                    <td><img src="../images/app3.jpg" alt="B" width="140px"/></td>
                    <td>Yume nikki</td>
                </tr>
                <tr>
                    <td><img src="../images/app1.jpg" alt="B" width="140px"/></td>
                    <td>Pokémon Réjuvenation</td>
                </tr>
                <tr>
                    <td><img src="../images/app4.jpg" alt="B" width="140px"/></td>
                    <td>MadFather</td>
                </tr>
                <tr>
                    <td><img src="../images/app5.jpg" alt="B" height="140px"/></td>
                    <td>The witch's house</td>
                </tr>
            </table>
        </td>
        <td colspan=3 class="column logger" >
            <jsp:include page="../templates/Logger.jsp"/>
        </td>
    </tr>
    <tr></tr>
</table>
<jsp:include page="../templates/Footer.jsp"/>
</body>
</html>
