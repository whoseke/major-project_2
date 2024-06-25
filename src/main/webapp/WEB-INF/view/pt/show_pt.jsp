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
                    <h3>Thông tin PT</h3>
                    <a href="/create/pt" class="btn btn-primary">Thêm PT </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã PT:</th>
                        <th>Họ và tên</th>
                        <th>SDT</th>
                        <th>Chuyên môn</th>
                        <th>Kinh nghiệm</th>
                        <th>Ngày đăng ký</th>
                    </tr>
                    <c:forEach var="pts" items="${pts}">
                        <tr>
                            <td>${pts.pt_id}</td>
                            <td>${pts.name}</td>
                            <td>${pts.phoneNumber}</td>
                            <td>${pts.specialization}</td>
                            <td>${pts.experience_year}</td>
                            <td>${pts.date_joined}</td>
                            <td>
                                <a href="/update/pt/${pts.pt_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/pt/${pts.pt_id}" 
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