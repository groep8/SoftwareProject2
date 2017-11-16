@extends ('user./layouts/default')
@section('title')
Laravel
@parent
@stop

{{-- Page Content --}}
@section('content')
        <div class="flex-center position-ref "> 
            <div class="content">
                <div class="title m-b-md">
                    User Home
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                
                <div class="col-sm-6 text-center">
                <h1>Test</h1>
                <div id="tebevestigen"></div>
                </div>
                
                <div class="col-sm-6 text-center">
                <h1>Test</h1>
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