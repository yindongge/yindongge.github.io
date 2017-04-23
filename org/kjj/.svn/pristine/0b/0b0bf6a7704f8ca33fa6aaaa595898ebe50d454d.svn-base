$(function() {
	
	$(".slideBox").slide({
		mainCell : ".bd ul",
		effect : "top",
		trigger : "click",
		pnLoop : false
	});
	
	$(".slideTxtBox").slide({
		trigger : "click"
	});
	
	$(".slideTxtBox").find("li").on("click",function(){
		$(".slideTxtBox").find(":hidden").val($(this).attr("data-type-id"));
		$("#pageform").submit();
	});
	
	$(".slideTxtBox").find("li").each(function(){
		if($(this).attr("data-type-id")==$(".slideTxtBox").find(":hidden").val()){
			$(this).addClass("on");
			$(this).siblings().removeClass("on");			
		}
	});
	
	$(".consult-radio").find(":radio").on("click",function(){
		$("[name='consultTypeId']").val($(this).attr("data-type-id"));
		$("[name='consultTypeName']").val($(this).next("label").text());
	});

	$(".consult-r").find(".dd2").on("click",function(){
		var i=0;
		$(".consult-radio").find(":radio").each(function(){
			if(this.checked==true){
				i++;
			}
		});
		if(!i){
			alert("请选择咨询类型");
			return false;
		}
		if($("[name='consultProblem']").val().trim()==""){
			alert("请输入咨询内容");
			return false;
		};
		$("#addconsult").submit();
	});
	
	
	$(".feedlist").last().find(":radio").on("click",function(){
		$("[name='consultTypeId']").val($(this).attr("data-type-id"));
		$("[name='consultTypeName']").val($(this).next("label").text());
	});
	
	$(".samebtn").on("click",function(){
		var i=0;
		$(".feedlist").last().find(":radio").each(function(){
		if(this.checked==true){
			i++;
		}
		});
		if(!i){
			alert("请选择留言类型");
			return false;
		}
		if($("[name='consultProblem']").val().trim()==""){
			alert("请输入留言内容");
			return false;
		};
		$("#addconsult").submit();
	});
	
});