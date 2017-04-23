function pageNow(pageJump) {
	var totalPages = parseInt($("#pageNumber").attr("data-total-pages"));
	if (pageJump < 1) {
		alert(" 不 好 意 思 ， 已 经 是 第 一 页 啦  ！");
		return false;
	} else if (totalPages < pageJump) {
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
		alert(" 没 有 下 一 页 啦 ！");
		return false;
	} else {
		$("#pageNumber").val(pageJump-1);
		$("#pageform").submit();
	}
}

function isPInt(str) {
	var g = /^[1-9]*[1-9][0-9]*$/;
	return g.test(str);
}