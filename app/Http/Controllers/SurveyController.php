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
 
class SurveyController extends Controller
{
  
  public function __construct()
  {
   
  }

  public function home(Request $request) // Homepage function
  { 
    if (Sentinel::getUser()->inRole('hr')) {
    
        $surveys = Survey::get();
        
              return view('hr.index',["surveys"=>$surveys]);
      }
  }
 
  # Show page to create new survey
  public function new_survey() 
  {
    return view('hr.survey.new');
  }
 
  public function create(Request $request, Survey $survey) 
  {
    $arr = $request->all();
    // $request->all()['user_id'] = Auth::id();
    $arr['user_id'] = Sentinel::getUser()->id;
    $surveyItem = $survey->create($arr);
    return Redirect::to("hr/survey/{$surveyItem->id}");
  }
 
  # retrieve detail page and add questions here
  public function detail_survey(Survey $survey) 
  {
    $survey->load('questions.user');
    return view('hr.survey.detail', compact('survey'));
  }
  
 
  public function edit(Survey $survey) 
  {
    return view('hr.survey.edit', compact('survey'));
  }
 
  # edit survey
  public function update(Request $request, Survey $survey) 
  {
    $survey->update($request->only(['title', 'description']));
    return redirect()->action('SurveyController@detail_survey', [$survey->id]);
  }
 
  # view survey publicly and complete survey
  public function view_survey(Survey $survey) 
  { 
    if(Sentinel::getUser()->inRole('user')){
    $survey->option_name = unserialize($survey->option_name);
    return view('user.survey.view', compact('survey'));}
    else{
      $survey->option_name = unserialize($survey->option_name);
      return view('hr.survey.view', compact('survey'));
    }
  }
 
  # view submitted answers from current logged in user
  public function view_survey_answers(Survey $survey) 
  {
    if(Sentinel::getUser()->inRole('hr')){
    $survey->load('questions.answers');
    return view('hr.answer.view', compact('survey'));}
    else{
      $survey->load('questions.answers');
      return view('user.answer.view', compact('survey'));
    }
  }
  public function delete_survey(Survey $survey)
  {
    $survey->delete();
    return redirect()->route('hr.survey');
  }
 
}