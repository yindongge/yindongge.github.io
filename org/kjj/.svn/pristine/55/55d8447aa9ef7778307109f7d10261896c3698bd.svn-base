
function reply(){
	if($("#replyTextarea").val().trim()==""){
		alert('请输入回复内容');
		return false;
	}
	$.ajax({
		url : '../consultation/productConsultationReply',
		type : 'post',
		dataType : 'json',
		data : {
			'consultProblemId' : $("#consultProblemId").val(),
			'consultAnswer' : $("#replyTextarea").val()
		},
		success : function(data){
			if(data.code==200){
				alert('回复成功');
				 location.reload();
			}
			if(data.code==400){
				alert('已回复成功，不要重复提交');
				location.reload();
			}
		},
		error : function(){
			
		}
	});
}
function back(){
	window.location.href = '../consultation/productConsultationList';
}
