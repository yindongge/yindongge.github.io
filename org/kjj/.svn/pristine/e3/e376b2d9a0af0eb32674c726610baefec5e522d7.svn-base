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

function setCheckshop() {
	var zTree = $.fn.zTree.getZTreeObj("shoptree"),
/* 	py = $("#py").attr("checked")? "p":"",
	sy = $("#sy").attr("checked")? "s":"",
	pn = $("#pn").attr("checked")? "p":"",
	sn = $("#sn").attr("checked")? "s":"",
	type = { "Y":py + sy, "N":pn + sn}; */
	type = { "Y" : "ps", "N" : "ps" };
	zTree.setting.check.chkboxType = type;
	showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
}

function setCheckrole() {
	var zTree = $.fn.zTree.getZTreeObj("roletree"),
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
	
	var email=$("#email").val();
	
	if(email==""){
		alert("请填写手机号");
		return false;
	}
	
	var userName=$("#userName").val();
	
	if(userName==""){
		alert("请填写用户名");
		return false;
	}
	
	if(userName.length<2||userName.length>20){
		alert("用户名长度在 2-20 之间");return false;
	}
	
	var password = $("#password").val();
	if(password == ""){
		alert("请填写密码"); return false;
	}
	
	
	if (!$("#email").val().match(/^0?1[3|4|5|7|8][0-9]\d{8}$/)) { 
		alert("请填写正确的手机号！");
		return false; 
	}
	
	var ids = "";
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);

	for(var i=0; i<nodes.length; i++){
		ids += nodes[i].id+",";
	}
	$("#modelIds").val(ids);
	
	if(ids == ""){
		alert("请选择权限！"); return false;
	}

	var shop = "";
	var shopObj = $.fn.zTree.getZTreeObj("shoptree");
	var shopnodes = shopObj.getCheckedNodes(true);

	for(var i=0; i<shopnodes.length; i++){
		shop += shopnodes[i].id+",";
	}
	$("#shopIds").val(shop);
	
	if(shop == ""){
		alert("请选择店铺！"); return false;
	}
	
	var role = "";
	var roleObj = $.fn.zTree.getZTreeObj("roletree");
	var rolenodes = roleObj.getCheckedNodes(true);

	for(var i=0; i<rolenodes.length; i++){
		role += rolenodes[i].id+",";
	}
	$("#roleIds").val(role);
	
	if(role == ""){
		alert("请选择角色！"); return false;
	}

   $.ajax({
      type: "POST",
      dataType: "json",
      url: "../edit",
      data: $('#adminForm').serialize(),
      success: function (data) {  
         if(data.code==200){
        	 location.href="../list";
         }else{
        	 alert("手机号已存在！");
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
          url: "../../admin/getAllMenu?userId="+$("#userId").val(),
          success: function (data) {
             if(data.code==200){
            	zNodes=data.list;
            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
         		setCheck();
         		setShop();
             }
          },
          error: function(data) {
              alert("error:"+data.responseText);
           }
      });
	
});

function setShop(){
	$.ajax({
          type: "POST",
          dataType: "json",
          url: "../../admin/getAllShop?userId="+$("#userId").val(),
          success: function (data) {
             if(data.code==200){
            	$.fn.zTree.init($("#shoptree"), setting, data.list);
         		setCheckshop();
         		setRole();
             }
             
          },
          error: function(data) {
              alert("error:"+data.responseText);
           }
      });
}

function setRole(){
	$.ajax({
          type: "POST",
          dataType: "json",
          url: "../../admin/getAllRole?userId="+$("#userId").val(),
          success: function (data) {
             if(data.code==200){
            	$.fn.zTree.init($("#roletree"), setting, data.list);
         		setCheckrole();
             }
          },
          error: function(data) {
              alert("error:"+data.responseText);
           }
      });
}