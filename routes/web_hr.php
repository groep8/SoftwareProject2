<?php 
Route::group(array('prefix' => 'hr' , 'middleware' => 'hr','as'=>'hr.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    
});

