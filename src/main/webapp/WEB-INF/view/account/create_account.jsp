<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- import bootstrap -->
    <!-- css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- js -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <jsp:include page = "../layout/header.jsp"/>
    <jsp:include page = "../layout/sidebar.jsp"/> 
    <div class="content">
        <div class="row">
            <div class="col-md-6 col-12 mx-auto">
                <h3> Tạo tài khoản người dùng</h3>
                <hr/>
                <c:if test="${not empty successMessage}">
                    <div class="alert alert-success" role="alert">
                        ${successMessage}
                    </div>
                    <script>
                        function toHomePage() {
                            window.location.href = "/homePage";
                        }
                    </script>
                </c:if>
                <form:form method="post" action="/create/createAccount" modelAttribute="newAccount">
                    <div class="form-group">
                        <label for="user">Người dùng:</label>
                        <form:input path="user" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="password">Mật khẩu:</label>
                        <form:input type ="password" path="password" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="session">Loại tài khoản:</label>
                        <form:select path="role" class="form-control">
                            <form:option value="" label="-- Chọn --"/>
                            <c:forEach items="${role}" var="role">
                                <form:option value="${role.role_id}" label="${role.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" onlick="toHomePage">Tạo</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
