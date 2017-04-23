function detailView(consultProblemId){
	var listPageNow = $(".current").text();
	window.location.href = '../consultation/productConsultationReplyView?consultProblemId='+consultProblemId+'&listPageNow='+listPageNow;
};
function submitForm(){
	$("#pageform").submit();
}