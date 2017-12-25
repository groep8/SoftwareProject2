@extends ('hr./layouts/default')
@section('title')
Laravel
@parent
@stop

{{-- Page Content --}}
@section('content')
        <div class="flex-center position-ref "> 
            <div class="content">
                <div class="title m-b-md">
                Welcome {{ Sentinel::getUser()->username}}
                </div>
            </div>
        </div>
        <ul class="collection with-header">
        <li class="collection-header">
            <h2 class="flow-text">Recent Surveys
                <span style="float:right;">{{ link_to_route('hr.new.survey', 'Create new') }}
                </span>
            </h2>
        </li>
        @forelse ($surveys as $survey)
          <li class="collection-item">
            <div>
                {{ link_to_route('hr.detail.survey', $survey->title, ['id'=>$survey->id])}}
                <a href="hr/survey/view/{{ $survey->id }}" title="Take Survey" class="secondary-content"><i class="material-icons">send</i></a>
                <a href="hr/survey/{{ $survey->id }}" title="Edit Survey" class="secondary-content"><i class="material-icons"> edit</i></a>
                <a href="hr/survey/answers/{{ $survey->id }}" title="View Survey Answers" class="secondary-content"><i class="material-icons"> textsms</i></a>
            </div>
            </li>
        @empty
            <p class="flow-text center-align">Nothing to show</p>
        @endforelse
    </ul>
    @stop


@section('footer_scripts')














@stop