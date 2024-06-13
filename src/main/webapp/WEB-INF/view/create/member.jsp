<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- import bootstrap -->
    <!-- css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- js -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
    <%@ include file="../layout.jsp" %>


</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 col-12 mx-auto">
                <h3>Hội viên</h3>
                <hr/>
                <form:form method="post" action="/create/createMember" modelAttribute="newMember">
                    <div class="form-group">
                        <label for="name">Tên hội viên:</label>
                        <form:input type="text" path="name" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber">Số điện thoại:</label>
                        <form:input type="text" path="phoneNumber" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="date_joined">Ngày đăng ký:</label>
                        <form:input type="date" path="date_joined" class="form-control"/>
                    </div>
                   
                    <div class="form-group">
                        <label for="op">OptionGym:</label>
                        <form:select path="op" class="form-control">
                            <form:option value="" label="-- Chọn --"/>
                            <c:forEach items="${op}" var="option">
                                <form:option value="${option.op_id}" label="${option.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>
                    

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Tạo</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>