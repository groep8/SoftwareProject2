@extends ('user./layouts/default')
@section('title')
Laravel
@parent
@stop

@section('content')
<div class="container">
<h4>{{ $survey->title }}</h4>
<table class="bordered striped">
  <thead>
    <tr>
        <th data-field="id">Question</th>
        <th data-field="name">Answer(s)</th>
    </tr>
  </thead>

  <tbody>
 

    @forelse ($survey->questions as $item)
    <tr>
      <td>{{ $item->title }}</td>
      
      @foreach ($item->answers as $answer)
        @if ($answer->user_id == $user_id)
        <td>{{ $answer->answer }} <br/>
        <small>{{ $answer->created_at }}</small></td>
        @endif
      @endforeach
    </tr>
    @empty
      <tr>
        <td>
          No answers provided by you for this Survey
        </td>
        <td></td>
      </tr>
    @endforelse
  </tbody>
</table>
</div>
@endsection
