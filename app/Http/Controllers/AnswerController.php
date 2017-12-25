<?php
 
namespace App\Http\Controllers;
use Auth;
use App\Survey;
use App\Answer;
use Illuminate\Http\Request;
use App\Http\Requests;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Redirect;
use Sentinel;


class AnswerController extends Controller
{
 
 public function store(Request $request, Survey $survey) 
 {
   // remove the token
   $arr = $request->except('_token');
   //dd($arr);
   foreach ($arr as $key => $value) {
     $newAnswer = new Answer();
     if (! is_array( $value )) {
       $newValue = $value['answer'];
     } else {
       $newValue = json_encode($value['answer']);
     }
     $newAnswer->answer = $newValue;
     $newAnswer->question_id = $key;
     $newAnswer->user_id = Sentinel::getUser()->id;
     $newAnswer->survey_id = $survey->id;

     $newAnswer->save();
   };
   return redirect()->action('SurveyController@view_survey_answers', [$survey->id]);
 }
}