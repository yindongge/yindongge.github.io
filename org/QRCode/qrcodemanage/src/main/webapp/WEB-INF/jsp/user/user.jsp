<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link href="../source/css/mycss/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="../source/css/mycss/public.css" rel="stylesheet" type="text/css" />
	<title>车辆管理</title>
	<script type="text/javascript">
	window.onload=function(){
	    document.getElementById("qx").onclick=function(){
	       var a=this.checked;
	       shuzu=document.getElementsByName("check")
	       for ( var i = 0; i < shuzu.length; i++) {
		     shuzu[i].checked=a;
	       }   
	    } 
	  }
	function deletebyid(){	 
		if(!confirm("确定删除吗？")){
			return;
		} else{
		   document.pageform.action="${ctx}/carmanage/deleteByCarid";	   
		   document.pageform.submit();
		}
	 }
		function selectcarfactory () {				 
			document.getElementById("carfactory").innerHTML="";
			var obj = document.getElementById("carBand").value;				
			$.ajax({
			   	type: "POST",		
			   	url: "${ctx}/carmanage/querycarfactory",
			  	data: "fatherId="+obj,
			   	success: function(msg){
				     	  var json = eval(msg);
				     	   jQuery("#carfactory").append("<option value=''> 请选择厂家</option>");	                    	 
				     	 for (var i = 0; i < json.length; i++){
	                    	 jQuery("#carfactory").append("<option value='"+json[i].brandId+"'>"+json[i].nameCh+"</option>");	                    	 
	                      };
			    }
		    });	
	   }
		
		function selectcartype () {				 
			document.getElementById("cartype").innerHTML="";
			var obj = document.getElementById("carfactory").value;				
			$.ajax({
			   type: "POST",		
			   url: "${ctx}/carmanage/querycartype",
			   data: "fatherId="+obj,
			   success: function(msg){
				     	  var json = eval(msg);
				     	   jQuery("#cartype").append("<option value=''> 请选择型号</option>");	                    	 
				     	 for (var i = 0; i < json.length; i++){
	                    	 jQuery("#cartype").append("<option value='"+json[i].brandId+"'>"+json[i].nameCh+"</option>");	                    	 
	                      };
			   }
			});	
	}
		function selectcaryear () {				 
			document.getElementById("caryear").innerHTML="";
			var obj = document.getElementById("cartype").value;				
			$.ajax({
			   type: "POST",		
			   url: "${ctx}/carmanage/querycaryear",
			   data: "fatherId="+obj,
			   success: function(msg){
				     	  var json = eval(msg);
				     	   jQuery("#caryear").append("<option value=''> 请选择年款</option>");	                    	 
				     	 for (var i = 0; i < json.length; i++){
	                    	 jQuery("#caryear").append("<option value='"+json[i].brandId+"'>"+json[i].nameCh+"</option>");	                    	 
	                      };
			   }
			});	
	}
		 
		
		function nocheck(id) {
 				var iWidth = 400;
				var iHeight = 250;
				var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
				var iLeft = (window.screen.availWidth-100-iWidth)/2; //获得窗口的水平位置;
				var openUrl = "carnocheck?carId="+id; 			 
			window.open(openUrl, "", "height=" + iHeight + ", width=" + iWidth+", top="+iTop+", left="+iLeft);
		}
		 
	</script>
</head>
 
<body>
<div class="page-wrapper">
<div class="container-fluid">		 
			 	 
  		<table class="table table-hover table-bordered" style="margin-top: -10px">
			<thead>
				<tr class="info">
					 
					<th>序号</th>
					<th>车牌号</th>
					 
 				</tr>
			</thead>
			<tbody>
			 
				<c:forEach var="item" items="${userlist}" varStatus="i">
				<tr>
					<td>${item.username}    </td>
					<td>${item.userrealname}</td>
					 
 				</tr>
				</c:forEach>
			</tbody>
		</table>
		 
			 	
		</nav>
	</form>
</div>
</div>
 
<script src="${jsBase}/user/chebangUserList.js" type="text/javascript"></script>
</body>
</html>
