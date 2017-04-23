$(function () {
	$("#invoiceYes").click(function(){					
		$(this).addClass("on");
		$("#invoiceNo").removeClass("on");
		$(this).parents(".paper").removeClass("gray");
	});
	$("#invoiceNo").click(function(){					
		$(this).addClass("on");
		$("#invoiceYes").removeClass("on");
		$(this).parents(".paper").addClass("gray");
	});
	$("#spanPerson").click(function(){					
		$(this).addClass("on");
		$("#spanCompany").removeClass("on");
	});
	$("#spanCompany").click(function(){					
		$(this).addClass("on");
		$("#spanPerson").removeClass("on");
		$("#textCompany").focus();
	});
	$("#textCompany").focus(function(){					
		$("#spanCompany").addClass("on");
		$("#spanPerson").removeClass("on");
	});
	
	$("#btnConfirm").click(function(){
		var invoice = "";
		if($("#invoiceYes").is(".on")){
			if($("#spanCompany").is(".on")){
				var textCompany = $("#textCompany").val();
				if(textCompany == ''){
					alert("请填写公司名称");
					return false;
				}else{
					invoice = textCompany;
				}
			}else{
				invoice = "个人";
			}
			location.href="../order/addReInit?takeInvoice=true&invoice="+invoice;
		}else{
			location.href="../order/addReInit?takeInvoice=false";
		}
	});
});
