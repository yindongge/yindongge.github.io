<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<div class="mg-footer">
	<div class="to-page">
		<p>到第<input type="text" id="textNumber" value="${page.number+1}">页</p>
		<input type="hidden" id="pageNumber" name="pageNumber" data-total-pages="${page.totalPages}">
		<button type="button" class="btn btn-warning btn-sm" onclick="jumpPage();">确定</button>
	</div>
	
	<ul class="pagination page-control">
	    
		<%-- 
		<c:if test="${page.number eq 0}">
			<li><a href="javascript:void(0)" aria-label="Previous">上一页</a></li> 
		</c:if>
		--%>
		<c:if test="${page.number ne 0}">
			<li><a href="javascript:void(0);" onclick="return pageNow('${page.number}')">上一页</a></li>
		</c:if>

		<c:forEach var="key" begin="${page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) > 1 ? page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) : 1}"
			end="${(10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 < page.totalPages ? (10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 : page.totalPages}">
			<c:if test="${page.number==key-1}">
				<li><a class="page-click" href="javascript:void(0)">${key}</a></li>
			</c:if>
			<c:if test="${page.number!=key-1}">
				<li><a href="javascript:void(0);" onclick="pageNow('${key}')">${key}</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${page.number ne page.totalPages-1}">
			<li><a aria-label="Next" href="javascript:void(0);" onclick="pageNow('${page.number+2}')">下一页 </a></li>
		</c:if>
		<%-- 
			<c:if test="${page.number eq page.totalPages-1}">
				<li><a aria-label="Next" href="javascript:void(0);">下一页 </a></li> 
			</c:if>
		--%>
	</ul>
	<p>共有${page.totalElements}条记录 每页
				<select name="pageSize" id="pageSize" onchange="doQuery()">
					<option value="50"  <c:if test="${page.size==50}">selected</c:if>>50</option>
					<option value="100" <c:if test="${page.size==100}">selected</c:if>>100</option>
					<option value="200" <c:if test="${page.size==200}">selected</c:if>>200</option>
					<option value="300" <c:if test="${page.size==300}">selected</c:if>>300</option>
					<option value="500" <c:if test="${page.size==500}">selected</c:if>>500</option>
				</select>条</p>
</div>
<script type="text/javascript">
function doQuery(){
	$("#pageform").submit();
}
function pageNow(pageJump) {
	var totalPages = parseInt($("#pageNumber").attr("data-total-pages"));
	if (pageJump <= 0) {
		alert(" 不 好 意 思 ， 已 经 是 第 一 页 啦  ！");
		return false;
	} else if (totalPages <= pageJump-1) {
		alert(" 没 有 下 一 页 啦 ！");
		return false;
	} else {
		$("#pageNumber").val(pageJump-1);
		$("#pageform").submit();
	}
}

function jumpPage() {
	var pageJump = $("#textNumber").val();
	var totalPages = parseInt($("#pageNumber").attr("data-total-pages"));
	if (!isPInt(pageJump)) {
		alert(" 请填写正整数 ！");
		return false;
	}
	if (pageJump < 1) {
		alert(" 不 好 意 思 ， 已 经 是 第 一 页 啦  ！");
		return false;
	} else if (totalPages < pageJump) {
		$("#pageNumber").val(totalPages-1);
		$("#pageform").submit();
		//alert(" 没 有 下 一 页 啦 ！");
		//return false;
	} else {
		$("#pageNumber").val(pageJump-1);
		$("#pageform").submit();
	}
}

function isPInt(str) {
	var g = /^[1-9]*[1-9][0-9]*$/;
	return g.test(str);
}
</script>