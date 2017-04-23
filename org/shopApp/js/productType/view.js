$(function() {
	//给规格赋值
	var specs = $("#typeValueHidden").val();
	var specArr = specs.split(",");
	for(var i=0;i<specArr.length;i++){
		$("#specCheckBox"+specArr[i]).attr("checked","checked");
	};
});