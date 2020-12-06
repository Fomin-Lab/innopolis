<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<a href='all-users'> <- Go back to mobiles list</a>
<h2>${user.name}</h2>
<h3>params</h3>
<ul>
    <li>Login - ${user.login}</li>
    <li>Role Id - ${user.roleId}</li>
    <li>Rate - ${user.rate}</li>
</ul>
</body>
</html>