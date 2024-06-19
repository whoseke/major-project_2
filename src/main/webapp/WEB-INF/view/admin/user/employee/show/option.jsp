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
                    <h3>Thông tin gói tập</h3>
                    <a href="/create/option" class="btn btn-primary">Tạo gói tập </a>                 
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã gói tập</th>
                        <th>Tên gói tập</th>
                        <th>Thời hạn</th>
                        <th>Mức giá </th>
                    </tr>
                    <c:forEach var="op" items="${options}">
                        <tr>
                            <td>${op.op_id}</td>
                            <td>${op.name}</td>
                            <td>${op.duration}</td>
                            <td>${op.duration}</td>
                            <td>${op.price}</td>
                            <td><a href="/update/option/${op.op_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/member/${op.op_id}" 
                                onclick="return confirm('Bạn có chắc chắn muốn xóa tài khoản này không?')" 
                                class="btn btn-danger">Delete</a>                        
                            </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <%@ include file="../../../../layout.jsp" %>

</body>
</html>