<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>订单管理</title>
</head>
<body>
<div class="page-wrapper goods-control">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">数据</a></li>
			<li class="active">订单统计</li>
		</ul>
		<div class="well well-control">
			<p class="bg-warning">
				<span>有效订单数：<i class="badge">0</i></span>
				<span>有效订单总额：<i class="badge">0</i></span>
				<span>客单价：<i class="badge">0</i></span>
				<span>重复购买率：<i class="badge">0</i></span>
				<span>退款订单：<i class="badge">0</i></span>
				<span>退款总额（不含优惠卡券）：<i class="badge">0</i></span>
			</p>
		</div>
		<form  class="form-inline" >
			<div class="col-sm-12">
				<div class="col-sm-6">
					<div class="">
						<label>时间：</label>
						<input type="text" class="form-control date" id="create_time_start" name="create_time_start" />
					</div>
				</div>	
				<div class="col-sm-5">
					<div class="form-group">
						<label>到：</label>
						<input type="text" class="form-control date" id="create_time_end" name="create_time_end" />
						<a href="javascript:void(0);" id="exportBtn" onclick="exportExcel();" type="button" class="btn btn-success btn-sm">生成订单报表</a>	
					</div>
				</div>	
			</div>
		</form>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/orderReport/report.js" type="text/javascript"></script>
</body>
</html>