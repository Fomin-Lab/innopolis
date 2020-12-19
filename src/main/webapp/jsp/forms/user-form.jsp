<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="user" scope="request" class="ru.innopolis.university.fomin.part1.lesson25.model.UserModel"/>

<form action="${pageContext.request.contextPath}" method="post">
    <c:if test="${user.id > 0}">
        <div class="mb-3">
            <label for="input0" class="form-label">ID</label>
            <input name="id" type="text" class="form-control" id="input0" value="${user.id}" disabled="disabled">
        </div>
    </c:if>
    <div class="mb-3">
        <label for="input1" class="form-label">User login</label>
        <input name="login" type="text" class="form-control" id="input1" value="${user.login}">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">User name</label>
        <input name="name" type="text" class="form-control" id="input2" value="${user.name}">
    </div>
    <div class="mb-3">
        <label for="input3" class="form-label">Role Id</label>
        <input name="role_id" type="text" class="form-control" id="input3" value="${user.roleId}">
    </div>
    <div class="mb-3">
        <label for="input4" class="form-label">Rate</label>
        <input name="rate" type="text" class="form-control" id="input4" value="${user.rate}">
    </div>
    <button type="submit" class="btn btn-primary me-3">Submit</button>
    <a href="${pageContext.request.contextPath}/">Main page</a>
</form>