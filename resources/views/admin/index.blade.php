@extends ('admin./layouts/default')
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
                
                <div class="col-sm-12 text-center">
                <h1>Nog te bevestigen</h1>
                <div id="tebevestigen">
                <!--  <table class="rwd-table">-->
                </div>
                </div>
                </div>
                <div class="row">
                <div class="col-sm-12 text-center">
                <h1>Al Bevestigd</h1>
                <div id="albevestigen"></div>
                </div>
                </div>
            </div>
        </div>
@stop

@section('footer_scripts')

<script>
$( document ).ready(function() {
 

 
    $.ajaxSetup({
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        }
    });

    var timeout;


    

    $("#tebevestigen").jsGrid({
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
                    url: "admin/pending",
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
            { title: "Adres", name: "adres", type: "text", width: 30, readOnly: true },
            { title: "Employee", name: "naamEmployee", type: "text", width: 30, readOnly: true },
            { title: "Datum", name: "datum", type: "text", width: 30, readOnly: true },
            { title: 'Confirm', name: 'id', type: 'text', width: 30,
                itemTemplate: function(value) {
                    var show_html = '<a class="swal-confirm" id='+value+'>Confirm</a>'

                    return show_html;
                }
            }
           
        ]
    });
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


    

    $("#albevestigen").jsGrid({
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
                    url: "admin/confirmed",
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
            { title: "Adres", name: "adres", type: "text", width: 30, readOnly: true },
            { title: "Employee", name: "naamEmployee", type: "text", width: 30, readOnly: true },
            { title: "Datum", name: "datum", type: "text", width: 30, readOnly: true },
            { title: 'Undo Confirmation', name: 'id', type: 'text', width: 30,
                itemTemplate: function(value) {
                    var show_html = '<a class="swal-undo" id='+value+'>Undo</a>'

                    return show_html;
                }
            }
           
        ]
    });
    });


    
</script>
<script>
    $(document).on('click', '.swal-confirm', function () {
        var id = $(this).attr("id");
            
            var provData = {
        'id' : id,
        '_token': "{{ csrf_token() }}"
        };

    swal({
        title: 'Bevestigen?',
        text: 'Bent u zeker dat u wilt dit training bevestigen?',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ja',
        cancelButtonText: 'Nee'
        }).then((result) => {
        if (result.value) {
    
            console.log("id : "+id);
        $.ajax({
            type: 'POST',
            url: 'admin/confirm',
            data: provData
        }).done(function(data){
            console.log("Response ajax : "+data);
            console.log(typeof data['textStatus']);
            console.log( data['textStatus']);
            $('#tebevestigen').jsGrid("loadData");
            $('#albevestigen').jsGrid("loadData");
            swal(
        'Bevestigd',
        'Training voor Employee werd bevestigd',
        'success'
        ).catch(swal.noop)
        })
        } 
        else if (result.dismiss === 'cancel') {
        swal(
        'Niet bevestigd',
        'Training voor employee werd niet bevestigd',
        'error'
        ).catch(swal.noop)
    }
    })});
</script>
<script>
    $(document).on('click', '.swal-undo', function () {
        var id = $(this).attr("id");
            
            var provData = {
        'id' : id,
        '_token': "{{ csrf_token() }}"
        };

    swal({
        title: 'Bevestigen?',
        text: 'Bent u zeker dat u wilt dit confirmatie bevestigen?',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ja',
        cancelButtonText: 'Nee'
        }).then((result) => {
        if (result.value) {
    
            console.log("id : "+id);
        $.ajax({
            type: 'POST',
            url: 'admin/undo',
            data: provData
        }).done(function(data){
            console.log("Response ajax : "+data);
            console.log(typeof data['textStatus']);
            console.log( data['textStatus']);
            $('#tebevestigen').jsGrid("loadData");
            $('#albevestigen').jsGrid("loadData");
            swal(
        'Bevestigd',
        'Confirmatie werd verwijderd',
        'success'
        ).catch(swal.noop)
        })
        } 
        else if (result.dismiss === 'cancel') {
        swal(
        'Niet bevestigd',
        'Training voor employee werd niet bevestigd',
        'error'
        ).catch(swal.noop)
    }
    })});
</script>












@stop