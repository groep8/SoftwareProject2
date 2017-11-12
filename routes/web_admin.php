<?php 
Route::group(array('prefix' => 'admin' , 'middleware' => 'admin','as'=>'admin.'), function(){
    Route::get('/',['as' => 'home.index','uses' =>'MainController@adminhome']);
    Route::get('index',['as' => 'home.index','uses' =>'MainController@adminhome']);

});

Route::group(array('prefix' => 'admin/training' , 'middleware' => 'admin','as'=>'admin.'), function(){
    Route::get('/',['as' => 'training.index','uses' =>'TrainingController@adminhome']);
    Route::get('index',['as' => 'training.index','uses' =>'TrainingController@adminhome']);
});