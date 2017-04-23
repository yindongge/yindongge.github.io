function add(goodsId){
	$.ajax({
		url : 'update',
		type : 'post',
		dataType: 'json',
		data : {
			'advertisementId' : $('#advertisementId').val(),
			'productId' : goodsId
		},
		success : function(data){
			if(data.code=='200'){
				location.reload();
			};
		},
		error : function(data){
			
		}
	});
};

function cancel(advertisementItemId){
	$.ajax({
		url : 'cancel',
		type : 'post',
		dataType: 'json',
		data : {
			'advertisementItemId' : advertisementItemId
		},
		success : function(data){
			if(data.code=='200'){
				location.reload();
			};
		},
		error : function(data){
			
		}
	});
}