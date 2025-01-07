let form = document.querySelector("form[name=form]");
let formVo = document.querySelector("form[name=formVo]");


document.getElementById("btnList").onclick = function () {
	formVo.action = goUrlXdmList;
	formVo.submit();
}


if(document.getElementById("btnDelete")){
	document.getElementById("btnDelete").onclick = function () {
		document.querySelector("#modalConfirmTitle").textContent = "확 인";
		document.querySelector("#modalConfirmBody").textContent = "해당 데이터를 삭제하시겠습니까 ?";
		document.querySelector("#btnModalUelete").style.display = 'none';
		document.querySelector("#btnModalDelete").style.display = '';
		$("#modalConfirm").modal("show");      	
	}
}


if(document.getElementById("btnUelete")){
	document.getElementById("btnUelete").onclick = function () {
		document.querySelector("#modalConfirmTitle").textContent = "확 인";
		document.querySelector("#modalConfirmBody").textContent = "해당 데이터를 삭제하시겠습니까 ?";
		document.querySelector("#btnModalUelete").style.display = '';
		document.querySelector("#btnModalDelete").style.display = 'none';
		$("#modalConfirm").modal("show");      	
	}
}


delUploaded = function (seq) {
	document.querySelector("#modalUploadDelConfirmTitle").textContent = "확 인";
	document.querySelector("#modalUploadDelConfirmBody").textContent = "해당 데이터를 삭제하시겠습니까 ?";
	document.querySelector("#btnModalUelete").style.display = 'none';
	document.querySelector("#btnModalDelete").style.display = '';
	$("#modalUploadDelConfirm").modal("show");
	uploadSeq.value = seq;
}
	

document.getElementById("btnModalUelete").onclick = function () {
	form.action = goUrlXdmUele;
	form.submit();
}


document.getElementById("btnModalDelete").onclick = function () {
	form.action = goUrlXdmDele;
	form.submit();
}


document.getElementById("btnModalUploadedUelete").onclick = function () {
	form.action = goUrlXdmUploadedUele;
	form.submit();
}


document.getElementById("btnModalUploadedDelete").onclick = function () {
	form.action = goUrlXdmUploadedDele;
	form.submit();
}


document.getElementById("btnSubmit").onclick = function () {
	$("#modalLoading").modal("show");
	if(seq.value == "0" || seq.value == "") {
		if(validationInst() == false) return false;
			form.action = goUrlXdmInst;
			form.submit();
		} else {
		if(validationUpdt() == false) return false;
			form.action = goUrlXdmUpdt;
			form.submit();
		}
}