<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Bar and Sidebar</title>
    <style>
     
        .menu-bar {
            background-color: #333; 
            color: #fff;
            overflow: hidden;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
        }

        .menu-bar a {
            float: left;
            display: block;
            color: #fff;
            text-align: center;
            padding: 7px 16px;
            text-decoration: none;
        }

        .menu-bar a:hover {
            background-color: blue;
        }

    </style>
</head>
<body>
    <div class="menu-bar">
        <a href="#">Admin</a>
        <a href="#">Nhân viên</a>
        <a href="#">Hội viên</a>
        <a href="#">Huấn luyện viên</a>
    </div>
</body>
</html>
