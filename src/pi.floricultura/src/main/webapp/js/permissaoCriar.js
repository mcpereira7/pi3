var count = 1;
var limit = 10;

function addSelect(divName, listaTelas) {

    var newDiv = document.createElement('div');
    
//                            Tela <select name="tela">
//                            <c:forEach items = "${listaTelas}" var = "tela">
 //                               <option value="${//tela.id}">${tela.nome}</option>
   //                         </c:forEach>//
//                        </select>
    
    var select = "Tela <select name='tela'>";
    var option = "";
    
    for (var tela in listaTelas) {
        option += "<option value='" + tela.id + "'>" + tela.nome + "</option>"
    }
    
    newDiv.innerHTML = select + option + "</br>";

    document.getElementById(divName).appendChild(newDiv);
    
    document.getElementById()

}

function removeInputProduct(input) {

    input.parentNode.parentNode.removeChild(input.parentNode);

    count--;
}


