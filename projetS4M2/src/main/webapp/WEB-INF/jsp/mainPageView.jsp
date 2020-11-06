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
    <title>Page principale</title>
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
            <p>Bienvenue chez Covida SARL !</p>

            <table>
                <tr>
                    <td><img src="../images/img1.jpg" alt="B"/></td>
                    <td>Covida, c'est plus de 19 consultants à votre écoute pour accompagner efficacement vos projets vidéoludiques.
                        Expert du gameplay MALADIF, Covida saura entretenir les joueurs en manque d' EXERCICE</td>
                </tr>
                <tr>
                    <td>Retrouvez Covida sur tout les forums de jeu. Partout dans le MONDE, Covida s'impose comme une nécessité de rester CONFINE sur son choix.
                        Venez participer à une de nos REUNIONS VIRTUELLES autour de jeux comme URGENCES, horreur à l'HOPITAL et bien d'autres !
                    </td>
                    <td><img src="../images/img2.jpg" alt="B"/></td>
                </tr>
                <tr>
                    <td><img src="../images/img3.jpg" alt="B" width="300px"/></td>
                    <td>Covida saura gérer tout vos problèmes de MAINTENANCE grâce à son incroyable équipe de GESTIONNAIRES de projet.
                        Avec son équipe d' AGENTS que Covida SARL monopolise en TELETRAVAIL, Covida s'impose également comme un précurseur du travail mal fait.</td>
                </tr>
                <tr>
                    <td>Covida, c'est votre partenaire de projet quand plus personne ne PEUX vous suivre à cause de la CRISE.
                        Vous aussi, venez essayer la solution Covida !</td>
                    <td><img src="../images/img4.jpg" alt="B"/></td>
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
