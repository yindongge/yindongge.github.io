$(function () {
		
		//数量减少
		$("[name='orderGoodsId']").click(function(){
			$("[name='amount']").val($(this).parents("tr").find("[name='amountText']").val());
		});
		
		//数量减少
		$("[name='amountMinus']").click(function(){
			var amountText = $(this).next();
			
			if(amountText.val() > 1){
				amountText.val(parseInt(amountText.val())-1);
			}
			
			editAmount(amountText);
		});
		
		//数量增加
		$("[name='amountPlus']").click(function(){	
			var amountText = $(this).prev();
			amountText.val(parseInt(amountText.val())+1);
			editAmount(amountText);
		});
		
		//数量改变
		$("[name='amountText']").on("focusout",function(){
		 	if(!isPlusInteger($(this).val())){
				$(this).val($(this).attr('old'));
			} 
		 	editAmount($(this));
		});
		//校验
		$("#returnForm").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			}
		});
		
	});
	
	//修改商品库存
	function editAmount(amountText){
		
		if(parseInt(amountText.val())>parseInt(amountText.attr("lastAmount"))){
			amountText.val(amountText.attr('old'));
		}
		
		amountText.attr('old',amountText.val());
		
		if(amountText.parents("tr").find("[name='orderGoodsId']").val() == $(":checked[name='orderGoodsId']").val()){
			$("[name='amount']").val(amountText.val());
		}
		
		//修改减少数量按钮是否可用
 		if(amountText.val() == 1){
 			amountText.prev().addClass('diasbled');
		}else{
			amountText.prev().removeClass('diasbled');
		}
	}
