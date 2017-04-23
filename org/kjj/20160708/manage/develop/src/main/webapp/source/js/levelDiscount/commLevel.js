$(function () {
	/*
	$("#autoBigImg").mouseover(function(e){
		this.css({
			"width": 100 + "px",
			"height":  100  + "px"
		}).show("fast");
		alert('b');
	}).mouseout(function(){
		this.css({
			"width": 40 + "px",
			"height":  40  + "px"
		}).show("fast");
		alert('s');
	});*/
	
});
/*
 * 设置一体化折扣生效
 */
function setActive(goods_id){
	if(!confirm("确定设置有效？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../levelprice/updateActive?goodsId=" + goods_id,
        success: function(data) {  
        	if(data.code==200){
        		 alert("设置成功!");
        		 window.location.href="../levelprice/commlevel";
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
function setNoActive(id){
	if(!confirm("确定设置无效？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../levelprice/updateNoActive?id=" + id,
        success: function(data) {  
        	if(data.code==200){
        		 alert("设置成功!");
        		 window.location.href="../levelprice/commlevel";
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