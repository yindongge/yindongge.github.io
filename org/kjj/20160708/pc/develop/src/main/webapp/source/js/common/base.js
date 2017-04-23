/*===========================
 *作者：动力启航(谢凯)
 *网址：http://www.it134.cn
 *转发请保留作者信息，谢谢
===========================*/

//=====================全局函数========================
//Tab控制函数
// function tabs(tabId, tabNum){
// 	//设置点击后的切换样式
// 	$(tabId + " .tab li").removeClass("curr");
// 	$(tabId + " .tab li").eq(tabNum).addClass("curr");
// 	//根据参数决定显示内容
// 	$(tabId + " .tabcon").hide();
// 	$(tabId + " .tabcon").eq(tabNum).show();
// }
//=====================全局函数========================

//==================图片详细页函数=====================
//鼠标经过预览图片函数
function preview(img){
	$("#preview .jqzoom img").attr("src",$(img).attr("src"));
	$("#preview .jqzoom img").attr("jqimg",$(img).attr("bimg"));
}

//图片放大镜效果
$(function(){
	$(".jqzoom").jqueryzoom({xzoom:350,yzoom:350});
});


jQuery.cookie = function(name, value, options) {   
    if (typeof value != 'undefined') { // name and value given, set cookie  
        options = options || {};  
        if (value === null) {  
            value = '';  
            options.expires = -1;  
        }  
        var expires = '';  
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {  
            var date;  
            if (typeof options.expires == 'number') {  
                date = new Date();  
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));  
            } else {  
                date = options.expires;  
            }  
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE  
        }  
        // CAUTION: Needed to parenthesize options.path and options.domain  
        // in the following expressions, otherwise they evaluate to undefined  
        // in the packed version for some reason...  
        var path = options.path ? '; path=' + (options.path) : '';  
        var domain = options.domain ? '; domain=' + (options.domain) : '';  
        var secure = options.secure ? '; secure' : '';    
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');  
    } else { // only name given, get cookie  
        var cookieValue = null;  
        if (document.cookie && document.cookie != '') {  
            var cookies = document.cookie.split(';');  
            for (var i = 0; i < cookies.length; i++) {  
                var cookie = jQuery.trim(cookies[i]);  
                // Does this cookie string begin with the name we want?  
                if (cookie.substring(0, name.length + 1) == (name + '=')) {  
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));  
                    break;  
                }  
            }  
        }  
        return cookieValue;  
    }  
};  

//用户添加

//图片预览小图移动效果,页面加载时触发
// $(function(){
// 	// var tempLength = 0; //临时变量,当前移动的长度
// 	// var viewNum = 5; //设置每次显示图片的个数量
// 	// var moveNum = 2; //每次移动的数量
// 	// var moveTime = 300; //移动速度,毫秒
// 	// var scrollDiv = $(".spec-scroll .items ul"); //进行移动动画的容器
// 	// var scrollItems = $(".spec-scroll .items ul li"); //移动容器里的集合
// 	// var moveLength = scrollItems.eq(0).width() * moveNum; //计算每次移动的长度
// 	// var countLength = (scrollItems.length - viewNum) * scrollItems.eq(0).width(); //计算总长度,总个数*单个长度
	  
// 	//下一张
// 	$(".spec-scroll .next").bind("click",function(){
// 		if(tempLength < countLength){
// 			if((countLength - tempLength) > moveLength){
// 				scrollDiv.animate({left:"-=" + moveLength + "px"}, moveTime);
// 				tempLength += moveLength;
// 			}else{
// 				scrollDiv.animate({left:"-=" + (countLength - tempLength) + "px"}, moveTime);
// 				tempLength += (countLength - tempLength);
// 			}
// 		}
// 	});
// 	//上一张
// 	$(".spec-scroll .prev").bind("click",function(){
// 		if(tempLength > 0){
// 			if(tempLength > moveLength){
// 				scrollDiv.animate({left: "+=" + moveLength + "px"}, moveTime);
// 				tempLength -= moveLength;
// 			}else{
// 				scrollDiv.animate({left: "+=" + tempLength + "px"}, moveTime);
// 				tempLength = 0;
// 			}
// 		}
// 	});
// });
// //==================图片详细页函数=====================