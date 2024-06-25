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
    <jsp:include page = "../../header.jsp"/>
    <jsp:include page = "../sidebar.jsp"/> 
    
    <div class="content">
        <div class = "row">
                <div class="d-flex justify-content-between">
                    <h3>Thông tin buổi tập</h3>
                </div>
                <hr>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Mã buổi tập</th>
                        <th>Buổi tập</th>
                        <th>Mã khoá học</th>
                        <th>Mã PT</th>
                        <th>Từ</th>
                        <th>Đến</th>
                    </tr>
                    <c:forEach var="s" items="${sessions}">
                        <tr>
                            <td>${s.session_id}</td>
                            <td>${s.session_Date}</td>
                            <td>${s.course.course_id}</td>
                            <td>${s.pt.pt_id}</td>
                            <td>${s.start_time}</td>
                            <td>${s.end_time}</td>
                        
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </div>
</body>
</html>