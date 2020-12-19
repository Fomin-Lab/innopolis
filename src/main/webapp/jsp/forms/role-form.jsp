<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="role" scope="request" class="ru.innopolis.university.fomin.part1.lesson25.model.RoleModel"/>

<form action="${pageContext.request.contextPath}" method="post">
    <c:if test="${role.id > 0}">
        <div class="mb-3">
            <label for="input0" class="form-label">ID</label>
            <input name="id" type="text" class="form-control" id="input0" value="${role.id}" disabled="disabled">
        </div>
    </c:if>
    <div class="mb-3">
        <label for="input1" class="form-label">Title</label>
        <input name="title" type="text" class="form-control" id="input1" value="${role.title}">
    </div>
    <button type="submit" class="btn btn-primary me-3">Submit</button>
    <a href="${pageContext.request.contextPath}/">Main page</a>
</form>