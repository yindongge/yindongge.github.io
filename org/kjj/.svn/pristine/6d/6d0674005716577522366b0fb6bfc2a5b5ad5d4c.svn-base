<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
			<header class="header">
				<div class="logo fl">
					<a href="${ctx}"><img src="${imgBase}/logo.png"></a>
					<span class="shop_name">${shop.shopName}</span>
				</div>
				<div class="search fl">
					<div class="search-form">
						<input type="text" class="text1" name="keyword" id="keyword" value="${query.keyword}" placeholder="开始搜索">
						<span class="search-icon"></span>
						<span class="search-icon2" >
							<div id="tip" style="display:none">
								<img src="${imgBase}/tip3.png"  alt="" />
								<input type="text"  class="text_bling"  />
							</div>
						</span>
						<a href="#" class="search-button">搜索</a>
						<a href="" class="search-help">新手帮助</a>
					</div>
					<c:if test="${not empty kjjuser.orgShop.shopSearch}">
					<div class="search-classfiy">
						<span class="c_head">热门搜索：</span>
						<c:forEach items="${fn:split(kjjuser.orgShop.shopSearch, ',')}" var="keyword">
			    		<span><a class="link" href="${ctx}/search/result?keyword=${keyword}">${keyword}</a></span>
			    		</c:forEach>
					</div>
					</c:if>
				</div>
				<div class="search-right">
					<div class="tel"><img src="${imgBase}/tel.png" alt="" /></div>
					<div class="erwei">
						<img src="${imgBase}/erweima.png" alt="" />
						<span>关注快捷健</span>
					</div>
				</div>
				<%@include file="../home/softkey.jsp" %>
			</header> 
<script type="text/javascript">
	$(function(){
		$(".search-icon2").on('click',function(){
			if($("#tip").is(":hidden")){
				$("#tip").show();
				$("#tip").find(':text').focus();
			}else {
				$("#tip").hide();
				$("#tip").find(':text').val('');
			}
		});
		
		$(".search-button").on('click',function(){
			var	keyword = $("input[name='keyword']").val();
			location.href='${ctx}/search/result?keyword='+keyword;
		});
		$("#tip").find(':text').on("blur",function(){
			$("#tip").hide();
			$("#tip").find(':text').val('');
		}); 
		
		$("#tip").find(':text').on('input',function(){
			var barcode=$(this).val();
			if(barcode==""){
				return false;
			}
		    if(!isNumber(barcode)){
				alert("条形码格式不正确，请重新扫描！");
				$(this).val('');
				$(this).focus();
				return false;
		    }
		    $.ajax({
			    type: "post",  
			    dataType:"json", 
			    url: "${ctx}/search/queryByBarcode",  
			    data:  {'barcode':barcode},
			    success: function(data) {
			       if(data.code==200){
			       		location.href="${ctx}/item/"+data.goodsId;
			       }else{
			        	alert("对不起，没有查询到您扫描的商品条码！");	
			       }
			    },
			    error:function(){
			    	alert('err');
			    }
			});
		});
		
	});
</script>