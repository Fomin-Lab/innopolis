<%@tag description="Main layout" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@attribute name="header" fragment="true" required="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap-5.0/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/assets/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/bootstrap-5.0/js/bootstrap.min.js"></script></head>
<body>
<div class="container">
    <jsp:invoke fragment="header"/>
    <jsp:doBody/>
</div>
</body>
</html>