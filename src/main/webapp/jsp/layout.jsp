<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    public String createTitle(String arg) {
        String str = "PageTitle: ";
        return str + arg;
    }
%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap-5.0/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/assets/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/bootstrap-5.0/js/bootstrap.min.js"></script>
    <title><%= createTitle((String) request.getAttribute("PageTitle"))%></title>
</head>
<body>
<div class="container">
    <c:import url="${PageBody}"/>
</div>
</body>
</html>