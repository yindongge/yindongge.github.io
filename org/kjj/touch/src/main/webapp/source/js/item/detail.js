$.fn.raty.defaults.path=$("#imgBase").val();
var ti=null;
var ti2=null;

$(function(){	

	$(".ch").find("a").not(".active").on("click",function(){
		var arr = new Array();
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		$(".ch").find(".active").each(function(){
			arr.push($(this).next().val());
		});		
		var jsonObj=pageInfo;	
		var len=jsonObj.length;
		var k=0;
		$.each(jsonObj,function(i,n){
			var arrTmp=new Array();
			$.each(n.skuSpecList,function(j,m){   // 各种规格信息
				var unionId=m.specId+"_"+m.specTypeId;
				arrTmp.push(unionId);
			});
			if(arrTmp.sort().toString()==arr.sort().toString()){
				window.location.href=n.itemId; 
			}else{
				k=k+1;
			}
		});
		if(k==len){
			alert("暂无该规格的商品！");
		}
	});

	
});


