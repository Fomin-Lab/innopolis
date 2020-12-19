<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    public String createTitle(String arg) {
        String str = "Java EE: ";
        return str + arg;
    }
%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap-5.0/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/bootstrap-icons-1.2.1/font/bootstrap-icons.css"/>
    <script src="${pageContext.request.contextPath}/assets/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/bootstrap-5.0/js/bootstrap.min.js"></script>
    <title><%= createTitle((String) request.getAttribute("PageTitle"))%>
    </title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Java EE APP: ${PageTitle}</a>
    </div>
</nav>
<br/>
<div class="container">
    <c:import url="${PageBody}"/>
</div>
</body>
</html>