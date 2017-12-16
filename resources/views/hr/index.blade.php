@extends ('hr./layouts/default')
@section('title')
Laravel
@parent
@stop

{{-- Page Content --}}
@section('content')
        <div class="flex-center position-ref "> 
            <div class="content">
                <div class="title m-b-md">
                    HR Home
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
            <ul class="collection with-header">
    <li class="collection-header">
        <h2 class="flow-text">Recent Surveys
            <span style="float:right;">
            </span>
        </h2>
    </li>
    
</ul> 
                
            </div>
        </div>
@stop

@section('footer_scripts')














@stop