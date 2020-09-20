<%--
  Created by: Denys Filatov
  Date: 20.09.2020
  Time: 14:20
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>s
<html>
<head>
    <title>Internet Store</title>
</head>
<body>
<header>
    <jsp:include page="fragment/header.jsp"/>
</header>
<div class="container-fluid">
    <div class="row">
        <aside class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
            <jsp:include page="fragment/aside.jsp"/>
        </aside>
        <main class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
            <jsp:include page="${currentPage}"/>
        </main>
    </div>
</div>
<footer class="footer">
    <jsp:include page="fragment/footer.jsp"/>
</footer>
</body>
</html>
