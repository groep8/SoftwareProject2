@extends ('hr./layouts/default')
@section('title')
Laravel
@parent
@stop

@section('content')
<form method="POST" action="update">
  {{ method_field('PATCH') }}
  <input type="hidden" name="_token" value="{{ csrf_token() }}">
  <h2 class="flow-text">Edit Question Title</h2>
   <div class="row">
    <div class="input-field col s12">
      <input type="text" name="title" id="title" value="{{ $question->title }}">
      <label for="title">Qestion</label>
    </div>
    <div class="input-field col s12">
    <button class="btn waves-effect waves-light">Update</button>
    </div>
  </div>
</form>
@stop