$(function () {
	
});
/*
 * 设置一体化折扣生效
 */
function setActive(couponId){
	if(!confirm("确定设置有效？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../levelprice/updateCouponActive?couponId=" + couponId,
        success: function(data) {  
        	if(data.code==200){
        		 alert("设置成功!");
        		 window.location.href="../levelprice/levelcoupon";
        	}else{
        		alert("设置失败!");
        	}
        },  
        error: function(data) {  
            alert("操作失败，请联系管理员或技术人员!");  
        }  
    });
}

/*
 * 设置一体化折扣无效
 */
function setNoActive(couponId){
	if(!confirm("确定设置无效？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../levelprice/updateCouponNoActive?couponId=" + couponId,
        success: function(data) {  
        	if(data.code==200){
        		 alert("设置成功!");
        		 window.location.href="../levelprice/levelcoupon";
        	}else{
        		alert("设置失败!");
        	}
        },  
        error: function(data) {  
            alert("操作失败，请联系管理员或技术人员!");  
        }  
    });
}

/*
 * 查看商品和折扣信息
 */
function queryGoodsLevel(goods_sn){
	layer.open({
	    type: 2,
	    title: '查看商品及折扣信息',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['800px', '450px'],
	    content: '../levelprice/queryGoodsLevel?goodsSn=' + goods_sn
	}); 
}

function updateLevelCoupon(couponId){
	window.location.href="../levelprice/findLevelCoupon?levelCouponId=" + couponId;
}
function deleteLevelCoupon(couponId){
	if(!confirm("确定删除折扣？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../levelprice/deleteLevelCoupon?couponId=" + couponId,
        success: function(data) {  
        	if(data.code==200){
        		 alert("删除成功!");
        		 window.location.href="../levelprice/levelcoupon";
        	}else{
        		alert("删除失败!");
        	}
        },  
        error: function(data) {  
            alert("操作失败，请联系管理员或技术人员!");  
        }  
    });
}

function addLevelCoupon(){
	window.location.href="../levelprice/addLeveCoupon";
}