<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            body {
                background-image: url('/image/background.jpg');
                background-size: cover;
            }

            h1 {
                font-family: Monotype Corsiva, sans-serif;
                font-size: 170px;
                font-weight: bold;
                color: rgb(25, 8, 63);
                position: absolute;
                top: 30%;
                left: 19%;
            }
        </style>

    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <div class="navbar-collapse justify-content-end">
                    <ul class="navbar-nav">
                        <li class="nav-item ">
                            <button class="btn btn-outline-primary btn-lg mx-2" onclick="location.href='/create/member'">
                                Đăng nhập
                            </button>
                        </li>
                        <li class="nav-item">
                            <button class="btn btn-outline-warning btn-lg mx-2" onclick="location.href='/create/employee'">
                                Đăng ký
                            </button>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>
        <a class="navbar-brand" href="#">
            <h1>gym-Z</h1>
        </a>
    </body>

    </html>