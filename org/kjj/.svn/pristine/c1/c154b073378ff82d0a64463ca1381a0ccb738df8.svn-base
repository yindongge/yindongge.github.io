$(function(){
	$(".slideTxtBox").slide({trigger:"click"});
	
	$("#orderDesc").click(function(){
		$("div.detail-list").toggle();
	});
});

window.setInterval(checkPay, 10000);

function checkPay(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../wxpay/check/"+$("#orderId").val(),
        success: function(data) {
        	if(data==200){
        		location.href = "../order/desc?orderId="+$("#orderId").val();
        	}
        },  
        error: function(data) {  
        }  
    })  ;  
}