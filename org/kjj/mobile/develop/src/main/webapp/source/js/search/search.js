$(function(){
	$(".search-item a").on("click",function(){
		$("#keyword").val($(this).text());
		$("#searchForm").submit();
	});

	$("#clearCookies").on("click",function(){
		$.cookie('searchKey', '',{path:"/"}); 
		window.location.reload();
	});
});


