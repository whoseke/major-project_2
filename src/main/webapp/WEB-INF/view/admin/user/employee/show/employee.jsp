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
            <div class="col-md-8 offset-md-3"> 
                <div class="d-flex justify-content-between">
                    <h3>Thông tin nhân viên</h3>
                    <a href="/create/employee" class="btn btn-primary">Thêm nhân viên </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã nhân viên:</th>
                        <th>Họ và tên:</th>
                        <th>Vị trí:</th>
                        <th>Mức lương:</th>
                    </tr>
                    <c:forEach var="e" items="${employees}">
                        <tr>
                            <td>${e.employee_id}</td>
                            <td>${e.name}</td>
                            <td>${e.position}</td>
                            <td>${e.salary}</td>
                            <td>
                                <a href="/update/employee/${e.employee_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/employee/${e.employee_id}" 
                                onclick="return confirm('Bạn có chắc chắn muốn xóa tài khoản này không?')" 
                                class="btn btn-danger">Delete</a>                               </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <%@ include file="../../../../layout.jsp" %>

</body>
</html>