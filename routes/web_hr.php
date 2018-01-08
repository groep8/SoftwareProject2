<?php 
Route::group(array('prefix' => 'hr' , 'middleware' => 'hr','as'=>'hr.'), function(){
    Route::get('/',['as' => 'index' , 'uses' => 'SurveyController@home']);
    Route::get('/',['as' => 'survey' , 'uses' => 'SurveyController@home']);
    Route::get('/survey/view/{survey}',['as' => 'view' , 'uses' => 'SurveyController@view_survey']);
    Route::get('/survey/new',['as' => 'new.survey' , 'uses' => 'SurveyController@new_survey']);
    Route::get('/survey/{survey}',['as' => 'detail.survey' , 'uses' => 'SurveyController@detail_survey']);
    Route::get('/survey/view/{survey}',['as' => 'view.survey' , 'uses' => 'SurveyController@view_survey']);
    Route::get('/survey/answers/{survey}',['as' => 'view.survey.answers' , 'uses' => 'SurveyController@view_survey_answers']);
    Route::get('/survey/{survey}/delete',['as' => 'delete.survey' , 'uses' => 'SurveyController@delete_survey']);
    Route::get('/survey/{survey}/edit',['as' => 'edit.survey' , 'uses' => 'SurveyController@edit']);
    Route::patch('/survey/{survey}/update',['as' => 'update.survey' , 'uses' => 'SurveyController@update']);
    Route::post('/survey/view/{survey}/completed',['as' => 'complete.survey' , 'uses' => 'AnswerController@store']);
    Route::post('/survey/create',['as' => 'create.survey' , 'uses' => 'SurveyController@create']);
    Route::post('/survey/{survey}/questions',['as' => 'store.question' , 'uses' => 'QuestionController@store']);
    Route::get('/question/{question}/edit',['as' => 'edit.question' , 'uses' => 'QuestionController@edit']);
    Route::patch('/question/{question}/update',['as' => 'update.question' , 'uses' => 'QuestionController@update']);
    
     
});

