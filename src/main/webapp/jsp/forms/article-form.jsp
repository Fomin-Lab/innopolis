<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="article" scope="request" class="ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel"/>

<form action="${pageContext.request.contextPath}" method="post">
    <c:if test="${article.id > 0}">
        <div class="mb-3">
            <label for="input0" class="form-label">ID</label>
            <input name="id" type="text" class="form-control" id="input0" value="${article.id}" disabled="disabled">
        </div>
    </c:if>
    <div class="mb-3">
        <label for="input1" class="form-label">Title article</label>
        <input name="title" type="text" class="form-control" id="input1" value="${article.title}">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Content article</label>
        <input name="content" type="text" class="form-control" id="input2" value="${article.content}">
    </div>
    <div class="mb-3">
        <label for="input3" class="form-label">Author Id</label>
        <input name="author_id" type="text" class="form-control" id="input3" value="${article.authorId}">
    </div>
    <div class="mb-3">
        <label for="input4" class="form-label">Likes</label>
        <input name="likes" type="text" class="form-control" id="input4" value="${article.likes}">
    </div>
    <button type="submit" class="btn btn-primary me-3">Submit</button>
    <a href="${pageContext.request.contextPath}/">Main page</a>
</form>