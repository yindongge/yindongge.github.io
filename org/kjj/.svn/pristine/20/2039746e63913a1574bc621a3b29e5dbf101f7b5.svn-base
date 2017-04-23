jQuery(".slideBox").slide( { mainCell:".bd ul",effect:"left",autoPlay:true} );

function validate(){
	var problem1 = $('input[name="problem1"]:checked').val();
	if(problem1 == undefined){
		$("#valmessage1").show();
		location.href = "#firstAnchor"; 
		return false;
	}else{
		$("#valmessage1").hide();
	}
	var problem2 = $('input[name="problem2"]:checked').val();
	var problem3 = $('input[name="problem3"]:checked').val();
	var problem4 = $('input[name="problem4"]:checked').val();
	var problem5 = $('input[name="problem5"]:checked').val();
	var problem6 = $('input[name="problem6"]:checked').val();
	if(problem2 == undefined || problem3 == undefined || problem4 == undefined || problem5 == undefined || problem6 == undefined){
		$("#valmessage").show();
		location.href = "#firstAnchor";
		return false;
	}else{
		$("#valmessage").hide();
	}
	if(!isMobile($('input[name="phoneNum"]').val())||$('input[name="name"]').val().length>20){
		$("#phoneNumMessage").show();
		return false;
	}else{
		$("#phoneNumMessage").hide();
	}
	return true;
}

function submit(){
	if(!validate()){
		return false;
	}
	$.ajax({
		url : '../feedback/save',
		type : 'post',
		dataType : 'json',
		data : $("#form").serialize(),
		success : function(data){
			if(data == 200){
				$("#tooltip").show();			
			}
		}
	});
}