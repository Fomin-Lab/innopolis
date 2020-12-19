<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="users" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="articles" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="roles" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="mobiles" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="statistic" scope="request"
             class="ru.innopolis.university.fomin.part1.lesson25.statistic.ModelStatistic"/>

<div class="row">
    <div class="col-9">
        <div class="row">
            <div class="col">
                <h3>Users <a href="${pageContext.request.contextPath}/user-create"><i
                        class="bi-pencil-fill pencil-in-title text-primary"></i></a></h3>
                <table class="table">
                    <thead>
                    <tr class="table-primary">
                        <th scope="col">#</th>
                        <th scope="col">Login</th>
                        <th scope="col">Name</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <th scope="row">${user.id}</th>
                            <td>${user.login}</td>
                            <td>${user.name}</td>
                            <td class="text-end">
                                <a href="${pageContext.request.contextPath}/user-edit?id=${user.id}"><i
                                        class="bi-list"></i></a>
                                &nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/user-delete?id=${user.id}"><i
                                        class="bi-trash text-danger"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3>Articles <a href="${pageContext.request.contextPath}/article-create"><i
                        class="bi-pencil-fill pencil-in-title text-warning"></i></a></h3>
                <table class="table">
                    <thead>
                    <tr class="table-warning">
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Likes</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <th scope="row">${article.id}</th>
                            <td>${article.title}</td>
                            <td>${article.likes}</td>
                            <td class="text-end">
                                <a href="${pageContext.request.contextPath}/article-edit?id=${article.id}"><i
                                        class="bi-list"></i></a>
                                &nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/article-delete?id=${article.id}"><i
                                        class="bi-trash text-danger"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h3>Roles <a href="${pageContext.request.contextPath}/role-create"><i
                        class="bi-pencil-fill pencil-in-title text-success"></i></a></h3>
                <table class="table">
                    <thead>
                    <tr class="table-success">
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${roles}" var="role">
                        <tr>
                            <th scope="row">${role.id}</th>
                            <td>${role.title}</td>
                            <td class="text-end">
                                <a href="${pageContext.request.contextPath}/role-edit?id=${role.id}"><i
                                        class="bi-list"></i></a>
                                &nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/role-delete?id=${role.id}"><i
                                        class="bi-trash text-danger"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3>Mobiles <a href="${pageContext.request.contextPath}/mobile-create"><i
                        class="bi-pencil-fill pencil-in-title text-danger"></i></a></h3>
                <table class="table">
                    <thead>
                    <tr class="table-danger">
                        <th scope="col">#</th>
                        <th scope="col">OS</th>
                        <th scope="col">Model</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${mobiles}" var="mobile">
                        <tr>
                            <th scope="row">${mobile.id}</th>
                            <td>${mobile.typeOS}</td>
                            <td>${mobile.model}</td>
                            <td class="text-end">
                                <a href="${pageContext.request.contextPath}/mobile-edit?id=${mobile.id}"><i
                                        class="bi-list"></i></a>
                                &nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/mobile-delete?id=${mobile.id}"><i
                                        class="bi-trash text-danger"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-3">
        <div class="card">
            <div class="card-body">
                <h2>Statistic</h2>
                <ul class="list-unstyled">
                    <li>Total count: <strong>${statistic.totalCount}</strong></li>
                    <li>Number of users: <strong>${statistic.countUsers}</strong></li>
                    <li>Number of articles: <strong>${statistic.countArticles}</strong></li>
                    <li>Number of roles: <strong>${statistic.countRoles}</strong></li>
                    <li>Number of mobiles: <strong>${statistic.countMobiles}</strong></li>
                    <li>Min size article: <strong>${statistic.minSizeOfArticle}</strong></li>
                    <li>Max size article: <strong>${statistic.maxSizeOfArticle}</strong></li>
                    <li>Number of Androids: <strong>${statistic.countAndroidPhones}</strong></li>
                    <li>Number of Apples: <strong>${statistic.countApplePhones}</strong></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--ul>
<c:forEach items="${users}" var="user">
    <li><a href='show-user?id=${user.id}'>${user.name}</a></li>
</c:forEach>
</ul-->