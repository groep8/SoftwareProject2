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
    <link href="{{ asset('assets/css/default.css) }}" rel='stylesheet'  type="text/css"/>
    yield('header_styles')
</head>
<body>
@yield('footer_scripts')

</body>
</html>