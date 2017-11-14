<?php
include_once 'web_user.php';
include_once 'web_admin.php';
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/',['uses'=>'AuthController@home'] );
Route::get('login',['uses'=>'AuthController@home'] );

Route::post('signin',['as' => 'signin','uses' =>'AuthController@postSignin']);

Route::group(array('prefix' => 'admin' ), function(){
    
    Route::get('signin',['as' => 'signin','uses' =>'AuthController@getSignin']);
    Route::post('signin',['as' => 'signin','uses' =>'AuthController@postSignin']);
    Route::get('logout',['as' => 'logout' , 'uses' => 'AuthController@getLogout']);
    
});


Route::group(array('prefix' => 'user' ), function(){
    
    Route::get('signin',['as' => 'signin','uses' =>'AuthController@getSignin']);
    Route::post('signin',['as' => 'signin','uses' =>'AuthController@postSignin']);
    Route::get('logout',['as' => 'logout' , 'uses' => 'AuthController@getLogout']);
    
});
