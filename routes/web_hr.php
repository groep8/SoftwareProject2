<?php 
Route::group(array('prefix' => 'hr' , 'middleware' => 'hr','as'=>'hr.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    Route::get('survey',['as' => 'survey' , 'uses' => 'SurveyController@home']);
});

