
function detailView(consultProblemId){
	var listPageNow = $(".current").text();
	window.location.href = '../consultation/webConsultationReplyView?consultProblemId='+consultProblemId+'&listPageNow='+listPageNow;
};
function submitForm(){
	$("#pageform").submit();
};
