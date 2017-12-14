<!DOCTYPE html>
<html>
<head>
    <meta name="charset" content="UTF-8">
    <title>
    @section('title')
        | Software Project 2
    @show
    </title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <script src="https://unpkg.com/sweetalert2@7.0.6/dist/sweetalert2.all.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,600" rel="stylesheet" type="text/css">
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.5/sweetalert2.css" />
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
    
        <!-- Styles -->
        <style>
            html, body {
                background-color: #fff;
                color: #636b6f;
                font-family: 'Raleway', sans-serif;
                font-weight: 100;
                height: 100vh;
                margin: 0;
            }

            .full-height {
                height: 100vh;
            }

            .flex-center {
                align-items: center;
                display: flex;
                justify-content: center;
            }

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: 18px; 
            }

            .content {
                text-align: center;
            }

            .title {
                font-size: 84px;
            }

            .links > a {
                color: #636b6f;
                padding: 0 25px;
                font-size: 12px;
                font-weight: 600;
                letter-spacing: .1rem;
                text-decoration: none;
                text-transform: uppercase;
            }
            .logout{
                position: absolute;
                bottom: 3%;
                color: red;
                font-weight: 700;
                left: 50%;
                right: 50%;
            }
            
            .m-b-md {
                margin-bottom: 30px;
            }
            @import "https://fonts.googleapis.com/css?family=Montserrat:300,400,700";
                .rwd-table {
                margin: 1em 0;
                min-width: 300px;
                }
                .rwd-table tr {
                border-top: 1px solid #ddd;
                border-bottom: 1px solid #ddd;
                }
                .rwd-table th {
                display: none;
                }
                .rwd-table td {
                display: block;
                }
                .rwd-table td:first-child {
                padding-top: .5em;
                }
                .rwd-table td:last-child {
                padding-bottom: .5em;
                }
                .rwd-table td:before {
                content: attr(data-th) ": ";
                font-weight: bold;
                width: 6.5em;
                display: inline-block;
                }
                @media (min-width: 480px) {
                .rwd-table td:before {
                    display: none;
                }
                }
                .rwd-table th, .rwd-table td {
                text-align: left;
                }
                @media (min-width: 480px) {
                .rwd-table th, .rwd-table td {
                    display: table-cell;
                    padding: .25em .5em;
                }
                .rwd-table th:first-child, .rwd-table td:first-child {
                    padding-left: 0;
                }
                .rwd-table th:last-child, .rwd-table td:last-child {
                    padding-right: 0;
                }
                }



            .rwd-table {
            background: #34495E;
            color: #fff;
            border-radius: .4em;
            overflow: hidden;
            }
            .rwd-table tr {
            border-color: #46637f;
            }
            .rwd-table th, .rwd-table td {
            margin: .5em 1em;
            }
            @media (min-width: 480px) {
            .rwd-table th, .rwd-table td {
                padding: 1em !important;
            }
            }
            .rwd-table th, .rwd-table td:before {
            color: #dd5;
            }

        </style>
    @yield('header_styles')
</head>
<body>
@yield('content')
@yield('footer_scripts')
<a class="logout" href="{{ route('logout') }}" >Logout</a>
</body>
</html>