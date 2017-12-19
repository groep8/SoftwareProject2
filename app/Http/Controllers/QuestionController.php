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

class QuestionController extends Controller
{
    public function __construct()
    {
       
    }
  
    public function store(Request $request, Survey $survey) 
    {
      $arr = $request->all();
      $arr['user_id'] = Sentinel::getUser()->id;

      $survey->questions()->create($arr);
      return back();
    }

    public function edit(Question $question) 
    {
      return view('hr.question.edit', compact('question'));
    }

    public function update(Request $request, Question $question) 
    {

      $question->update($request->all());
      return redirect()->action('SurveyController@detail_survey', [$question->survey_id]);
    }

}
