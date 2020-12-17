<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="users" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="articles" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="roles" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="statistic" scope="request" class="ru.innopolis.university.fomin.part1.lesson25.statistic.ModelStatistic" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Review page</a>
    </div>
</nav>
<br/>
<div class="row">
    <div class="col-9">
        <div class="row">
            <div class="col">
                <h3>Users</h3>
                <table class="table">
                    <thead>
                        <tr class="table-primary">
                            <th scope="col">#</th>
                            <th scope="col">Login</th>
                            <th scope="col">Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <th scope="row">${user.id}</th>
                                <td>${user.login}</td>
                                <td>${user.name}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <h3>Articles</h3>
                <table class="table">
                    <thead>
                    <tr class="table-warning">
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Likes</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <th scope="row">${article.id}</th>
                            <td>${article.title}</td>
                            <td>${article.likes}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h3>Roles</h3>
                <table class="table">
                    <thead>
                        <tr class="table-success">
                            <th scope="col">#</th>
                            <th scope="col">Title</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${roles}" var="role">
                            <tr>
                                <th scope="row">${role.id}</th>
                                <td>${role.title}</td>
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
                    <li>Min size article: <strong>${statistic.minSizeOfArticle}</strong></li>
                    <li>Max size article: <strong>${statistic.maxSizeOfArticle}</strong></li>
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