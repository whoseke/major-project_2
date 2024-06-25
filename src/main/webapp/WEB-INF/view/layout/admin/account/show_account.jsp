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
                    <a href="/admin/create/account" class="btn btn-primary">Tạo tài khoản</a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Tên đăng nhập</th>
                        <th>Mật khẩu</th>
                        <th>Loại tài khoản</th>
                    </tr>
                    <c:forEach var="acc" items="${accounts}">
                        <tr>
                            <td>${acc.account_id}</td>
                            <td>${acc.user}</td>
                            <td>${acc.password}</td>
                            <td>${acc.role.name}</td>
                            <td>
                                <a href="/admin/update/account/${acc.account_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/admin/delete/account/${acc.account_id}" 
                                onclick="return confirm('Bạn có chắc chắn muốn xóa tài khoản này không?')" 
                                class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </div>
</body>
</html>
