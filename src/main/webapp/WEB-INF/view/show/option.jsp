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
                    <h3>Thông tin gói tập</h3>
                    <a href="/create/option" class="btn btn-primary">Tạo gói tập </a>                 
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã gói tập</th>
                        <th>Tên gói tập</th>
                        <th>Thời hạn</th>
                        <th>Từ ngày</th>
                        <th>Đến ngày</th>
                        <th>Mức giá </th>
                    </tr>
                    <c:forEach var="op" items="${options}">
                        <tr>
                            <td>${op.op_id}</td>
                            <td>${op.name}</td>
                            <td>${op.duration}</td>
                            <td>${op.duration}</td>
                            <td>${op.start_time}</td>
                            <td>${op.end_time}</td>
                            <td>${op.price}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>