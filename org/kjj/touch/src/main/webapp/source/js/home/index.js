var swiper = new Swiper('.footer .swiper-container', {
	direction: 'horizontal',
    pagination: '.footer .swiper-pagination',
    nextButton: '.footer .swiper-button-next',
    prevButton: '.footer .swiper-button-prev',
    slidesPerView: 3,
    slidesPerGroup : 1,
    paginationClickable: true,
    spaceBetween: 38,
    freeMode: true
});

	$(function(){
		existShopCookie();
		$("#searchBtn").on('click',function(){
			window.location.href = '${ctx}/product/list?shopId=3&keyword='+$("#keyword").val();
		});
		
	});

    //判断cookie中如果没有门店信息则弹出选择列表
    function existShopCookie(){
    	if(getCookie('shop') == null){
        	$.ajax({
        		url : 'getShopList',
        		type : 'post',
        		dataType : 'json',
        		success : function(data){
        			var html = '<div class="blackmask"></div>'+'<div class="showinfo">';
        			$(data).each(function(){
        				html += '<a href="javascript:void(0);" onclick="addCookieForShop('+this.shopId+');">'+this.shopName+'</a>';
        			});
        			html += '</div>';
        			$('body').append(html);
        		},
        		error:function(){
        			alert("err");
        		}
        	});
    	}
    }
    
    function addCookieForShop(shopId){
    	setCookie('shop',shopId);
    	var backurl=$('#kjjbackurl').val();
    	location.href=backurl;
    }
  //写cookies 
    function setCookie(name,value) 
    { 
        var Days = 30; 
        var exp = new Date(); 
        exp.setTime(exp.getTime() + Days*24*60*60*1000); 
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
    } 

    //读取cookies 
    function getCookie(name) 
    { 
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
     
        if(arr=document.cookie.match(reg))
     
            return unescape(arr[2]); 
        else 
            return null; 
    } 

    //删除cookies 
    function delCookie(name) 
    { 
        var exp = new Date(); 
        exp.setTime(exp.getTime() - 1); 
        var cval=getCookie(name); 
        if(cval!=null) 
            document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
    }
