var createCondition = function(id,reachId,reachCondition,discountArr){
    var condition = new Object();
    condition.id = id;
    condition.reachId = reachId;
    condition.reachCondition = reachCondition;
    condition.discountArr = discountArr;
    return condition;
 };
 
var createDiscount = function(typeId,isloop,common){
    var discount = new Object();
    discount.typeId = typeId;
    discount.isloop = isloop;
    discount.common = common;
    return discount;
 };
var rowNum=$('#reachRow').find('tr').last().find('td').first().text();

$(function(){
	
	//满减满送类型：0元，1件
	if($('#reachStyle').val()==1){
		$('.special_form').parent().append('件');
		$('#reachRow').on('blur','.special_form',function(){
			if(!isPlusInteger($(this).val())){
				alert('请输入整数！');	
				$(this).val('');
			}
		});
		$('.special_form').each(function(){
			$(this).val($(this).val().substring(0,$(this).val().lastIndexOf(".")));
		});
	}else{
		$('.special_form').parent().append('元');	
		$('#reachRow').on('blur','.special_form',function(){
			if(!isFloat($(this).val())){
				alert('请输入数字！');
				$(this).val('');
			}
		});
	}
	
	//新增一级优惠
	$('#addReachBtn').on('click',function(){
		if(rowNum==5){
			alert("优惠层级最多设置5个");
			return false;
		}
		rowNum++;
		$('#reachTemple').find('td').eq(0).text(rowNum);
		var tbodyHtml=$('#reachTemple').html().replace('style=\"display:none\"',"");
		$('#reachRow').append(tbodyHtml);
	});
	
	//删除一级优惠
	$('#reachRow').on('click','.btn.btn-danger.btn-xs',function(){
		if(confirm('确定删除吗 ？')){
			rowNum--;
			$(this).parents('tr').remove();
			$('#reachRow').find('tr td:first-child').each(function(i){
				$(this).text(i+1);
			});
			var conditionId=$(this).parent().prev().prev().attr("data-id");
			if(conditionId!=0){
				$.ajax({
					type: "post",  
					dataType:"json", 
					url: "deleteSetData",  
					data:  {conditionId:conditionId},
				});
			}
		}
		
	});
	
	//显示减钱输入框
	$('#reachRow').on('click','.checkbox1.money',function(){
//		$(this).parents('td').next().find('.btn.btn-info.btn-xs').removeAttr("disabled"); 
		if($(this).is(':checked')){
			$(this).parents('.checkbox').find('.reduceMoney').show();
		}else{
			$(this).parents('.checkbox').find('.reduceMoney').hide();			
		}
	});
//	$('#reachRow').on('click','.checkbox1.coupon',function(){
//		$(this).parents('td').next().find('.btn.btn-info.btn-xs').removeAttr("disabled"); 
//	});
//	
//	$('#reachRow').on('click','.checkbox1.product',function(){
//		$(this).parents('td').next().find('.btn.btn-info.btn-xs').removeAttr("disabled"); 
//	});
	
	
	
	
	//减钱验证
	$('#reachRow').on('blur','.reduceMoney :text',function(){
		if(!isFloat($(this).val())){
			alert('请输入数字！');
			$(this).val('');
		}
	});
	
	//显示赠送优惠券选择框
	$('#reachRow').on('click','.btn.btn-success.coupon',function(){
//		var num=$(this).parents('tr').find('td').first().text();
//		var reachDiscountId=$(this).parents('td').find('.discountId').val();
//		$(this).parents('td').next().find('.btn.btn-info.btn-xs').attr('disabled',"true");
		var str='';
		var reachDiscountId=$(this).attr('data-id');
		if(reachDiscountId!=undefined){
			str='?reachDiscountId='+reachDiscountId;
		}
		layer.open({
			type: 2,
			title: '选择优惠券',
			shadeClose: true,
			shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
			area: ['800px', '630px'],
			content: ['reachCouponList'+str,'no'],
		}); 
	});
	
	
	//显示赠送商品选择框
	$('#reachRow').on('click','.btn.btn-success.product',function(){
		var str='';
		var reachDiscountId=$(this).attr('data-id');
		if(reachDiscountId!=undefined){
			str='?reachDiscountId='+reachDiscountId;
		}
		layer.open({
		    type: 2,
		    title: '选择商品',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['800px', '630px'],
		    content: ['reachItemList'+str,'no'],
		}); 
	});
	

	
	//保存按钮
	$('#reachRow').on('click','.btn.btn-info.btn-xs',function(){
		btnShow();
		var reachId=$("#reachId").val();
		var isloop=0;
		//循环每一级优惠,获得【优惠门槛】，【优惠方式(可多选)】
			var discountArr=new Array();
			//【优惠方式(可多选)】
			var btn=$(this);
			var td3=btn.parent().prev();		
			var td2=td3.prev();
			var id=td2.attr("data-id");
			//减钱
			if(td3.find('.checkbox1.money').is(':checked')){
				var common=td3.find('.reduceMoney :text').val();
				isloop=	td3.find('.moneyLoop').is(':checked')?1:0;
				discountArr.push(createDiscount(1,isloop,common));
			}
			//送优惠券
			if(td3.find('.checkbox1.coupon').is(':checked')){
				td3.find('.btn.btn-success.coupon').show();
				isloop=	td3.find('.couponLoop').is(':checked')?1:0;
				discountArr.push(createDiscount(2,isloop,'0'));
			}else{
				td3.find('.btn.btn-success.coupon').hide();			
			}
			//送商品
			if(td3.find('.checkbox1.product').is(':checked')){       //TODO  3保存到后台   4 回显   5 页面跳转
				td3.find('.btn.btn-success.product').show();
				isloop=	td3.find('.productLoop').is(':checked')?1:0;
				discountArr.push(createDiscount(3,isloop,'0'));
			}else{
				td3.find('.btn.btn-success.product').hide();			
			}
			var condition=createCondition(id,reachId,td2.find(':text').val(),discountArr);
			var conditionStr = JSON.stringify(condition);
			console.log(conditionStr);
			$.ajax({
				type: "post",  
			    dataType:"json", 
			    url: "editSetData",  
			    data:  {jsonStr:conditionStr},
			    success:function(d,s,x){
//			    	if(x.status="200"){
//			    		td2.attr("data-id",d);
//			    	}
//			    	location.refresh();
			    	location.reload();
			    },
			});
	});
});

function btnShow(){
	//显示选择优惠券按钮
	if($('#reachRow').find('.checkbox1.coupon').is(':checked')){
		$(this).parents('.checkbox').find('.btn.btn-success.coupon').show();
	}else{
		$(this).parents('.checkbox').find('.btn.btn-success.coupon').hide();			
	}
	
	//显示选择赠品按钮
	if($('#reachRow').find('.checkbox1.product').is(':checked')){
		$(this).parents('.checkbox').find('.btn.btn-success.product').show();
	}else{
		$(this).parents('.checkbox').find('.btn.btn-success.product').hide();			
	}
}
