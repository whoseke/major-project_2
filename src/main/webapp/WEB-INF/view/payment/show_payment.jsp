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
                    <h3>Thông tin hoá đơn</h3>
                    <a href="/create/payment" class="btn btn-primary">Tạo hoá đơn </a>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã hoá đơn</th>
                        <th>Tên khách hàng</th>
                        <th>Tên gói tập</th>
                        <th>Ngày lập hoá đơn</th>
                        <th>Giá gói tập</th>
                        <th>Giá khoá học</th>

                    </tr>
                    <c:forEach var="p" items="${payments}">
                        <tr>
                            <td>${p.payment_id}</td>
                            <td>${p.member.name}</td>
                            <td>${p.op.name}</td>
                            <td>${p.paymentDate}</td>
                            <td>${p.op.price}</td>
                            <td>
                                <c:forEach var="booking" items="${p.member.booking}">
                                    ${booking.session.course.price} 
                                </c:forEach>
                            </td>
                            <td>
                                <a href="/update/payment/${p.payment_id}" 
                                class="btn btn-warning mx-2">Update</a>
                                <a href="/delete/payment/${p.payment_id}" 
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