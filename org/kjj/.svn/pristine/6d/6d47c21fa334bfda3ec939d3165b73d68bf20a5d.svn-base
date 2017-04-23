$(function(){
	
	
	$("form").submit(function(e){
	    $('#addBtn').attr('disabled','disabled');
	  });
	
	$(".pick-a-color").pickAColor({
		  showSpectrum            : true,
			showSavedColors         : true,
			saveColorsPerElement    : true,
			fadeMenuToggle          : true,
			showAdvanced			: true,
			showBasicColors         : true,
			showHexInput            : true,
			allowBlank				: true
		});
	
	//日期选择器
	$(".datetime").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		showClear:true,
		locale:'zh-cn',
	});
	
	$('[name="startTime"]').on("dp.change", function (e) {
		if($('[name="endTime"]').val()!=""){
			$('[name="endTime"]').data("DateTimePicker").minDate(e.date);			
		}
    });
    $('[name="endTime"]').on("dp.change", function (e) {
    	if($('[name="startTime"]').val()!=""){
    		$('[name="startTime"]').data("DateTimePicker").maxDate(e.date);
    	}
    });
    
    $(".time").datetimepicker({
		format: 'HH:mm:ss',
		showClear:true,
		locale:'zh-cn',
	});
    
    $('[name="orgSpecialTime.timeStart"]').on("blur", function (e) {
    	compareTime($('[name="orgSpecialTime.timeStart"]').val(), $('[name="orgSpecialTime.timeEnd"]').val(),$(this));
    });
    $('[name="orgSpecialTime.timeEnd"]').on("blur", function (e) {
    	compareTime($('[name="orgSpecialTime.timeStart"]').val(), $('[name="orgSpecialTime.timeEnd"]').val(),$(this));
    });
    
    KindEditor.ready(function(K) {
      	 K.create('#content', {  
               uploadJson : '../kindEditor/fileUpload',    
               fileManagerJson : '../kindEditor/fileManager', 
               allowFileManager : true  ,
               afterCreate : function() { 
                   this.sync(); 
                  }, 
                  afterBlur:function(){ 
                      this.sync(); 
                  }       
             });  
          
      });
    
    
});

function compareTime(a, b,cur) {
	var arr1 = a.split(":");
    var starttime = new Date();
    starttime.setHours(arr1[0], arr1[1], arr1[2], 0);
    var startms = starttime.getTime();

    var arr2 = b.split(":");
    var endtime = new Date();
    endtime.setHours(arr2[0], arr2[1], arr2[2], 0);
    var endms = endtime.getTime();
    if (startms >= endms) {
        alert('时间区间不正确！');
        cur.val('');
        return false;
    }
}