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
<body>
    <jsp:include page = "../layout/header.jsp"/>
    <jsp:include page = "../layout/sidebar.jsp"/>   
    
    <div class="content">
        <div class = "row">
                <div class="d-flex justify-content-between">
                    <h3>Thông tin khoá học</h3>
                    <a href="/create/course" class="btn btn-primary">Tạo khoá học </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã khoá học</th>
                        <th>Tên khoá học</th>
                        <th>Thời gian</th>
                        <th>Từ ngày</th>
                        <th>Đến ngày</th>
                        <th>Giá tiền</th>
                    </tr>
                    <c:forEach var="c" items="${courses}">
                        <tr>
                            <td>${c.course_id}</td>
                            <td>${c.name}</td>
                            <td>${c.duration} tháng</td>
                            <td>${c.start_date}</td>
                            <td>${c.end_date}</td>
                            <td>${c.price}</td>
                            <td>
                                <a href="/update/course/${c.course_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/course/${c.course_id}" 
                                onclick="return confirm('Bạn có chắc chắn muốn xóa tài khoản này không?')" 
                                class="btn btn-danger">Delete</a>                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
    </div>
</body>
</html>