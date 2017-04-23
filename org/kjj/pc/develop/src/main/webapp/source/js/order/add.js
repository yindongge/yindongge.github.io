$(function () {
	//初始化
	//提交按钮
	if($("ul.message").children("li:not(.disabled-me)").length>0 ){
		if($("#sendDate").val() != ''){
			$("#btnAddOrder").removeClass("btn-disabled");
			$("#btnAddOrder").addClass("btn-warning");
			$("#btnAddOrder").prop("disabled",false);
		}
	}
	
	//页签切换
	$(".slideTxtBox").slide({trigger:"click"});
	
	//收货地址范围提示展示
	$('.t1').click(function(){
		$(".t2").toggle();
	});
	
	//问号
	$('.method a').hover(function(){
		$(this).addClass('pay-hover');
	},function(){
		$(this).removeClass('pay-hover');
	});
	
	$('[data-toggle="popover"]').popover();
	
	//鼠标显示提示信息
	$("span.icon6").hover(function(){
		$(this).parent().find("div.pop").show();
	},function(){
		$(this).parent().find("div.pop").hide();
	});
	
	//关闭或取消
	$(":button[name='buttonClose']").click(function(){
		$(this).parent().parent().hide();
		//校验提示
		$(this).parent().parent().find("b").hide();
		//遮罩
		$(".mask-index").hide();
	});
	
	//选择在线支付
	$("a.method1").click(function(){
		$("a.method1").addClass("active");
		$("a.method2").removeClass("active");
		$("#payStyle").val(0); 
		$("#divLocalPay").hide();
		//余额支付
		$("#useDeposit").prop("disabled",false);
	});
	//选择货到付款
	$("a.method2").click(function(){
		$("a.method2").addClass("active");
		$("a.method1").removeClass("active");
		$("#payStyle").val(1); 
		$("#divLocalPay").show();
		//余额支付
		if($("#useDeposit").prop("checked")){
			$("#useDeposit").click();
		}
		$("#useDeposit").prop("disabled",true);
	});
	
	//选择送货上门
	$("#sendStyleSend").click(function(){
		$("#sendStyle").val(0); 
		$("a.method2").show();
		//提交按钮
		if($("ul.message").children("li:not(.disabled-me)").length==0 ){
			$("#btnAddOrder").removeClass("btn-warning");
			$("#btnAddOrder").addClass("btn-disabled");
			$("#btnAddOrder").prop("disabled",true);
		}
		
	});
	//选择到店自取
	$("#sendStyleTake").click(function(){
		$("a.method1").addClass("active");
		$("a.method2").removeClass("active");
		$("#payStyle").val(0); 
		$("#sendStyle").val(1); 
		$("a.method2").hide(); 
		$("#divLocalPay").hide(); 
		//余额支付
		$("#useDeposit").prop("disabled",false);
		//提交按钮
		if($("#sendDate").val() != ''){
			$("#btnAddOrder").removeClass("btn-disabled");
			$("#btnAddOrder").addClass("btn-warning");
			$("#btnAddOrder").prop("disabled",false);
		}
	});
	
	//送货时间显示
	$("#sendModify").click(function(){
		$(".mask-index").show();
		$("#sendDiv").show();
	});
	
	//选择送货时间
	$("#sendDiv td:not(.disabled)").click(function(){
		$("#sendDiv td.visited").text("可选");
		$("#sendDiv td.visited").removeClass("visited");
		$(this).addClass("visited");
		$(this).text("已选");
	});
	
	//确认送货日期
	$("#confirmSendDate").click(function(){
		var sendTd = $("#sendDiv td.visited");
		$("#sendDiv").hide();
		$(".mask-index").hide();
		$("#sendDate").val(sendTd.attr("data-send-date"));
		$("#sendTimeStart").val(sendTd.attr("data-send-time-start"));
		$("#sendTimeEnd").val(sendTd.attr("data-send-time-end"));
		$("div.pay-time p:first").html("配送时间：预计   "+sendTd.attr("data-send-date").substring(5,10)+"["+sendTd.attr("data-send-week")+"] "+sendTd.attr("data-send-time-start").substring(0,5)+"-"+sendTd.attr("data-send-time-end").substring(0,5));
	});
	
	//到店自取日期显示
	$("#takeModify").click(function(){
		$("#takeDiv").show();
		$(".mask-index").show();
	});

	//选择自取日期
	$("#takeDiv li:not(.disabled)").click(function(){
		$("#takeDiv li.visited").removeClass("visited");
		$(this).addClass("visited");
	});
	
	//确认自取日期
	$("#confirmTakeDate").click(function(){
		var takeDateValue = $("#takeDiv li.visited").find(":hidden").val();
		var takeWeekValue = $("#takeDiv li.visited").find("span").html();
		$("#takeDiv").hide();
		$(".mask-index").hide();
		$("#takeDate").val(takeDateValue);
		$("#divTakeInfo p:first").html("自提时间： "+takeDateValue.substring(5,10)+"["+takeWeekValue+"] "+$("#openTime").val());
	});
	
	//选择送货地址
	$("ul.message").on("click","li:not(.disabled-me)",function(){
		$("ul.message li.active").removeClass("active");
		$(this).addClass("active");
		$("#addressId").val($(this).find("[name='userAddressId']").val());
	});
	
	//单行删除
	$("ul.message").on("click","[name='delAddress']",function(){
		var delAddress = $(this);
		var mark = false;
 		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../address/delete/"+delAddress.parent().parent().find("[name='userAddressId']").val(),
	        success: function(data) {
	        	if(data==200){
	        		//如果当前选择的地址被删除，选择第一个
	        		if(delAddress.parent().parent().hasClass("active")){
	        			mark = true;
	        		}
	        		delAddress.parent().parent().next("div").remove();
	        		delAddress.parent().parent().remove();

	        		if(mark){
	        			$("ul.message li:not(.disabled-me):first").addClass("active");
	        			$("#addressId").val($("ul.message li.active").find("[name='userAddressId']").val());
	        		}
	        		//全部删除
	        		if($("ul.message").children("li:not(.disabled-me)").length==0 ){
	        			$("#addressId").val("");
	        			//送货上门
	        			if($("#sendStyle").val()==0){
		        			//提交按钮
	        				$("#btnAddOrder").removeClass("btn-warning");
	        				$("#btnAddOrder").addClass("btn-disabled");
	        				$("#btnAddOrder").prop("disabled",true);
	        			}
	        		}
	        		//收货校验提示
					$("#addressAlert").hide();
	        	}
	        },  
	        error: function(data) {  
	            //alert(data);  
	        }  
	    })  ;  
	});
	
	//新增收货地址显示
	$("#addAddress1,#addAddress2").click(function(){
		//限制收货地址条数
		if($("ul.message").children("li").length<15){
			$(".mask-index").show();
			$("#addressAddDiv").show();
			//校验提示
			$("#addressAlert").hide();
		}else{
			//校验提示
			$("#addressAlert").show();
		}
	});
	
	//新增收货地址
	$("#confirmAddAddress").click(function(){
		//校验
		if(!validateAddress($("#addressAddDiv"))){
			return false;
		}
		//确定按钮
		$("#confirmAddAddress").removeClass("btn-warning");
		$("#confirmAddAddress").addClass("btn-disabled");
		$("#confirmAddAddress").prop("disabled",true);
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../address/add",
	        data: $("#addressAddForm").serialize(),
	        success: function(data) {
	        	if(data.code==200){
	        		//确定按钮
	        		$("#confirmAddAddress").removeClass("btn-disabled");
	        		$("#confirmAddAddress").addClass("btn-warning");
	        		$("#confirmAddAddress").prop("disabled",false);
	        		$("#addressAddDiv").hide();
	        		$(".mask-index").hide();
	        		//原选择去除
	        		$("ul.message li.active").removeClass("active");
	        		$("#addressId").val(data.orgUserAddress.addressId);
	        		//添加新收货地址
	        		$("ul.message").prepend(
	        			"<li class='active'>"+
	        			"<input type='hidden' name='userAddressId' value='"+data.orgUserAddress.addressId+"'/>"+
	        			"<div class='add-nameall a-l'>"+
	        			"<span>"+data.orgUserAddress.addressName+"</span>"+
	        			"</div>"+
	        			"<div class='add-name a-l'>"+
	        			"<span>"+data.orgUserAddress.consignee+"</span>"+
	        			"</div>"+
	        			"<div class='add-phone a-l'>"+
	        			"<span>"+((data.orgUserAddress.mobile!='')?data.orgUserAddress.mobile:data.orgUserAddress.telAreaCode+'-'+data.orgUserAddress.tel)+"</span>"+
	        			"</div>"+
	        			"<div class='add-detail a-l'>"+
	        			"<span style='text-overflow:ellipsis'>"+data.orgUserAddress.areaShow+" "+data.orgUserAddress.sendRangeName+data.orgUserAddress.address+"</span>"+
	        			"</div>"+
	        			"<div class='add-right a-r'>"+
	        			"<a href='javascript:void(0);' name='delAddress'>删除</a>"+
	        			"<a href='javascript:void(0);' name='editAddress'>编辑</a>"+
	        			"</div>"+
	        			"</li>"
	        		); 
	        		//提交按钮
	        		if($("#sendDate").val() != ''){
	        			$("#btnAddOrder").removeClass("btn-disabled");
	    				$("#btnAddOrder").addClass("btn-warning");
	    				$("#btnAddOrder").prop("disabled",false);
	        		}
    				//清空内容
	        		$("#addressAddDiv [name='consignee']").val("");
	        		$("#addressAddDiv [name='sendRangeId']").val("-1");
	        		$("#addressAddDiv [name='address']").val("");
	        		$("#addressAddDiv [name='mobile']").val("");
	        		$("#addressAddDiv [name='telAreaCode']").val("");
	        		$("#addressAddDiv [name='tel']").val("");
	        		$("#addressAddDiv [name='email']").val("");
	        	}
	        },  
	        error: function(data) {  
	        	//确定按钮
        		$("#confirmAddAddress").removeClass("btn-disabled");
        		$("#confirmAddAddress").addClass("btn-warning");
        		$("#confirmAddAddress").prop("disabled",false);
	        }  
	    })  ;  
	});
	
	//编辑收货地址
	$("ul.message").on("click","[name='editAddress']",function(){
		var addressId = $(this).parent().parent().find("[name='userAddressId']").val();
		$(".mask-index").show();
		//获取收货地址信息
 		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../address/editInit/"+addressId,
	        success: function(data) {
	        	if(data.code==200){
	        		var addressData = data.orgUserAddress;
	        		$("#editAddressId").val(addressData.addressId);
	        		$("#consignee").val(addressData.consignee);
	        		$("#address").val(addressData.address);
	        		$("#mobile").val(addressData.mobile);
	        		$("#telAreaCode").val(addressData.tel_area_code);
	        		$("#tel").val(addressData.tel);
	        		$("#email").val(addressData.email);
	        		var shop = '';
	        		shop += "<select disabled='disabled'> class='nouse'";
	        		shop += "<option>"+addressData.area[0]+"</option>";
	        		shop += "</select>";
    				shop += "<select disabled='disabled'> class='nouse'";
    				shop += "<option>"+addressData.area[1]+"</option>";
   					shop += "</select>";
 					shop += "<select disabled='disabled'> class='nouse'";
 					shop += "<option>"+addressData.area[2]+"</option>";
	        		shop += "</select>";
	        		shop += "<select disabled='disabled'> class='nouse'";
	        		shop += "<option>"+addressData.shopName+"</option>";
	        		shop += "</select>";
	        		$("#shopName").html(shop);
	        		var rangeList = "<option value='-1'>请选择</option>";
	                $.each(addressData.listSendRange,function(idx, obj){
	                	if(obj.id==addressData.sendRangeId){
	                		rangeList += ("<option selected='selected' value='"+obj.id+"'>"+obj.sendRangeName+"</option>");
	                	}else{
	                		rangeList += ("<option value='"+obj.id+"'>"+obj.sendRangeName+"</option>");
	                	}
	                }); 
	                $("#sendRangeId").html(rangeList);
	        		$("#addressEditDiv").show();
	        	}
	        },  
	        error: function(data) {  
	            //alert(data);  
	        	$(".mask-index").hide();
	        }  
	    })  ;  
	});
	
	//编辑收货地址保存
	$("#confirmEditAddress").click(function(){
		//校验
		if(!validateAddress($("#addressEditDiv"))){
			return false;
		}
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../address/edit",
	        data: $("#addressEditForm").serialize(),
	        success: function(data) {
	        	if(data.code==200){
	        		var addressData = data.orgUserAddress;
	        		$("#addressEditDiv").hide();
	        		$(".mask-index").hide();
	        		//替换内容
	        		$("ul.message :hidden[name='userAddressId'][value='"+addressData.addressId+"']").parent().html(
	        			"<input type='hidden' name='userAddressId' value='"+addressData.addressId+"'/>"+
	        			"<div class='add-nameall a-l'>"+
	        			"<span>"+addressData.addressName+"</span>"+
	        			"</div>"+
	        			"<div class='add-name a-l'>"+
	        			"<span>"+addressData.consignee+"</span>"+
	        			"</div>"+
	        			"<div class='add-phone a-l'>"+
	        			"<span>"+((addressData.mobile!='')?addressData.mobile:addressData.telAreaCode+'-'+addressData.tel)+"</span>"+
	        			"</div>"+
	        			"<div class='add-detail a-l'>"+
	        			"<span style='text-overflow:ellipsis'>"+addressData.areaShow+" "+addressData.sendRangeName+addressData.address+"</span>"+
	        			"</div>"+
	        			"<div class='add-right a-r'>"+
	        			"<a href='javascript:void(0);' name='delAddress'>删除</a>"+
	        			"<a href='javascript:void(0);' name='editAddress'>编辑</a>"+
	        			"</div>"
		        	); 
	        		//如果是本店失效的地址改为有效
	        		if(addressData.shopId==$("#shopId").val()){
	        			$("ul.message :hidden[name='userAddressId'][value='"+addressData.addressId+"']").parents("li").next("div").remove();
	        			$("ul.message :hidden[name='userAddressId'][value='"+addressData.addressId+"']").parent().removeClass("disabled-me");
	        			//如果原来没有有效地址，选择当前项
	        			if($("ul.message").children("li.active").length==0 ){
	        				$("ul.message :hidden[name='userAddressId'][value='"+addressData.addressId+"']").parent().addClass("active");
	        				$("#addressId").val(addressData.addressId);
	        				if($("#sendDate").val() != ''){
		        				$("#btnAddOrder").removeClass("btn-disabled");
		        				$("#btnAddOrder").addClass("btn-warning");
		        				$("#btnAddOrder").prop("disabled",false);
	        				}
	        			}
	        		}
	        	}
	        },  
	        error: function(data) {  
	            //alert(data);  
	        }  
	    })  ;  
	});
	
	//发票
	$("#updateInvoice").click(function(){
		$(".revise2").hide();
		$(".revisepaper").show();
	});
	
	$("#confirmInvoice").click(function(){
		if($("#invoice").val() == '' || $("#invoice").val().length >50){
			$("#invoice").val($("#textInvoice").html());
		}else{
			$("#textInvoice").html($("#invoice").val());
		}
		$(".revisepaper").hide();
		$(".revise2").show();

	});
	
	$("#cancelInvoice").click(function(){
		$("#invoice").val($("#textInvoice").html());
		$(".revisepaper").hide();
		$(".revise2").show();
	});
	
	//优惠券切换
	$("#couponRecordId").change(function(){
		var record= $("#couponRecordId :selected");
		$("#couponRecordId").html();
		if(record.val() == 0){
			$("#emCoupon").html("￥-0.00");
			$(".addpay-gray").html("");
		}else{
			$("#emCoupon").html("￥-"+parseFloat(record.attr("data-discount-money")).toFixed(2));
			var couponHtml = "满";
			couponHtml += record.attr("data-condition-money");
			couponHtml += "元减";
			couponHtml += record.attr("data-discount-money");
			couponHtml += "元有限期至";
			couponHtml += record.attr("data-end-time");
			if(record.attr("data-product-type")==1){
				couponHtml += "可购买全场商品";
			}else if(record.attr("data-product-type")==2){
				couponHtml += "可购买指定分类";
			}else if(record.attr("data-product-type")==3){
				couponHtml += "可购买指定商品";
			}
			$(".addpay-gray").html(couponHtml);
		}
		$("#spCoupon").html("￥"+parseFloat(record.attr("data-discount-money")).toFixed(2));

		//余额支付金额
		if(parseFloat($("#canUseAmount").val()) >= parseFloat($("#orderMoney").val()-record.attr("data-discount-money"))){
			$("#depositMoney").val(parseFloat($("#orderMoney").val()-record.attr("data-discount-money")).toFixed(2));
		}else{
			$("#depositMoney").val(parseFloat($("#canUseAmount").val()).toFixed(2));
		}
		$("#labelDepositMoney").html("使用余额支付"+$("#depositMoney").val()+"元");
		//订单金额
		if($("#useDeposit").prop("checked")){
			$("#spDepositMoney").html("￥"+parseFloat($("#depositMoney").val()).toFixed(2));
			$("#spPay").html("￥"+parseFloat($("#orderMoney").val()-record.attr("data-discount-money")-$("#depositMoney").val()).toFixed(2));
			if($("#orderMoney").val()*100-$("#couponRecordId :selected").attr("data-discount-money")*100-$("#depositMoney").val()*100 == 0){
				$(".ready-pay-sumbit").show();
			}else{
				$(".ready-pay-sumbit").hide();
			}
		}else{
			$("#spPay").html("￥"+parseFloat($("#orderMoney").val()-record.attr("data-discount-money")).toFixed(2));

		}
	});
	
	$("#btnAddOrder").click(function(){
		
		//禁用按钮
		$("#btnAddOrder").prop("disabled",true);
		$("#btnAddOrder").addClass("btn-disabled");
		$("#btnAddOrder").removeClass("btn-warning");
		$(".mask-index").show();
		
		if($("#sendStyle").val()==1){
			//自提电话
			if($("[name='consigneeMobile']").val() == ''){
				
				$("#consigneeMobileAlert").html("手机号不能为空！").show();
				$("[name='consigneeMobile']").focus();
				if($("#sendDate").val() != ''){
					$("#btnAddOrder").removeClass("btn-disabled");
					$("#btnAddOrder").addClass("btn-warning");
					$("#btnAddOrder").prop("disabled",false);
				}
				$(".mask-index").hide();
				return false;
			}
			
			if(!isMobile($("[name='consigneeMobile']").val())){
				
				$("#consigneeMobileAlert").html("手机号格式错误！").show();
				$("[name='consigneeMobile']").focus();
				if($("#sendDate").val() != ''){
					$("#btnAddOrder").removeClass("btn-disabled");
					$("#btnAddOrder").addClass("btn-warning");
					$("#btnAddOrder").prop("disabled",false);
				}
				$(".mask-index").hide();
				return false;
			}
			
		}
		
		//余额密码
		if($("#useDeposit").prop("checked")
				&& $("#orderMoney").val()*100-$("#couponRecordId :selected").attr("data-discount-money")*100-$("#depositMoney").val()*100 == 0){
			$("#infoPassword").empty();
			if($("#depositPassword").val()==''){
				$("#infoPassword").html("密码不能为空");
				if($("#sendDate").val() != ''){
					$("#btnAddOrder").removeClass("btn-disabled");
					$("#btnAddOrder").addClass("btn-warning");
					$("#btnAddOrder").prop("disabled",false);
				}
				$(".mask-index").hide();
				return false;
			}
			if($("#depositPassword").val().length != 6){
				$("#infoPassword").html("密码为6位数字");
				if($("#sendDate").val() != ''){
					$("#btnAddOrder").removeClass("btn-disabled");
					$("#btnAddOrder").addClass("btn-warning");
					$("#btnAddOrder").prop("disabled",false);
				}
				$(".mask-index").hide();
				return false;
			}
			if(!isNumber($("#depositPassword").val())){
				$("#infoPassword").html("密码为6位数字");
				if($("#sendDate").val() != ''){
					$("#btnAddOrder").removeClass("btn-disabled");
					$("#btnAddOrder").addClass("btn-warning");
					$("#btnAddOrder").prop("disabled",false);
				}
				$(".mask-index").hide();
				return false;
			}
		}else{
			$("#depositPassword").val("");
		}
		
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../order/add",
	        data: $("#orderForm").serialize(),
	        success: function(data) {
	        	if(data.code == 200){
	        		if(data.onlinePay == true){
	        			location.href="../pay/payInit?orderId="+data.orderId;
	        		}else{
	        			location.href="../order/desc?orderId="+data.orderId;
	        		}
	        	}else if(data.code == 500){
	        		if(data.cart==true){
	        			$("#errorInfo .fadep2").html(data.desc);
	        			$("#errorInfo").show();
	        		}else{
	        			$(".mask-index").hide();
	        			$("#infoPassword").html(data.desc);
	        			$("#depositPassword").val("");
	        			$("#depositPassword").focus();
	        			if($("#sendDate").val() != ''){
	    					$("#btnAddOrder").removeClass("btn-disabled");
	    					$("#btnAddOrder").addClass("btn-warning");
	    					$("#btnAddOrder").prop("disabled",false);
	    				}
	        		}
	        	}else{
	        		if(data.cart==true){
	        			$("#errorInfo .fadep2").html(data.desc);
	        			$("#errorInfo").show();
	        		}
	        	}
	        },  
	        error: function(data) {  
	        }  
	    });
	});
	
	//余额支付
	$("#useDeposit").click(function(){
		if($("#useDeposit").prop("checked")){
			$("#spDepositMoney").html("￥"+parseFloat($("#depositMoney").val()).toFixed(2));
			$("#spPay").html("￥"+parseFloat(($("#orderMoney").val()*100-$("#couponRecordId :selected").attr("data-discount-money")*100-$("#depositMoney").val()*100)/100).toFixed(2));
			if($("#orderMoney").val()*100-$("#couponRecordId :selected").attr("data-discount-money")*100-$("#depositMoney").val()*100 == 0){
				$(".ready-pay-sumbit").show();
			}
		}else{
			$(".ready-pay-sumbit").hide();
			$("#spDepositMoney").html("￥0.00");
			$("#spPay").html("￥"+parseFloat($("#orderMoney").val()-$("#couponRecordId :selected").attr("data-discount-money")).toFixed(2));
		}
	});
	
});

function validateAddress(divAddress){
	//校验提示
	divAddress.find("b").hide();
	//收件人
	if(divAddress.find("[name='consignee']").val() == ''){
		divAddress.find("[name='consignee']").next().html("收件人不能为空！").show();
		divAddress.find("[name='consignee']").focus();
		return false;
	}
	
	if(divAddress.find("[name='consignee']").val().length>60){
		divAddress.find("[name='consignee']").next().html("收件人字数超出限制！").show();
		divAddress.find("[name='consignee']").focus();
		return false;
	}
	
	//配送范围
	if(divAddress.find("[name='sendRangeId']").val() == '-1'){
		divAddress.find("[name='address']").next().html("请选择配送地址！").show();
		divAddress.find("[name='sendRangeId']").focus();
		return false;
	}
	
	//收货地址
	if(divAddress.find("[name='address']").val() == ''){
		divAddress.find("[name='address']").next().html("收货地址不能为空！").show();
		divAddress.find("[name='address']").focus();
		return false;
	}
	
	if(divAddress.find("[name='address']").val().length>80){
		divAddress.find("[name='address']").next().html("收货地址字数超出限制！").show();
		divAddress.find("[name='address']").focus();
		return false;
	}
	
	//电话
	if(divAddress.find("[name='mobile']").val() == '' && divAddress.find("[name='telAreaCode']").val() == '' && divAddress.find("[name='tel']").val() == ''){
		
		divAddress.find("[name='tel']").next().html("手机号不能为空！").show();
		divAddress.find("[name='mobile']").focus();
		return false;
	}
	
	if( divAddress.find("[name='telAreaCode']").val() != '' && divAddress.find("[name='tel']").val() == ''){
		
		divAddress.find("[name='tel']").next().html("座机号不能为空！").show();
		divAddress.find("[name='tel']").focus();
		return false;
	}else if( divAddress.find("[name='telAreaCode']").val() == '' && divAddress.find("[name='tel']").val() != ''){
		divAddress.find("[name='tel']").next().html("区号不能为空！").show();
		divAddress.find("[name='telAreaCode']").focus();
		return false;
	}
	
	if(divAddress.find("[name='mobile']").val() != '' && !isMobile(divAddress.find("[name='mobile']").val())){
		divAddress.find("[name='tel']").next().html("手机号格式错误！").show();
		divAddress.find("[name='mobile']").focus();
		return false;
	}
	
	if(divAddress.find("[name='telAreaCode']").val() != '' && !isTelAreaCode(divAddress.find("[name='telAreaCode']").val())){
		divAddress.find("[name='tel']").next().html("区号格式错误！").show();
		divAddress.find("[name='telAreaCode']").focus();
		return false;
	}
	
	if(divAddress.find("[name='tel']").val() != '' && !isTel(divAddress.find("[name='tel']").val())){
		divAddress.find("[name='tel']").next().html("座机号格式错误！").show();
		divAddress.find("[name='tel']").focus();
		return false;
	}
	
	if(divAddress.find("[name='email']").val() != '' && (divAddress.find("[name='email']").val().length >60 ||!isEmail(divAddress.find("[name='email']").val()))){
		divAddress.find("[name='email']").next().html("邮箱格式错误！").show();
		divAddress.find("[name='email']").focus();
		return false;
	}
	
	return true;
}