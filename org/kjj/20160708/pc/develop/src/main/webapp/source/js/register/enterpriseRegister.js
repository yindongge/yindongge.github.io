$(function(){
	//区域省下拉列表选择变更
	$("#provinceCode").change(function(){
		if($('#provinceCode').val() == -1){
			$('#cityCode').empty();
          	$('#cityCode').append("<option value='-1'>请选择市</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#provinceCode').val()},
	            success: function (data) {
	           	 $('#cityCode').empty();
	           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
	                $.each(data.listArea,function(idx, obj){
	               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
	                }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#countyCode').empty();
      	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == -1){
          	$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#cityCode').val()},
	            success: function (data) {
	            	$('#countyCode').empty();
	           	 	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	           	 	$.each(data.listArea,function(idx, obj){
                	$('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
                 }); 
	            },
	            error: function(data) {
	            }
	        });
		}
	});
	// 验证码显示
	$("#imgIdentifyCode").text("加载中...");
	$("#imgIdentifyCode").attr("src","../identifyEnterpriseRegCode");
	
	// 用户名获取焦点
	$("#userName").focus(function(){
		$("#userNameTip").empty();
		$("#userNamediv").removeClass("form-active1");
		$("#userNamediv").removeClass("form-active2");
		$("#userNameTip").removeClass("false");
		$("#userNameTip").append("4-20位字符，支持汉字、字母、数字及“-”、“_”组合");
    });
	$("#userName").blur(function(){
		if($("#userName").val() == "") { 
			$("#userNameTip").empty();
			$("#userNameTip").addClass("false");
			$("#userNamediv").addClass("form-active1");
			$("#userNameTip").append("请填写用户名！");
			failNum++;
			return false; 
		}
		if($("#userName").val() != ""){
			var userName = $("#userName").val();
			
			// 不允许全数字
			if(/^[0-9]+$/.test(userName)){
				$("#userNameTip").empty();
				$("#userNamediv").addClass("form-active1");
				$("#userNameTip").addClass("false");
				$("#userNameTip").append("用户名不能是纯数字，请重新输入！");
				failNum++;
				return false;
			}
			
			// 4-20位字符，支持汉字、字母、数字及“-”、“_”组合
			if(userName.length < 4 || !/^[A-Za-z0-9_\-\u4e00-\u9fa5]+$/.test(userName)){
				$("#userNameTip").empty();
				$("#userNamediv").addClass("form-active1");
				$("#userNameTip").addClass("false");
				$("#userNameTip").append("格式错误！");
				failNum++;
				return false;
			}
		}
		$("#userNameTip").empty();
		$("#userNamediv").removeClass("form-active1");
		$("#userNameTip").removeClass("false");
		$("#userNameTip").append("4-20位字符，支持汉字、字母、数字及“-”、“_”组合");
		
		$("#userNamediv").addClass("form-active2");
		
		$.ajax({  
	        type: "post",  
	        dataType:"json",
	        url: "../register/checkUser",
	        data: {'mobilePhone':$('#userName').val()},
	        success: function(data) {  
	           if(data!=200){
		   		   $("#userNameTip").empty();
		   		   $("#userNamediv").addClass("form-active1");
		   		   $("#userNameTip").addClass("false");
		   		   $("#userNameTip").append("该用户名已被使用，请重新输入。如果您是该用户，请立刻" + "<a href=\'../loginInit\' style=\'cursor:pointer\'>登录</a>");
		   		   userNameFail=true;
		   		   failNum++;
		   		   return false;
	           }else{
	        	   $("#userNameTip").empty();
	        	   $("#userNameTip").append("该用户名可以使用");
	           }
	           if(userNameFail==true){
	        	   userNameFail=false;
	           }
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    });
	});	
	$("#password").focus(function(){
		$("#passwordTip").empty();
		$("#passworddiv").removeClass("form-active1");
		$("#passworddiv").removeClass("form-active2");
		$("#passwordTip").removeClass("false");
		$("#passwordTip").append("6-20位字符，有字母数字下划线组成！");
    });
	$("#password").blur(function(){
		if($("#password").val() == "") { 
			$("#passwordTip").empty();
			$("#passwordTip").addClass("false");
			$("#passworddiv").addClass("form-active1");
			$("#passwordTip").append("请填写密码！");
			failNum++;
			return false; 
		}
		if($("#password").val() != ""){
			var value = $("#password").val();
			
			var weakPwds = ["123456", "123456789", "111111", "5201314",
			                "12345678", "123123", "password", "1314520", "123321",
			                "7758521", "1234567", "5211314", "666666", "520520",
			                "woaini", "520131", "11111111", "888888", "hotmail.com",
			                "112233", "123654", "654321", "1234567890", "a123456",
			                "88888888", "163.com", "000000", "yahoo.com.cn", "sohu.com",
			                "yahoo.cn", "111222tianya", "163.COM", "tom.com", "139.com",
			                "wangyut2", "pp.com", "yahoo.com", "147258369", "123123123",
			                "147258", "987654321", "100200", "zxcvbnm", "123456a",
			                "521521", "7758258", "111222", "110110", "1314521",
			                "11111111", "12345678", "a321654", "111111", "123123",
			                "5201314", "00000000", "q123456", "123123123", "aaaaaa",
			                "a123456789", "qq123456", "11112222", "woaini1314",
			                "a123123", "a111111", "123321", "a5201314", "z123456",
			                "liuchang", "a000000", "1314520", "asd123", "88888888",
			                "1234567890", "7758521", "1234567", "woaini520",
			                "147258369", "123456789a", "woaini123", "q1q1q1q1",
			                "a12345678", "qwe123", "123456q", "121212", "asdasd",
			                "999999", "1111111", "123698745", "137900", "159357",
			                "iloveyou", "222222", "31415926", "123456", "111111",
			                "123456789", "123123", "9958123", "woaini521", "5201314",
			                "18n28n24a5", "abc123", "password", "123qwe", "123456789",
			                "12345678", "11111111", "dearbook", "00000000", "123123123",
			                "1234567890", "88888888", "111111111", "147258369",
			                "987654321", "aaaaaaaa", "1111111111", "66666666",
			                "a123456789", "11223344", "1qaz2wsx", "xiazhili",
			                "789456123", "password", "87654321", "qqqqqqqq",
			                "000000000", "qwertyuiop", "qq123456", "iloveyou",
			                "31415926", "12344321", "0000000000", "asdfghjkl",
			                "1q2w3e4r", "123456abc", "0123456789", "123654789",
			                "12121212", "qazwsxedc", "abcd1234", "12341234",
			                "110110110", "asdasdasd", "123456", "22222222", "123321123",
			                "abc123456", "a12345678", "123456123", "a1234567",
			                "1234qwer", "qwertyui", "123456789a", "qq.com", "369369",
			                "163.com", "ohwe1zvq", "xiekai1121", "19860210", "1984130",
			                "81251310", "502058", "162534", "690929", "601445",
			                "1814325", "as1230", "zz123456", "280213676", "198773",
			                "4861111", "328658", "19890608", "198428", "880126",
			                "6516415", "111213", "195561", "780525", "6586123",
			                "caonima99", "168816", "123654987", "qq776491",
			                "hahabaobao", "198541", "540707", "leqing123", "5403693",
			                "123456", "123456789", "111111", "5201314", "123123",
			                "12345678", "1314520", "123321", "7758521", "1234567",
			                "5211314", "520520", "woaini", "520131", "666666",
			                "RAND#a#8", "hotmail.com", "112233", "123654", "888888",
			                "654321", "1234567890", "a123456"
			            ];
			var pwdStrength = {
		        1: {
		            reg: /^.*([\W_])+.*$/i,
		            msg: '有被盗风险,建议使用字母、数字和符号两种及以上组合'
		        },
		        2: {
		            reg: /^.*([a-zA-Z])+.*$/i,
		            msg: '安全强度适中，可以使用三种以上的组合来提高安全强度'
		        },
		        3: {
		            reg: /^.*([0-9])+.*$/i,
		            msg: '你的密码很安全'
		        }
		    };
			var level = 0;
	        var typeCount=0;
	        var flag = true;
	        var valueLength=getStringLength(value);
	        if (valueLength < 6) {
	        	$("#passwordTip").empty();
				$("#passwordTip").addClass("false");
				$("#passworddiv").addClass("form-active1");
				$("#passwordTip").append("密码长度只能在6-20位字符之间！");
				failNum++;
	            return false;
	        }
	        for (key in pwdStrength) {
	            if (pwdStrength[key].reg.test(value)) {
	                typeCount++;
	            }
	        }
	        if(typeCount==1){
	            if(valueLength>10){
	                level=2;
	            }else{
	                level=1;
	            }
	        }else if(typeCount==2){
	            if(valueLength<11&&valueLength>5){
	                level=2;
	            }
	            if(valueLength>10){
	                level=3;
	            }
	        }else if(typeCount==3){
	            if(valueLength>6){
	                level=3;
	            }
	        }
	        if ($.inArray(value, weakPwds) !== -1) {
	            // 有被盗风险,建议使用字母、数字和符号两种及以上组合
	        	$("#passwordTip").empty();
				$("#passwordTip").addClass("false");
				$("#passwordTip").append("有被盗风险,建议使用字母、数字和符号两种及以上组合！");
	        }
	        if (pwdStrength[level] !== undefined) {
	            pwdStrength[level]>3?pwdStrength[level]=3:pwdStrength[level];
	            $("#passwordTip").empty();
	            $("#passwordTip").append(pwdStrength[level].msg);
	        }
		}
		$("#passworddiv").addClass("form-active2");
	});
	// 确认密码
	$("#repassword").focus(function(){
		$("#repasswordTip").empty();
		$("#repassworddiv").removeClass("form-active1");
		$("#repassworddiv").removeClass("form-active2");
		$("#repasswordTip").removeClass("false");
    });
	$("#repassword").blur(function(){
		if($("#repassword").val() == "") { 
			$("#repasswordTip").empty();
			$("#repasswordTip").addClass("false");
			$("#repassworddiv").addClass("form-active1");
			$("#repasswordTip").append("请填写确认密码！");
			failNum++;
			return false; 
		}
		if($("#repassword").val() != ""){
			var value = $("#repassword").val();
			
			if($("#repassword").val() != $("#password").val()){
				$("#repasswordTip").empty();
				$("#repasswordTip").addClass("false");
				$("#repassworddiv").addClass("form-active1");
				$("#repasswordTip").append("两次输入密码不一致！");
				failNum++;
				return false;
			}
		}
		$("#repasswordTip").empty();
		$("#repassworddiv").removeClass("form-active1");
		$("#repasswordTip").removeClass("false");
		
		$("#repassworddiv").addClass("form-active2");
	});	
	// 公司名称
	$("#enterpriseName").focus(function(){
		$("#enterpriseNameTip").empty();
		$("#enterpriseNamediv").removeClass("form-active1");
		$("#enterpriseNamediv").removeClass("form-active2");
		$("#enterpriseNameTip").removeClass("false");
    });
	$("#enterpriseName").blur(function(){
		if($("#enterpriseName").val() == "") { 
			$("#enterpriseNameTip").empty();
			$("#enterpriseNameTip").addClass("false");
			$("#enterpriseNamediv").addClass("form-active1");
			$("#enterpriseNameTip").append("请填写公司名称！");
			failNum++;
			return false; 
		}
		
		if($("#enterpriseName").val().length < 4){
			$("#enterpriseNameTip").empty();
			$("#enterpriseNameTip").addClass("false");
			$("#enterpriseNamediv").addClass("form-active1");
			$("#enterpriseNameTip").append("公司名称长度只能在4-40位字符之间！");
			failNum++;
			return false;
		}

		$("#enterpriseNameTip").empty();
		$("#enterpriseNamediv").removeClass("form-active1");
		$("#enterpriseNameTip").removeClass("false");
		
		$("#enterpriseNamediv").addClass("form-active2");
		
		$.ajax({  
	        type: "post",  
	        dataType:"json",
	        url: "../register/checkEnterpriseName",
	        data: {'enterpriseName':$('#enterpriseName').val()},
	        success: function(data) {  
	           if(data!=200){
	        	   $("#enterpriseNameTip").empty();
	   			   $("#enterpriseNameTip").addClass("false");
	   			   $("#enterpriseNamediv").removeClass("form-active2");
	   			   $("#enterpriseNamediv").addClass("form-active1");
		   		   $("#enterpriseNameTip").append("该企业名称已被使用，请重新输入！");
		   		   enterpriseNameFail=true;
		   		   failNum++;
		   		   return false;
	           }else{
	        	   $("#enterpriseNameTip").empty();
	           }
	           if(enterpriseNameFail==true){
	        	   enterpriseNameFail=false;
	           }
	        },  
	        error: function(data) {  
	            alert(data);  
	        }
	    });
	});	
	// 区域
	$("#provinceCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#provinceCode").blur(function(){
		if($("#provinceCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	$("#cityCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#cityCode").blur(function(){
		if($("#cityCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	$("#countyCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#countyCode").blur(function(){
		if($("#countyCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	// 公司地址
	$("#address").focus(function(){
		$("#addressTip").empty();
		$("#addressdiv").removeClass("form-active1");
		$("#addressdiv").removeClass("form-active2");
		$("#addressTip").removeClass("false");
    });
	$("#address").blur(function(){
		if($("#address").val() == "") { 
			$("#addressTip").empty();
			$("#addressTip").addClass("false");
			$("#addressdiv").addClass("form-active1");
			$("#addressTip").append("请填写公司详细地址！");
			failNum++;
			return false; 
		}
		
		if($("#address").val().length < 4){
			$("#addressTip").empty();
			$("#addressTip").addClass("false");
			$("#addressdiv").addClass("form-active1");
			$("#addressTip").append("公司详细地址长度只能在4-50位字符之间！");
			failNum++;
			return false;
		}

		$("#addressTip").empty();
		$("#addressdiv").removeClass("form-active1");
		$("#addressTip").removeClass("false");
		
		$("#addressdiv").addClass("form-active2");
	});	
	// 联系人姓名
	$("#contactName").focus(function(){
		$("#contactNameTip").empty();
		$("#contactNamediv").removeClass("form-active1");
		$("#contactNamediv").removeClass("form-active2");
		$("#contactNameTip").removeClass("false");
    });
	$("#contactName").blur(function(){
		if($("#contactName").val() == "") { 
			$("#contactNameTip").empty();
			$("#contactNameTip").addClass("false");
			$("#contactNamediv").addClass("form-active1");
			$("#contactNameTip").append("请填写联系人姓名！");
			failNum++;
			return false; 
		}
		
		if($("#contactName").val().length < 2){
			$("#contactNameTip").empty();
			$("#contactNameTip").addClass("false");
			$("#contactNamediv").addClass("form-active1");
			$("#contactNameTip").append("联系人姓名长度只能在2-20位字符之间！");
			failNum++;
			return false;
		}

		$("#contactNameTip").empty();
		$("#contactNamediv").removeClass("form-active1");
		$("#contactNameTip").removeClass("false");
		
		$("#contactNamediv").addClass("form-active2");
	});	
	// 所在部门
	$("#department").focus(function(){
		$("#departmentTip").empty();
		$("#departmentdiv").removeClass("form-active1");
		$("#departmentdiv").removeClass("form-active2");
		$("#departmentTip").removeClass("false");
    });
	$("#department").blur(function(){
		if($("#department").val() == "-1") { 
			$("#departmentTip").empty();
			$("#departmentTip").addClass("false");
			$("#departmentdiv").addClass("form-active1");
			$("#departmentTip").append("请选择所在部门！");
			failNum++;
			return false; 
		}

		$("#departmentTip").empty();
		$("#departmentdiv").removeClass("form-active1");
		$("#departmentTip").removeClass("false");
	});
	// 固定电话
	$("#landlines").focus(function(){
		$("#landlinesTip").empty();
		$("#landlinesdiv").removeClass("form-active1");
		$("#landlinesdiv").removeClass("form-active2");
		$("#landlinesTip").removeClass("false");
    });
	$("#landlines").blur(function(){
		if($("#landlines").val() == "") { 
			$("#landlinesTip").empty();
			$("#landlinesTip").addClass("false");
			$("#landlinesdiv").addClass("form-active1");
			$("#landlinesTip").append("请填写固定电话！");
			failNum++;
			return false; 
		}
		
		if(!fixPhone($("#landlines").val())){
			$("#landlinesTip").empty();
			$("#landlinesTip").addClass("false");
			$("#landlinesdiv").addClass("form-active1");
			$("#landlinesTip").append("固定电话格式错误,例如 “010-67788656”");
			failNum++;
			return false;
		}

		$("#landlinesTip").empty();
		$("#landlinesdiv").removeClass("form-active1");
		$("#landlinesTip").removeClass("false");
		
		$("#landlinesdiv").addClass("form-active2");
	});	
	// 联系人邮箱
	$("#contactEmail").focus(function(){
		$("#contactEmailTip").empty();
		$("#contactEmaildiv").removeClass("form-active1");
		$("#contactEmaildiv").removeClass("form-active2");
		$("#contactEmailTip").removeClass("false");
    });
	$("#contactEmail").blur(function(){
		if($("#contactEmail").val() == "") { 
			$("#contactEmailTip").empty();
			$("#contactEmailTip").addClass("false");
			$("#contactEmaildiv").addClass("form-active1");
			$("#contactEmailTip").append("请填写联系人邮箱！");
			failNum++;
			return false; 
		}
		
		if(!isEmail($("#contactEmail").val())){
			$("#contactEmailTip").empty();
			$("#contactEmailTip").addClass("false");
			$("#contactEmaildiv").addClass("form-active1");
			$("#contactEmailTip").append("联系人邮箱格式错误！");
			failNum++;
			return false;
		}

		$("#contactEmailTip").empty();
		$("#contactEmaildiv").removeClass("form-active1");
		$("#contactEmailTip").removeClass("false");
		
		$("#contactEmaildiv").addClass("form-active2");
	});	
	// 验证手机
	$("#mobile").focus(function(){
		$("#mobileTip").empty();
		$("#mobilediv").removeClass("form-active1");
		$("#mobilediv").removeClass("form-active2");
		$("#mobileTip").removeClass("false");
    });
	$("#mobile").blur(function(){
		if($("#mobile").val() == "") { 
			$("#mobileTip").empty();
			$("#mobileTip").addClass("false");
			$("#mobilediv").addClass("form-active1");
			$("#mobileTip").append("请填写验证手机号！");
			failNum++;
			return false; 
		}
		if (!isMobile($("#mobile").val())){
			$("#mobileTip").empty();
			$("#mobilediv").addClass("form-active1");
			$("#mobileTip").addClass("false");
			$("#mobileTip").append("请填写正确的手机号！"); 
			failNum++;
			return false; 
		}

		$("#mobileTip").empty();
		$("#mobilediv").removeClass("form-active1");
		$("#mobileTip").removeClass("false");
		
		$("#mobilediv").addClass("form-active2");
	});	
	// 短信验证码
	$("#verifycode").focus(function(){
		$("#verifycodeTip").empty();
		$("#verifycodediv").removeClass("form-active1");
		$("#verifycodediv").removeClass("form-active2");
		$("#verifycodeTip").removeClass("false");
    });
	$("#verifycode").blur(function(){
		if($("#verifycode").val() == "") { 
			$("#verifycodeTip").empty();
			$("#verifycodeTip").addClass("false");
			$("#verifycodediv").addClass("form-active1");
			$("#verifycodeTip").append("请填写短信验证码！");
			failNum++;
			return false; 
		}
		if($("#verifycode").val().length < 4) { 
			$("#verifycodeTip").empty();
			$("#verifycodeTip").addClass("false");
			$("#verifycodediv").addClass("form-active1");
			$("#verifycodeTip").append("短信验证码格式不正确！");
			failNum++;
			return false;
		}
		$("#verifycodeTip").empty();
		$("#verifycodediv").removeClass("form-active1");
		$("#verifycodeTip").removeClass("false");
		
		$("#verifycodediv").addClass("form-active2");
	});	
	// 验证码
	$("#identifyCode").focus(function(){
		$("#identifyCodeTip").empty();
		$("#identifyCodediv").removeClass("form-active1");
		$("#identifyCodediv").removeClass("form-active2");
		$("#identifyCodeTip").removeClass("false");
    });
	$("#identifyCode").blur(function(){
		if($("#identifyCode").val() == "") { 
			$("#identifyCodeTip").empty();
			$("#identifyCodeTip").addClass("false");
			$("#identifyCodediv").addClass("form-active1");
			$("#identifyCodeTip").append("请填写验证码！");
			failNum++;
			return false; 
		}
		if($("#identifyCode").val().length < 4) { 
			$("#identifyCodeTip").empty();
			$("#identifyCodeTip").addClass("false");
			$("#identifyCodediv").addClass("form-active1");
			$("#identifyCodeTip").append("验证码格式不正确！");
			failNum++;
			return false;
		}
		$("#identifyCodeTip").empty();
		$("#identifyCodediv").removeClass("form-active1");
		$("#identifyCodeTip").removeClass("false");
		
		$("#identifyCodediv").addClass("form-active2");
	});	
});

function showprotocol(){
	$(".big").show();
	$(".login-mask").show();
}

function closeprotocol(){
	$(".big").hide();
	$(".login-mask").hide();
}

function closeprotocolagree(){
	$("input[type='checkbox']").prop("checked",true);
	//$("#protocol_").attr("checked",true);
	$(".big").hide();
	$(".login-mask").hide();
	
}
// 显示验证码
function changeIdentifyCode(){
	var timestamp = (new Date()).valueOf();
	$("#imgIdentifyCode").text("加载中。。。");
	$("#imgIdentifyCode").attr("src","../identifyEnterpriseRegCode?"+timestamp);
}
var runControl = false;
// 获取手机验证码
function sendMessage(o){
	if(runControl==true){
		return;
	}
	runControl = true;
	if ($("#mobile").val() == "") { 
		$("#mobileTip").empty();
		$("#mobilediv").addClass("form-active1");
		$("#mobileTip").append("请填写验证手机号！");
		$("#mobile").focus(); 
		runControl = false;
		return false; 
	} 
	if (!isMobile($("#mobile").val())){
		
		$("#mobileTip").empty();
		$("#mobilediv").addClass("form-active1");
		$("#mobileTip").addClass("false");
		$("#mobileTip").append("请填写正确的手机号！");	
		$("#mobile").focus(); 
		runControl = false;
		return false; 
	}
	$("#mobileTip").empty();
	$("#mobilediv").removeClass("form-active1");
	$("#mobileTip").removeClass("false");
	
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/sendRegisterCode",
        data: {'mobilePhone':$("#mobile").val()},
        success: function(data) {  
           if(data!=200){
           }else{
        	   time(o);
           }
           runControl = false;
        },  
        error: function(data) {  
        }  
    })  ;
}
var wait=60;
function time(o) {
    if (wait == 0) {
    	
    	$("#bsend").attr("disabled",false);
        //o.removeAttribute("disabled");  
        $("#bsend").text("免费获取验证码");
       // o.text="免费获取验证码";
        wait = 60;
    } else {
        //o.setAttribute("disabled", true);
        $("#bsend").attr("disabled",true);
        //o.text="重新发送(" + wait + ")";
        $("#bsend").text("重新发送  (" + wait + ")");
        wait--;
        setTimeout(function() {
            time(o);
        },
        1000);
    }
}
var failNum = 0;
var userNameFail = false; 
var enterpriseNameFail = false;
function regist(){
	if(userNameFail==true||enterpriseNameFail==true){
		return;
	}
	failNum = 0;
	validate();

	if(failNum > 0){
		return;
	}
	$("#mySubmit").attr("disabled",true);
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/enterpriseReg",
        data: $('#enterpriseAddForm').serialize(),
        success: function(data) {  
        	if(data.code != 200){
        		if(data.code==401){
					$("#verifycodeTip").empty();
					$("#verifycodeTip").addClass("false");
					$("#verifycodediv").addClass("form-active1");
					$("#verifycodeTip").append(data.desc);
        	    }else if(data.code==402){
        	    	$("#identifyCodeTip").empty();
        			$("#identifyCodeTip").addClass("false");
        			$("#identifyCodediv").addClass("form-active1");
        			$("#identifyCodeTip").append(data.desc);
        	    }
        		
            }else {
        	  location.href="../register/uploadQualification2?enterpriseId=" + data.enterpriseId;
            }
            $("#mySubmit").attr("disabled",false);
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
}
function validate(){
	if(!$("#protocol_").is(':checked')){
		showprotocol();
		return false;
	}
	$("#enterpriseName").blur();
	$("#userName").blur();
	$("#password").blur();
	$("#repassword").blur();
	$("#provinceCode").blur();
	$("#cityCode").blur();
	$("#countyCode").blur();
	$("#address").blur();
	$("#contactName").blur();
	$("#department").blur();
	$("#landlines").blur();
	$("#contactEmail").blur();
	$("#mobile").blur();
	$("#verifycode").blur();
	$("#identifyCode").blur();
	
	
}
function getStringLength(str){
    if(!str){
        return;
    }
    var bytesCount=0;
    for (var i = 0; i < str.length; i++)
    {
        var c = str.charAt(i);
        if (/^[\u0000-\u00ff]$/.test(c))
        {
            bytesCount += 1;
        }
        else
        {
            bytesCount += 2;
        }
    }
    return bytesCount;
}
// 固定电话验证
function fixPhone(value){
	var isFixPhone =/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
	return isFixPhone.test(value);
}