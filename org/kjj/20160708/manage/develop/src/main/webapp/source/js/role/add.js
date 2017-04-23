var setting = {
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

var zNodes =[
	
];

var code;

function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
/* 	py = $("#py").attr("checked")? "p":"",
	sy = $("#sy").attr("checked")? "s":"",
	pn = $("#pn").attr("checked")? "p":"",
	sn = $("#sn").attr("checked")? "s":"",
	type = { "Y":py + sy, "N":pn + sn}; */
	type = { "Y" : "ps", "N" : "ps" };
	zTree.setting.check.chkboxType = type;
	showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
}
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

function saveRole(){
	
	if($("#roleName").val()==''){
		alert("角色名称不能为空");
		return false;
	}
	
	var ids = "";
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);

	for(var i=0; i<nodes.length; i++){
		ids += nodes[i].id+",";
	}
	
   $("#modelid").val(ids);
   $.ajax({
      type: "POST",
      dataType: "json",
      url: "../role/add",
      data: $('#roleForm').serialize(),
      success: function (data) {  
         if(data.code==200){
        	 location.href="../role/list";
         }else{
        	 alert("添加失败！");
         }
      },
      error: function(data) {
        
       }
  });
}

$(document).ready(function(){
	$.ajax({
      type: "POST",
      dataType: "json",
      url: "../role/getAllMenu",
      success: function (data) {
         if(data.code==200){
        	zNodes=data.list;
        	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
     		setCheck();
     		$("#py").bind("change", setCheck);
     		$("#sy").bind("change", setCheck);
     		$("#pn").bind("change", setCheck);
     		$("#sn").bind("change", setCheck);
         }
      },
      error: function(data) {
          alert("error:"+data.responseText);
      }
  });
	
  //校验
  $("#roleForm").bootstrapValidator();
});