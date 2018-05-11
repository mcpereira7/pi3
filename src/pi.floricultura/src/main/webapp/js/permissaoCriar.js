var count = 1;
var limit = 10;

function addSelect(divName, lista) {

    var newDiv = document.createElement('div');
    
    var selectList = document.createElement("select");
    selectList.id = "tela";
    newDiv.appendChild(selectList);
    
    for (var tela in lista) {
        var option = document.createElement("option");
        option.value = tela.id;
        option.text = tela.nome;
        selectList.appendChild(option);
    }
    
    //newDiv.innerHTML = select + option + "</br>";

    document.getElementById(divName).appendChild(newDiv);
    
}

function removeInputProduct(input) {

    input.parentNode.parentNode.removeChild(input.parentNode);

    count--;
}


