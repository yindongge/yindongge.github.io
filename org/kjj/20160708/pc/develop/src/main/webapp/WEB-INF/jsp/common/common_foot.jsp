<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="well">
	<div class="container">
		<div class="row" id="foot">
		</div>
		<div class="copyright">
			<p>
				京ICP备：15042945号-1  |  京公网安备：11010502027313  | 
				<a href="${ctx}/html/license/businessICPLicense.html" target="_blank" style="color: #999;">京ICP证160185号</a> |  
				<a href="${ctx}/html/license/foodBusinessLicenses.html" target="_blank" style="color:#999">食品经营许可证</a>  |  
				<a href="${ctx}/html/license/businesslicense.html" target="_blank" style="color:#999">营业执照</a> 统一社会信用代码：91110105344398147M  |  
				客服热线：4000-306-603
			</p>
			<p>Copyright @ 2015-2016　北京快捷健电子商务有限公司Kjjhome.com 版权所有　地址：北京市朝阳区建国门外大街永安东里8号15层1501B室</p>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function () {
	load();
});

function load(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "${ctx}/foot",
        success: function(data) {
        	if(data.code==200){
       			var divHtml = "";
        		$.each(data.listArticleClass,function(idx, obj){
        			divHtml += "<div class=\"col-md-2 \">";
        			divHtml += "<div class=\"thumbnail\">	";
        			divHtml += "<img src='${imgBase}/icon/icon1"+(idx+1)+".png' />";
        			divHtml += "<div class=\"caption\">	";
        			divHtml += "<h5>"+obj.className+"</h5>	";
        			$.each(obj.listArticle,function(i, o){
        				if(o.content ==''||o.content==null){
        					divHtml += "<p><a target=\"_blank\" href='"+o.url+"'>"+o.title+"</a></p>	";
        				}else{
        					divHtml += "<p><a target=\"_blank\" href='${ctx}/article/dispatcher/"+o.id+"'>"+o.title+"</a></p>	";
        				}
        			});
        			divHtml+="</div>";
        			divHtml+="</div></div>";
	            }); 
        		$("#foot").append(divHtml);
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}
</script>