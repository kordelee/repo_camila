document.write("<script src='/usr/v1/js/constantsUsr.js'></script>");
document.write("<script src='/usr/v1/js/validationUsr.js'></script>");


/* datetimepicker s */
$.datetimepicker.setLocale('ko');
/* datetimepicker s */


/*$.datepicker.setDefaults($.datepicker.regional['ko']);
$("#shDateStart").datepicker({
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dateFormat: "yy-mm-dd",
    onClose: function( selectedDate ) {
        $("#shDateEnd").datepicker( "option", "minDate", selectedDate );
    }
});*/

/*$("#shDateEnd").datepicker({
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dateFormat: "yy-mm-dd",
    onClose: function( selectedDate ) {
        $("#shDateStart").datepicker( "option", "maxDate", selectedDate );
    }
});*/

/*$("#ifmmDob").datepicker({
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dateFormat: "yy-mm-dd",
});*/


checkUploadedTotalFileNumber = function(obj, allowedMaxTotalFileNumber, filesCount, uploadedFilesCount) {
	if(allowedMaxTotalFileNumber < (filesCount + uploadedFilesCount)){
		alert("전체 파일 갯수는 "+ allowedMaxTotalFileNumber +"개 까지 허용됩니다.");
//		$("#file"+seq).val("");
//		obj.val("");
		return false;
	}
}


checkUploadedExt = function(objName, seq, div) {
	var ext = objName.split('.').pop().toLowerCase();
	var extArray = eval("extArray" + div);
	
	if(extArray.indexOf(ext) == -1) {
		alert("허용된 확장자가 아닙니다.");
//		$("#file"+seq).val("");
		return false;
	}
}


checkUploadedEachFileSize = function(obj, seq, allowedEachFileSize) {

	if(obj.size > allowedEachFileSize){
		alert("각 첨부 파일 사이즈는 "+kbToMb(allowedEachFileSize)+"MB 이내로 등록 가능합니다.");
		$("#file"+seq).val("");
		return false;
	}
}


checkUploadedTotalFileSize = function(seq, totalSize, allowedTotalFileSize) {
	if(totalSize > allowedTotalFileSize){
		alert("전체 용량은 "+kbToMb(allowedTotalFileSize)+"M를 넘을 수 없습니다.");
		$("#file"+seq).val("");
		return false;
	}
}


// 이미지 전용
var extArray1 = new Array();
extArray1 = ["jpg","gif","png","jpeg","bmp","tif"];

// 문서관련
var extArray2 = new Array();
extArray2 = ["txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

// 이하는 커스텀
var extArray3 = new Array();
extArray3 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray4 = new Array();
extArray4 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray5 = new Array();
extArray5 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray6 = new Array();
extArray6 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray7 = new Array();
extArray7 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray8 = new Array();
extArray8 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];

var extArray9 = new Array();
extArray9 = ["jpg","gif","png","jpeg","bmp","tif","txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx","html"];


	$("#btnSignout").on("click", function(){
		$.ajax({
			async: true 
			,cache: false
			,type: "post"
			,url: URL_SIGNOUT_PROC_USR
			,data: {}
			,success: function(response) {
				if(response.rt == "success") {
					location.href = URL_INDEX_VIEW_USR;
				} else {
					// by pass
				}
			}
			,error : function(jqXHR, textStatus, errorThrown){
				alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
			}
		});
	});
		
	
	  /*window.addEventListener('load', function() {
		  let url = window.location.pathname;
		  let rt = url.split("/");
		  //배열로 떨어져서 길이 구한다음 모듈 이름까지 빼기
		  let moduelName = rt[rt.length-2];
		  let fileName = rt[rt.length-1];
		  
		  if(fileName.includes("Use")){
		  	document.getElementById(moduelName+'Use').classList.add('active');
		  } else{
		  	//li태그에 active 요소 추가
		  	document.getElementById(moduelName).classList.add('active');
		  	//바로 상위 태그인 ul에 show 요소 추가
		  	document.getElementById(moduelName).closest('ul').classList.add('show');
		  }
	});*/
		  
function textCount(textAreaId){
	document.getElementById(textAreaId+"Count").innerText = document.getElementById(textAreaId).value.length;
}