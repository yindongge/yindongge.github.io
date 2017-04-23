<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/common_css.jsp"%>
<link rel="stylesheet" type="text/css" href="${cssBase}/colorpicker/themes.css" />
<link rel="stylesheet" type="text/css" href="${cssBase}/colorpicker/showcase.css" />
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/colorpicker/colorpicker.min.js"></script>
<script type="text/javascript">
	function closewin(){
 		var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		parent.layer.close(index); //执行关闭 
	
	}
	$(function(){
    	$("#enterBtn").click(function(){ 
    		//获取父页面颜色块div的id
    		var colorDivIdOfParent = $("#colorDivId",window.parent.document).val();
    		//获取当前选中的颜色值
    		var colorNow = $("#hex").val();
    		//给父页面赋值
    		$("#value-"+colorDivIdOfParent,window.parent.document).val(colorNow);
    		$("#"+colorDivIdOfParent,window.parent.document).attr("style","background:"+colorNow+";");
    		closewin();
    	});      		
		
	});

</script>
</head>
    <body>
        <div id="container"  class="container">
        	<div class="row">
        		<div class="col-sm-7">
        			 <div id="small" class="cp cp-small"></div>
        		</div>
        		<div class="col-sm-5">
        			<div id="color"></div>
        		</div>
        	</div>
        
            <div class="text-center">
            	  <label>HEX</label>
            	<input id="hex" type="text" value="" />
            </div>
          <p class="text-center" style="margin-top:25px;">
          	<a role="button" class="btn btn-danger btn-sm" href="javascript:void(0);">取消</a>
          	<a role="button" class="btn btn-success btn-sm" href="javascript:void(0);" id="enterBtn">确定</a>
          </p>       
            <script src="${jsBase}/common/colorpicker/showcase.js"></script>
        </div>
    </body>
</html>
