
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
        <c:set var="project_name" value="Anansi"/>
    </c:otherwise>
</c:choose>

<!-- PAGE TITLE -->
<c:choose>
    <c:when test="${ req_page_title != null }">
        <c:set var="page_title" value="${ req_page_title }"/>
    </c:when>
    <c:otherwise>
        <c:set var="page_title" value="Anansi - Home"/>
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
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">

    <base href="http://localhost:8080/${ project_name }/"/>

    <title>${ page_title }</title>



    <!-- Bootstrap core CSS -->
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="static/css/freelancer.min.css" rel="stylesheet">

    <!-- Bootstrap core JavaScript -->
    <script src="static/vendor/jquery/jquery.min.js"></script>
    <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="static/js/jqBootstrapValidation.js"></script>
    <script src="static/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="static/js/freelancer.min.js"></script>

    <script src="static/Chart.min.js"></script>


</head>


<body>

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
