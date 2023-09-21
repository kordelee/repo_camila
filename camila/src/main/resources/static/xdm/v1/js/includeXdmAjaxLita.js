document.getElementById("changeRowNum").onchange = function() {
    document.getElementById("rowNumToShow").value = document.getElementById("changeRowNum").value;
    form.action = goUrlList;
    form.submit();
}

document.getElementById("CheckBoxAll").onclick = function () {
    let checkNum = document.getElementsByName("checkboxSeq");

    if(document.getElementById("CheckBoxAll").checked == true) {
        for(let i of checkNum) {
            let trStyle =  i.parentNode.parentNode.parentNode;
            i.checked = true;
            trStyle.style.backgroundColor = TABLE_COLOR;
        }
    } else {
        for(let i of checkNum) {
            let trStyle =  i.parentNode.parentNode.parentNode;
            i.checked = false;
            trStyle.style.backgroundColor = '';
        }
    }
}
$(function () {
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

goForm = function(keyValue) {
    seq.value = keyValue;
    form.action = goUrlForm;
    form.submit();
}

goList = function(thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    setLita();
}

document.getElementById("btnUelete").onclick = function () {
    if(document.querySelectorAll("input[name='checkboxSeq']:checked").length > 0 ) {
        document.querySelector(".modal-title").textContent = "확 인";
        document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
        document.querySelector("#btnModalUelete").style.display = '';
        document.querySelector("#btnModalDelete").style.display = 'none';
    } else {
        document.querySelector(".modal-title").textContent = "확 인";
        document.querySelector(".modal-body").textContent = "데이터를 선택해 주세요!";
        document.querySelector("#btnModalDelete").style.display = 'none';
        document.querySelector("#btnModalUelete").style.display = 'none';
    }
}

document.getElementById("btnModalUelete").onclick = function () {
    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

    for(let i = 0; i< checkBoxArr.length; i++) {
        if(checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
    }
    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
    form.action = goUrlMultiUele;
    form.submit();
}

document.getElementById("btnDelete").onclick = function () {
    if(document.querySelectorAll("input[name='checkboxSeq']:checked").length > 0 ) {
        document.querySelector(".modal-title").textContent = "확 인";
        document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
        document.querySelector("#btnModalUelete").style.display = 'none';
        document.querySelector("#btnModalDelete").style.display = '';
    } else {
        document.querySelector(".modal-title").textContent = "확 인";
        document.querySelector(".modal-body").textContent = "데이터를 선택해 주세요!";
        document.querySelector("#btnModalDelete").style.display = 'none';
        document.querySelector("#btnModalUelete").style.display = 'none';
    }
}

document.getElementById("btnModalDelete").click = function () {
    let checkBoxArr = document.querySelectorAll("input[name='checkboxSeq']:checked");

    for(let i = 0; i< checkBoxArr.length; i++) {
        if(checkBoxArr[i].checked) checkboxSeqArray.push(checkBoxArr[i].value);
    }
    document.querySelector("input[name='checkboxSeqArray']").value = checkboxSeqArray;
    form.action = goUrlMultiDele;
    form.submit();
}

document.getElementById("btnExcel").onclick = function () {
    alert("도입전")
}

document.getElementById("btnForm").onclick = function () {
    goForm(0);
}