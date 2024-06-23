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
    <jsp:include page = "../layout/header.jsp"/>
    <jsp:include page = "../layout/sidebar.jsp"/>   
    
    <div class="container mt-5">
        <div class = "row">
            <div class="col-md-8 offset-md-3"> 
                <div class="d-flex justify-content-between">
                    <h3>Lịch nhân viên</h3>
                    <a href="/create/shift" class="btn btn-primary">Tạo lịch làm </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Tên nhân viên</th>
                        <th>Ngày </th>
                        <th>Giờ vào ca</th>
                        <th>Giờ ra ca</th>

                    </tr>
                    <c:forEach var="shift" items="${shifts}">
                        <tr>
                            <td>${shift.employee.name}</td>
                            <td>${shift.shift_date}</td>
                            <td>${shift.start_time}</td>
                            <td>${shift.end_time}</td>
                            <td>
                                <a href="/update/shift/${shift.shift_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/shift/${shift.shift_id}" 
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