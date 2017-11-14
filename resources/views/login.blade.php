<!doctype html>
<html lang="{{ app()->getLocale() }}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>login</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,600" rel="stylesheet" type="text/css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">

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

            .m-b-md {
                margin-bottom: 30px;
            }
            
.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0, 0, 0, 0.1);
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 30px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.help-block{
    color:red;
    font-weight: 800;

    
}

        </style>
    </head>
    <body>
        <div class="flex-center position-ref full-height">
           
     

            <div class="content">
                <div class="title m-b-md">
                    Login
                </div>
                <form class="form-signin {{$errors->first('username','has-error')}} " action="{{ route('signin') }}" autocomplete="on" method="post" role="form">       
                    <h2 class="form-signin-heading">Inloggen</h2>
                    
                    <input type="hidden" name="_token" value="{{ csrf_token()}}">
                    <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
                    <div class="col-sm-12">
                    
                    {!! $errors->first('username','<span class="help-block">:message</span>')!!}
                    </div>
                    <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
                    <div class="col-sm-12">
                    
                    {!! $errors->first('password','<span class="help-block">:message</span>')!!}
                    </div>
                    
                    <input  value="Login" class="btn btn-lg btn-primary btn-block" type="submit">   
                </form>
               
            </div>
        </div>
    </body>
</html>
