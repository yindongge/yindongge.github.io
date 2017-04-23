<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<div class="navbar-form navbar-right" role="search">
	<div class="form-group">
		<input type="text" class="form-control" id="textNumber" placeholder="到第几页">
		<input type="hidden" id="pageNumber" name="pageNumber" data-total-pages="${page.totalPages}">
	</div>
	<button type="button" class="btn btn-default btn-info" onclick="jumpPage();">确定</button>
</div>
<ul class="pagination pull-right">
	<c:if test="${page.number ne 0}">
		<li><a href="javascript:void(0)" onclick="return pageNow('1')">第一页</a></li>
		<li><a href="javascript:void(0);" onclick="return pageNow('${page.number}')"> <span aria-hidden="true">&laquo;</span></a></li>
	</c:if>

	<c:forEach var="key" begin="${page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) > 1 ? page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) : 1}"
			end="${(10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 < page.totalPages ? (10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 : page.totalPages}">
		<c:if test="${page.number==key-1}">
			<li><a class="current" href="javascript:void(0)">${key}</a></li>
		</c:if>
		<c:if test="${page.number!=key-1}">
			<li>&nbsp;<a href="javascript:void(0);" onclick="pageNow('${key}')">${key}</a></li>
		</c:if>
	</c:forEach>

	<c:if test="${page.number ne page.totalPages-1}">
		<li><a aria-label="Next" href="javascript:void(0);" onclick="pageNow('${page.number + 2}')"> <span aria-hidden="true">&raquo;</span>
		</a></li>
		<li><a href="javascript:void(0)" onclick="pageNow('${page.totalPages}')">最后一页</a></li>
	</c:if>
</ul>
<p class="navbar-text pull-right">共有${page.totalElements}条记录  每页${page.size}条</p>
<script type="text/javascript">
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