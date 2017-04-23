<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<form action="${ctx}/search/result" method="get" target="_blank">
	<div class="input-group">
	   <input type="text" class="form-control" name="keyword" placeholder="商品名称"/>
	   <i  class="icon1 glyphicon glyphicon-search"></i>
	   <span class="input-group-btn">
	     	<button type="submit" class="btn btn-me">搜索</button>
	   </span>
	</div>
</form>