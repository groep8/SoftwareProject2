@extends ('user./layouts/default')
@section('title')
Laravel
@parent
@stop

{{-- Page Content --}}
@section('content')
        <div class="flex-center position-ref "> 
            <div class="content">
                <div class="title m-b-md">
                    User Home
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                
                <div class="col-sm-4 text-center">
                <h1>My requests</h1>
                <div id="myrequests"></div>
                <br>
                <button class="btn btn-success open-modal add-request" id="addbutton"> Add Request</button>
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
                                
                                </div>
                            <div class="modal-footer">
                                <button type="button" id="close-add" class="btn btn-default">Close</button>
                                <button type="submit" id="upload" class="btn btn-primary start"><i class="glyphicon glyphicon-upload"></i><span> Send</span></button>
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
                       url: "getrequests",
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
               { title: "Datum", name: "datum", type: "text", width: 30, readOnly: true },
               { title: "Status", name: "status", type: "text", width: 30, readOnly: true },
              
           ]
           
       });
      
       
       });
   
   
       


</script>

<script>
$(document).ready(function() {

    
    /* while($("#myrequests").val() == ""){
        if($("#myrequests").val() != ""){
            var arrayOfRows = $("tr[class*='jsgrid-'] > td:nth-child(3)");
            break
        }
        
        
        
    }
    
    console.log(arrayOfRows);
    */
 
   


});
</script>










@stop