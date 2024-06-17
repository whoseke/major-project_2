<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sidebar</title>
    <style>
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 300px; 
            background-color: #333;
            padding-top: 20px;
            color: #fff;
        }

        .sidebar h2 {
            text-align: center;
        }

        .sidebar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            padding: 10px;
        }

        .sidebar ul li a {
            color: #fff;
            text-decoration: none;
        }

        .sidebar ul li a:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <aside class="sidebar">
        <a href="/">
           <h2>Trang chủ</h2>
        </a>

        <ul>
            <li><a href="/info/option">Gói tập</a></li>
            <li><a href="/info/course">Khoá học</a></li>
            <li><a href="/info/session">Buổi tập</a></li>
            
            <li><a href="/info/booking">Thông tin đặt chỗ</a></li>
            <li><a href="/info/member">Hội viên</a></li>
            <li><a href="/info/pt">Huấn luyện viên</a></li>

            <li><a href="/info/employee">Nhân viên</a></li>
            <li><a href="/info/shift">Lịch nhân viên</a></li>

            <li><a href="/info/payment">Thanh toán</a></li>

            <li><a href="/feedback">Phản hồi</a></li>
            <li><a href="/info/account">Tài khoản</a></li>
            
        </ul>

        <ul>
            
        </ul>
    </aside>
</body>
</html>
