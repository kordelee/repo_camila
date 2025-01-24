document.write("<script src='/usr/v0/js/constantsUsr.js'></script>");
document.write("<script src='/usr/v0/js/validationUsr.js'></script>");

/* datetimepicker s */
$.datetimepicker.setLocale('ko');
/* datetimepicker s */


$("#btnLogout").on("click", function(){
	$.ajax({
		async: true 
		,cache: false
		,type: "post"
		,url: "/v1/infra/member/signoutUsrProc"
		,data: {}
		,success: function(response) {
			if(response.rt == "success") {
				location.href = "/v1/infra/index/indexUsrView";
			} else {
				// by pass
			}
		}
		,error : function(jqXHR, textStatus, errorThrown){
			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
		}
	});
});


/*문자열 특정 자리수 치환*/
var replaceAt = function(input, index, character){
    return input.substr(0, index) + character + input.substr(index+character.length);
}


goLogin = function(){
	location.href = URL_USR_LOGIN_FORM;
}


goIndex = function(){
	location.href = URL_USR_INDEX_VIEW;
}