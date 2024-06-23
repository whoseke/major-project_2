<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Bar and Sidebar</title>
    <style>
        .sidebar {
            margin-top: 7px; 
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 270px; 
            background-color: #333;
            padding-top: 30px;
            color: #fff;
            overflow-y: auto;
        }

        .sidebar h2 {
            text-align: center;
            color: #fff;
        }

        .sidebar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            padding: 15px;
        }

        .sidebar ul li a {
            color: #fff;
            text-decoration: none;
        }

        .sidebar ul li a:hover {
            background-color: blue;
        }

    </style>
</head>
<body>
    <aside class="sidebar">
        <ul>
            <li><a href="/info/option">Gói tập</a></li>
            <li><a href="/info/course">Khoá học</a></li>
            <li><a href="/info/session">Buổi tập</a></li>
            
            <li><a href="/info/booking">Đặt lịch</a></li>
            <li><a href="/info/member">Hội viên</a></li>
            <li><a href="/info/pt">Huấn luyện viên</a></li>

            <li><a href="/info/employee">Nhân viên</a></li>
            <li><a href="/info/shift">Lịch nhân viên</a></li>

            <li><a href="/info/payment">Thanh toán</a></li>

            <li><a href="/feedback">Phản hồi</a></li>
            <li><a href="/info/account">Tài khoản</a></li>            
        </ul>
    </aside>

</body>
</html>
