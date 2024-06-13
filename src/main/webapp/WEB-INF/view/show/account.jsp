<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
</head>
<body>
    <div class="container mt-5">
        <div class = "row">
            <div class=" col-12 mx-auto">
                <div class="d-flex justify-content-between">
                    <h3>Thông tin tài khoản</h3>
                    <a href="/create/account" class="btn btn-primary">Tạo tài khoản </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Tên đăng nhập</th>
                        <th>Mật khẩu</th>
                        <th>Loại tài khoản</th>
                    </tr>
                    <c:forEach var="acc" items="${accounts}">
                        <tr>
                            <td>${acc.user}</td>
                            <td>${acc.password}</td>
                            <td>${acc.accountType}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>