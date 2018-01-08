<?php 
Route::group(array('prefix' => 'user' , 'middleware' => 'user','as'=>'user.'), function(){
    Route::get('/',['as' => 'index','uses' =>'MainController@home']);
    Route::get('getrequests',['as' => 'getrequests','uses' =>'TrainingController@getrequests']);
    Route::patch('postrequest',['as' => 'postrequest','uses' =>'TrainingController@postRequests']);
    Route::get('/survey/view/{survey}',['as' => 'view.survey' , 'uses' => 'SurveyController@view_survey']);
    Route::post('/survey/view/{survey}/completed',['as' => 'complete.survey' , 'uses' => 'AnswerController@store']);
    Route::get('/survey/answers/{survey}',['as' => 'view.survey.answers' , 'uses' => 'SurveyController@view_survey_answers']);
    

});

