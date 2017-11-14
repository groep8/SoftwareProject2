<?php 
Route::group(array('prefix' => 'user' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    Route::get('index',['as' => 'index','uses' =>'MainController@home']);

});

Route::group(array('prefix' => 'user/training' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'training.index','uses' =>'TrainingController@index']);
    Route::get('index',['as' => 'training.index','uses' =>'TrainingController@index']);
    Route::post('request',['as' => 'training.request','uses' =>'TrainingController@request']);
});

