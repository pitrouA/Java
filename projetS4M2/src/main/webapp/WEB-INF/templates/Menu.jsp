<%--
  Created by IntelliJ IDEA.
  User: pitrou
  Date: 22/05/2020
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>Liens</div>
    <div><a href="/"><button>Page d'accueil</button></a></div>
    <div><a href="/applications"><button>Nos Applications</button></a></div>
    <div><a href="/history"><button>Historique de l'entreprise</button></a></div>
    <c:if test="${sessionScope.user.isAdmin()}">
        <hr>
        <div>Administration</div>
        <hr>
        <div><a href="manageUser"><button>Utilisateurs</button></a></div>
        <div><a href="manageManager"><button>Gestionnaire</button></a></div>
        <div><a href="manageApplication"><button>Applications</button></a></div>
    </c:if>
    <c:if test="${sessionScope.user.isManager()}">
        <hr>
        <div>Management</div>
        <hr>
        <div><a href="manageAgent"><button>Agents</button></a></div>
    </c:if>
    <c:if test="${sessionScope.user.isManager() or sessionScope.user.isAgent()}">
        <hr>
        <div>Resolutions</div>
        <hr>
        <div><a href="manageResolution"><button>Resolutions</button></a></div>
    </c:if>
    <c:if test="${sessionScope.user.isAgent() or sessionScope.user.isCustomer()}">
        <hr>
        <div>Tickets</div>
        <hr>
        <div><a href="manageTicket"><button>Ticket</button></a></div>
    </c:if>
</body>
</html>
