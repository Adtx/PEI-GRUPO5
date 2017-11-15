
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- APPLICATION CONFIGS - TO USE IN EVERY JSP -->
<c:choose>
    <c:when test="${ req_project_name != null }">
        <c:set var="project_name" value="${ req_project_name }"/>
    </c:when>
    <c:otherwise>
        <c:set var="project_name" value="Escrita"/>
    </c:otherwise>
</c:choose>

<!-- PAGE TITLE -->
<c:choose>
    <c:when test="${ req_page_title != null }">
        <c:set var="page_title" value="Escrita - ${ req_page_title }"/>
    </c:when>
    <c:otherwise>
        <c:set var="page_title" value="Escrita - Home"/>
    </c:otherwise>
</c:choose>

<!-- PAGE TEMPLATES -->
<c:choose>
    <c:when test="${ req_page_jsp_files != null }">
        <c:set var="page_jsp_files" value="${ req_page_jsp_files }"/>
    </c:when>
    <c:otherwise>
        <%
            List default_jsp_files = new ArrayList();
            default_jsp_files.add("util/homepage.jsp");
            request.setAttribute("default_jsp_files", default_jsp_files );
        %>
        <c:set var="page_jsp_files" value="${ default_jsp_files }"/>
    </c:otherwise>
</c:choose>

<!-- LOCALE -->
<c:choose>
    <c:when test="${ sessionScope.get(\"lang\") == null }">
        <fmt:setLocale value="pt-PT" scope="session"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="${ sessionScope.get(\"lang\") }" scope="session"/>
    </c:otherwise>
</c:choose>

<!-- PAGE OUTPUT -->
<html lang="pt-PT">
<head>
    <meta charset="utf-8">

    <base href="http://localhost:8080/${ project_name }/"/>

    <title>${ page_title }</title>

    <script src="static/js/tether.min.js"></script>
    <script src="static/js/jquery-3.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>

    <script src="static/js/jquery-ui.min.js"></script>
    <script src="static/js/moment.js"></script>

    <script src="static/js/ripples.js"></script>
    <script src="static/js/material.min.js"></script>
    <!--script src="static/js/jquery.dropdown.js"></script-->

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/css/tether.min.css">

    <!-- Bootstrap Material Design -->
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-material-design.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/ripples.min.css">




    <!--link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/ui-lightness/jquery-ui.css" type="text/css" media="all" /-->
    <link rel="stylesheet" type="text/css" href="static/css/timepicker.css"/>
</head>
<body>
<h1>OYOYOYOYOYOYOY</h1>
<div>
    <!--jsp:include page="header/header.jsp"/-->
    <c:forEach var="jsp_file" items="${ page_jsp_files }">
        <jsp:include page="${ jsp_file }"/>
    </c:forEach>
    <!--jsp:include page="footer/footer.jsp"/-->
</div>

<!--jsp:include page="user/login.jsp"/-->
</body>
</html>

<c:if test="${ login_modal == \"yes\" }">
    <script>
        $('#login-modal').modal('show');
    </script>
</c:if>