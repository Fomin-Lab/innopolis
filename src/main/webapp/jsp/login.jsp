<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Войти</h2>
<form action="${pageContext.request.contextPath}" method="post">
    <div class="mb-3">
        <label for="input1" class="form-label">Login</label>
        <input name="login" type="text" class="form-control" id="input1">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="input2">
    </div>
    <button type="submit" class="btn btn-primary me-3">Log In</button>
</form>