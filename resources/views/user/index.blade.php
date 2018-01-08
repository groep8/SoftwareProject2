@extends ('user./layouts/main')
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
        <div class="container">
            <div class="row">
                
                <div class="col-sm-6 text-center">
                <h1>My requests</h1>
                <div id="myrequests"></div>
                <br>
                <button class="btn btn-success open-modal add-request" id="addbutton"> Add Request</button>
                </div>
                <div class="col-sm-6 text-center">
                <h1>Open Surveys</h1>
                <br>
                <ul class="collection with-header" style="padding-left:0px;">
                
        @forelse ($surveys as $survey)
          <li class="collection-item">
            <div>
               <a href="user/survey/answers/{{ $survey->id }}"> {{  $survey->title}}</a>
                <a href="user/survey/view/{{ $survey->id }}" title="Take Survey" class="secondary-content"><i class="material-icons">send</i></a>
            </div>
            </li>
        @empty
            <p class="flow-text center-align">Nothing to show</p>
        @endforelse
                </div>                
            </div>
        </div>

        <!-- modal add -->
        <div class="modal fade in" id="add" tabindex="-1" role="dialog" aria-hidden="false">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add</h4>
                        </div>
                              
                                <div class="modal-body">
                               <form>
                                <p>Trainingnaam</p>
                                <input type="text" id="training" name ="training"  required>
                                <p>Startdatum</p>
                                <input type="text" id="datepicker" name ="date"  required>
                                </div>
                            <div class="modal-footer">
                                <button type="button" id="close-add" class="btn btn-default">Close</button>
                                <button type="button" id="upload" class="btn btn-primary start"><i class="glyphicon glyphicon-upload"></i><span> Send</span></button>
                               </form>
                            </div>
                    </div>
                </div>
        </div>


@stop

@section('footer_scripts')

<script>

$(document).on('click', '#addbutton', function(e) {
    e.stopPropagation();
    $("#add").css("opacity","0");
    $("#add").css("display","block");
    $("#add").fadeTo("400",1);

});    
$(document).on('click', '#close-add', function() {
 
    $("#add").fadeOut("300");
    
});    

</script>
<script>
$( document ).ready(function() {
    
   
    
       $.ajaxSetup({
           headers: {
               'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
           }
       });
   
       var timeout;
   
   
       
   
       $("#myrequests").jsGrid({
           width: "100%",
           height: "auto",
           class:"rwd-table",
           filtering: false,
           inserting: false,
           editing: false,
           sorting: true,
           paging: true,
           autoload: true,
           noDataContent: "Connection error",
           pageSize: 20,
           pageButtonCount: 10,
   
           controller: {
            
               loadData: function (filter) {
                   criteria = filter;
                   
                   var data = $.Deferred();
                   
                   $.ajax({
                       contentType: "application/json; charset=utf-8",
                       url: 'user/getrequests',
                       dataType: "json"
                       }).done(function(response){
                           console.log(response);
                           

                           var res = [];
                           if(!!criteria.Name)
                           {
                               console.log("response: " + response)
                               
                               response.forEach(function(element) {
                                   if(element.name.toLowerCase().indexOf(criteria.Name.toLowerCase()) > -1){
                                       res.push(element);
                                       response = res;
   
                                       
                           console.log("Debug front end : "+ response);
                                   }
                               }, this);
                           }
                           else res = response;
                           console.log("Debug front end : "+ response);
                           
                           
                           /*if(criteria.Title !== "")
                           {
                               res= [];
                               response.forEach(function(element) {
                                   if(element.Title.indexOf(criteria.Title) > -1)
                                       res.push(element);
                               }, this);
                           }
                           else res = response;*/
                           
   
                           data.resolve(res);
                           console.log("cehck : "+res);
                       });
                       
                   return data.promise();
               },
           },
   
           fields: [
               { title: "Training naam", name: "naamTraining", type: "text", width: 40, readOnly: true },
               { title: "Datum Request", name: "datum", type: "text", width: 30, readOnly: true },
               { title: "Start", name: "start", type: "text", width: 40, readOnly: true },
               { title: "Status", name: "status", type: "text", width: 30, readOnly: true },
               
           ]
           
       });
      
       
       });
   
   
       


</script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<script>
    $(document).ready(function(){



        $('#datepicker').datepicker({
            format: 'yyyy/mm/dd',
            startDate: '1d'
        });

    })
</script>
<script>
$(document).on('click', '#upload', function () {
    var training = $('#training').val();
    var date = $("#datepicker").val();
    console.log(training + " "+ date);  
    var provData = {
    'training' : training,
    'date' : date,
    '_token': "{{ csrf_token() }}"
    };

swal({
    title: 'Bevestigen?',
    text: 'Is dit informatie juist ?',
    type: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Ja',
    cancelButtonText: 'Nee'
    }).then((result) => {
    if (result.value) {

        
    $.ajax({
        type: 'PATCH',
        url: 'user/postrequest',
        data: provData
    }).done(function(data){
        console.log("Response ajax : "+data);
        console.log(typeof data['textStatus']);
        console.log( data['textStatus']);
        $('#myrequests').jsGrid("loadData");
        $('#add').fadeOut();
        swal(
    'Bevestigd',
    'Request gestuurd naar de manager',
    'success'
    ).catch(swal.noop)
    })
    } 
    else if (result.dismiss === 'cancel') {
    swal(
    'Niet bevestigd',
    'Request geannuleerd',
    'error'
    ).catch(swal.noop)
}
})});
</script>










@stop