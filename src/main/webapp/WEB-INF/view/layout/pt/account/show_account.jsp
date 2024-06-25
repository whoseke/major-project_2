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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body >
    <jsp:include page = "../../header.jsp"/>
    <jsp:include page = "../sidebar.jsp"/> 
    
    <div class="content">
        <div class="row">
                <div class="d-flex justify-content-between">
                    <h3>Thông tin tài khoản</h3>
                    <a href="/pt/create/account" class="btn btn-primary">Tạo tài khoản</a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Tên đăng nhập</th>
                        <th>Mật khẩu</th>
                        <th>Loại tài khoản</th>
                    </tr>
                        <tr>
                            <td>${accounts.account_id}</td>
                            <td>${accounts.user}</td>
                            <td>${accounts.password}</td>
                            <td>${accounts.role.name}</td>
                            <td>
                                <a href="/pt/update/account/${acc.account_id}" 
                                class="btn btn-warning mx-2">Update</a>
                            </td>
                        </tr>
                </table>
            </div>
    </div>
</body>
</html>
