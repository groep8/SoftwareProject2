<?php 
Route::group(array('prefix' => 'user' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'home.index','uses' =>'MainController@showHome']);
    Route::get('index',['as' => 'home.index','uses' =>'MainController@showHome']);

});

Route::group(array('prefix' => 'user/training' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'training.index','uses' =>'TrainingController@index']);
    Route::get('index',['as' => 'training.index','uses' =>'TrainingController@index']);
    Route::post('request',['as' => 'training.request','uses' =>'TrainingController@request']);
});