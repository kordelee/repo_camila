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
	

document.getElementById("btnReset").onclick = function () {
    location.href = goUrlXdmList;
}


document.getElementById("btnForm").onclick = function () {
    goForm(0);
}


goForm = function (keyValue) {
    seq.value = keyValue;
    form.action = goUrlXdmForm;
    form.submit();
}


goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlXdmList;
    form.submit();
}


document.getElementById("changeRowNum").onchange = function () {
    document.getElementById("rowNumToShow").value = document.getElementById("changeRowNum").value;
    form.action = goUrlXdmList;
    form.submit();
}


document.getElementById("btnSearch").onclick = function () {
    form.action = goUrlXdmList;
    form.submit();
};


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


document.getElementById("btnUelete").onclick = function () {
	if (document.querySelectorAll("input[name='checkboxSeq']:checked").length > 0) {
		document.querySelector(".modal-title").textContent = "확 인";
		document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
		document.querySelector("#btnModalUelete").style.display = '';
		document.querySelector("#btnModalDelete").style.display = 'none';
		$("#modalConfirm").modal("show");        
	} else {
		document.querySelector(".modal-title").textContent = "확 인";
		document.querySelector(".modal-body").textContent = "데이터를 선택해 주세요!";
		document.querySelector("#btnModalDelete").style.display = 'none';
		document.querySelector("#btnModalUelete").style.display = 'none';
		$("#modalAlert").modal("show");
	}
}
	
	
	
document.getElementById("btnModalUelete").onclick = function () {
    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

    for (let i = 0; i < checkBoxArr.length; i++) {
        if (checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
    }
    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
    form.action = goUrlXdmMultiUele;
    form.submit();
}


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

document.getElementById("btnModalDelete").click = function () {
    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

    for (let i = 0; i < checkBoxArr.length; i++) {
        if (checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
    }
    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
    form.action = goUrlXdmMultiDele;
    form.submit();
}
