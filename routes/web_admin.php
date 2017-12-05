<?php 
Route::group(array('prefix' => 'admin' , 'middleware' => 'admin','as'=>'admin.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    Route::get('index',['as' => 'index','uses' =>'MainController@home']);
    Route::get('pending',['as' => 'pending','uses' =>'TrainingController@getPending']);
    Route::post('confirm',['as' => 'confirm','uses' =>'TrainingController@postTraining']);
    Route::post('undo',['as' => 'undo','uses' =>'TrainingController@postUndo']);
    Route::get('confirmed',['as' => 'confirmed','uses' =>'TrainingController@getConfirmed']);
    
});

