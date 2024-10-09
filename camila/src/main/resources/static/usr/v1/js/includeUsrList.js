let form = document.querySelector("form[name=formList]");
let checkboxSeqArray = [];

window.addEventListener('load', function () {
    let checkboxes = document.querySelectorAll('input[name=checkboxSeq]');

    for (let checkbox of checkboxes) {
        checkbox.addEventListener('change', function (event) {
            if (event.target.checked) {
                document.getElementById("trNum_" + event.target.value).style.backgroundColor = TABLE_COLOR;
            } else {
                document.getElementById("trNum_" + event.target.value).style.backgroundColor = "";
            }
        });
    }
});


$("input[name=checkboxSeq]").click(function() {
	var total = $("input[name=checkboxSeq]").length;
	var checked = $("input[name=checkboxSeq]:checked").length;
	
	if(total != checked) $("#checkboxAll").prop("checked", false);
	else $("#checkboxAll").prop("checked", true); 
});
	
if(document.getElementById("btnReset")){
	document.getElementById("btnReset").onclick = function () {
	    location.href = goUrlUsrList;
	}
}


if(document.getElementById("btnForm")){
	document.getElementById("btnForm").onclick = function () {
	    goForm(0);
	}
}



goForm = function (keyValue) {
    seq.value = keyValue;
    form.action = goUrlUsrForm;
    form.submit();
}


goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlUsrList;
    form.submit();
}

if(document.getElementById("changeRowNum")){
	document.getElementById("changeRowNum").onchange = function () {
	    document.getElementById("rowNumToShow").value = document.getElementById("changeRowNum").value;
	    form.action = goUrlUsrList;
	    form.submit();
	}
}


if(document.getElementById("btnSearch")){
	document.getElementById("btnSearch").onclick = function () {
	    form.action = goUrlUsrList;
	    form.submit();
	};
}


function enterkey() {
	if (window.event.keyCode == 13) {
	    form.action = goUrlUsrList;
	    form.submit();
    }
}

if(document.getElementById("checkBoxAll")){
	document.getElementById("checkBoxAll").onclick = function () {
	    let checkNum = document.getElementsByName("checkboxSeq");

	    if (document.getElementById("checkBoxAll").checked == true) {
	        for (let i of checkNum) {
	            let trStyle = i.parentNode.parentNode.parentNode;
	            i.checked = true;
	            trStyle.style.backgroundColor = TABLE_COLOR;
	        }
	    } else {
	        for (let i of checkNum) {
	            let trStyle = i.parentNode.parentNode.parentNode;
	            i.checked = false;
	            trStyle.style.backgroundColor = '';
	        }
	    }
	}
}


if(document.getElementById("btnUelete")){
	document.getElementById("btnUelete").onclick = function () {
		if (document.querySelectorAll("input[name='checkboxSeq']:checked").length > 0) {
			document.querySelector("#modalConfirmTitle").textContent = "확 인";
			document.querySelector("#modalConfirmBody").textContent = "해당 데이터를 삭제하시겠습니까 ?";
			document.querySelector("#btnModalUelete").style.display = '';
			document.querySelector("#btnModalDelete").style.display = 'none';
			$("#modalConfirm").modal("show");        
		} else {
			document.querySelector("#modalAlertTitle").textContent = "확 인";
			document.querySelector("#modalAlertBody").textContent = "데이터를 선택해 주세요!";
			document.querySelector("#btnModalDelete").style.display = 'none';
			document.querySelector("#btnModalUelete").style.display = 'none';
			$("#modalAlert").modal("show");
		}
	}
}
	

if(document.getElementById("btnModalUelete")){
	document.getElementById("btnModalUelete").onclick = function () {
	    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

	    for (let i = 0; i < checkBoxArr.length; i++) {
	        if (checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
	    }
	    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
	    form.action = goUrlUsrMultiUele;
	    form.submit();
	}
}


if(document.getElementById("btnDelete")){
	document.getElementById("btnDelete").onclick = function () {
	    if (document.querySelectorAll("input[name='checkboxSeq']:checked").length > 0) {
	        document.querySelector(".modal-title").textContent = "확 인";
	        document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
	        document.querySelector("#btnModalUelete").style.display = 'none';
	        document.querySelector("#btnModalDelete").style.display = '';
	        $("#modalConfirm").modal("show");
	    } else {
	        document.querySelector(".modal-title").textContent = "확 인";
	        document.querySelector(".modal-body").textContent = "데이터를 선택해 주세요!";
	        document.querySelector("#btnModalDelete").style.display = 'none';
	        document.querySelector("#btnModalUelete").style.display = 'none';
	        $("#modalAlert").modal("show");
	    }
	}
}


if(document.getElementById("btnModalDelete")){
	document.getElementById("btnModalDelete").click = function () {
	    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

	    for (let i = 0; i < checkBoxArr.length; i++) {
	        if (checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
	    }
	    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
	    form.action = goUrlUsrMultiDele;
	    form.submit();
	}
}



	$("#btnExcel").click(function() {
		
		    form.action = excelUri;
    form.submit();
		
		//form.attr("action", excelUri).submit();
	});