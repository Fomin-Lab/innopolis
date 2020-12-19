<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="mobile" scope="request" class="ru.innopolis.university.fomin.part1.lesson25.model.MobileModel"/>

<form action="${pageContext.request.contextPath}" method="post">
    <c:if test="${mobile.id > 0}">
        <div class="mb-3">
            <label for="input0" class="form-label">ID</label>
            <input name="id" type="text" class="form-control" id="input0" value="${mobile.id}" disabled="disabled">
        </div>
    </c:if>
    <div class="mb-3">
        <label for="input1" class="form-label">Mobile OS</label>
        <input name="type_of_os" type="text" class="form-control" id="input1" value="${mobile.typeOS}">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Mobile model</label>
        <input name="model" type="text" class="form-control" id="input2" value="${mobile.model}">
    </div>
    <button type="submit" class="btn btn-primary me-3">Submit</button>
    <a href="${pageContext.request.contextPath}/">Main page</a>
</form>