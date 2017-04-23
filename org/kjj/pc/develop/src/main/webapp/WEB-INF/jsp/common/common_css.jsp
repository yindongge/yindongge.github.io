<link rel="shortcut icon" type="image/x-icon" href="${imgBase}/favicon.ico" media="screen" />
<link href="${cssBase}/modal.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/tab.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/main.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/regin.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/sevrice.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/slide-left.css" rel="stylesheet" type="text/css" />
<link href="${cssBase}/sevrice.css" rel="stylesheet" type="text/css" />
<script src="http://hm.baidu.com/hm.js?995b5cf73057be40c0c023a8da232f89" type="text/javascript"></script>
<script src="${jsBase}/common/jquery-1.11.2.js" type="text/javascript"></script>
<script type="text/javascript">
try{
	var urlhash = window.location.hash;
	if(!urlhash.match("fromapp")){
		if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i))){
			var local_href=location.href.replace('<%= request.getScheme()+"://"+request.getServerName() %>',"");
			local_href=local_href.replace(':<%= request.getServerPort() %>',"");
			window.location="http://m.kjjhome.com/"+local_href;
		}
	}
}
catch(err){
}
</script>
