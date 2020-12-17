<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Users list</h2>

<ul>
    <c:forEach items="${users}" var="user">
        <li><a href='show-user?id=${user.id}'>${user.name}</a></li>
    </c:forEach>
</ul>

</body>
</html>