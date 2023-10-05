let form = document.querySelector("form[name=formList]");
let checkboxSeqArray = [];




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