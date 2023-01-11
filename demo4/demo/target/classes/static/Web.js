function btn(zone){
    $(".card-group").empty();
    $.ajax({
        url: 'http://localhost:8080/sights',
        type: 'GET',
        success: function(data){
            $.each(data, function(index, item){
                if(item.zone==zone){
                    $('.card-group').append(
                        '<div class="col-xs-6 col-md-4">'+
                            '<div class="card" style="width: 21rem;" >'+
                                '<div class="card-body">'+
                                    '<h5 class="card-title">'+item.sightName+'</h5>'+
                                    '<ul class="list-group list-group-flush">'+
                                        '<li class="list-group-item">'+item.zone+'</li>'+
                                        '<li class="list-group-item">'+item.category+'</li>'+
                                    '</ul>'+
                                    '<a href="http://maps.google.com/?q='+item.address+'" target="_blank" class="card-link">'+item.address+'</a>'+'</br>'+
                                    '<button type="button" class="btn btn-primary" data-bs-toggle="collapse" data-bs-target="#test'+index+'">'+"詳細資料"+'</button>'+

                                '</div>'+
                                '<div class="card">'+
                                    '<div id="test'+index+'" class="collapse">'+
                                        '<div class="card-body">'+item.description+'</div>'+
                                        '<img class="card-img-bottom" src="'+item.photoURL+'" alt="Card image" style="width:100%">'+
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'
                    )
                }
            })
        },
        error: function(){}
    })
}