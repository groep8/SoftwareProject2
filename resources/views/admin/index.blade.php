@extends ('admin./layouts/default')
@section('title')
Laravel
@parent
@stop

{{-- Page Content --}}
@section('content')
        <div class="flex-center position-ref "> 
            <div class="content">
                <div class="title m-b-md">
                    Admin Home
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                
                <div class="col-sm-6 text-center">
                <h1>Nog te bevestigen</h1>
                <div id="tebevestigen"></div>
                </div>
                
                <div class="col-sm-6 text-center">
                <h1>Al Bevestigd</h1>
                <div id="albevestigen"></div>
                </div>
            </div>
        </div>
@stop

@section('footer_scripts')
<script>
$(document).ready(function(){

   

});


</script>












@stop