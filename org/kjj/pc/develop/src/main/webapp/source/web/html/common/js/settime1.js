
var timer1=null;
var tiemr2=null;
$(function(){

	timer1=setInterval(transferTime, 1000);
})
function transferTime()
{
	var now = new Date();
	var endTimeStr="2016-5-11 10:00:00";
	// endTimeStr = endTimeStr.replace(/-/g,"/");
	var endTime = new Date(endTimeStr);
	var leftTime=endTime.getTime()-now.getTime();
	var leftsecond = parseInt(leftTime/1000);
	var day1=Math.floor(leftsecond/(60*60*24));
	var hour=Math.floor((leftsecond-day1*24*60*60)/3600);
	var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60);
	var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60);
	if(hour<10)
	{
		hour="0"+hour;
	}
	if(minute<10)
	{
		minute="0"+minute;
	}

	if(second<10)
	{
		second="0"+second;
	}
	if(leftTime<=0)
	{
		$('.fix-box').css({
			background:"url(img/day5.png) no-repeat center"
		});
		clearInterval(timer1);
		timer2=setInterval(transferTime2, 1000);

	}
	// $("#timeLimit").val(hour+"小时"+minute+"分"+second+"秒");
	$('#time1').text(hour);
	$('#time2').text(minute);
	$('#time3').text(second);
}

function transferTime2()
{
	var now = new Date();
	var endTimeStr="2016-5-11 23:59:59";
	// endTimeStr = endTimeStr.replace(/-/g,"/");
	var endTime = new Date(endTimeStr);
	var leftTime=endTime.getTime()-now.getTime();
	var leftsecond = parseInt(leftTime/1000);
	var day1=Math.floor(leftsecond/(60*60*24));
	var hour=Math.floor((leftsecond-day1*24*60*60)/3600);
	var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60);
	var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60);
	if(hour<10)
	{
		hour="0"+hour;
	}
	if(minute<10)
	{
		minute="0"+minute;
	}

	if(second<10)
	{
		second="0"+second;
	}
	if(leftTime<=0)
	{
		$('.fix-box').empty().css({
			background:"url(img/day6.png) no-repeat center"
		});
		clearInterval(timer2);

	}
	// $("#timeLimit").val(hour+"小时"+minute+"分"+second+"秒");
	$('#time1').text(hour);
	$('#time2').text(minute);
	$('#time3').text(second);
}