<?php 
Route::group(array('prefix' => 'admin' , 'middleware' => 'admin','as'=>'admin.'), function(){
    Route::get('/',['as' => 'admin.index','uses' =>'MainController@home']);
    Route::get('index',['as' => 'admin.index','uses' =>'MainController@home']);
    Route::get('pending',['as' => 'admin.pending','uses' =>'TrainingController@getPending']);
    Route::post('confirm',['as' => 'admin.confirm','uses' =>'TrainingController@postTraining']);
});


Route::group(array('prefix' => 'admin' ), function(){
    
    Route::get('signin',['as' => 'signin','uses' =>'AuthController@getSignin']);
    Route::post('signin',['as' => 'signin','uses' =>'AuthController@postSignin']);
    Route::get('logout',['as' => 'logout' , 'uses' => 'AuthController@getLogout']);
    
});