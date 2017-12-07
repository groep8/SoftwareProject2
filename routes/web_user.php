<?php 
Route::group(array('prefix' => 'user' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    
    Route::get('getrequests',['as' => 'getrequests','uses' =>'TrainingController@getrequests']);
    Route::patch('postrequest',['as' => 'postrequest','uses' =>'TrainingController@postRequests']);
    

});

