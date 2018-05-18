var count = 1;
var limit = 10;

function addInputOnDiv(divName) {
    
    if (count === limit) {
        alert("Limite teste : " + count);
    } else {
        
        var newDiv = document.createElement('div');
        
        var styleProductName = "";
        var styleProductQuantit = " style= 'width:70% !important'";
        var styleProductRemoveButton = " style= 'height: 2.5em; line-height: 2.5em;'";
        var inputProdutoCodigo = "<hr class='general'/><br><h4>Código Produto " + (count + 1) + ":</h4><input type='text' name='produto' id='produto" + (count + 1) + "' />";
        var inputProdutoQuantidade = " <h4>Quantidade: </h4><input type='number' min='0' name='quantidadeProduto' id='quantProduto" + (count + 1) + "' " + styleProductQuantit + "/>";
        var buttonToRemoveThisDiv = "&nbsp&nbsp<input onclick='removeInputProduct(this)' type='button' value='-' " + styleProductRemoveButton + " /><br>";
        
        newDiv.innerHTML = inputProdutoCodigo + inputProdutoQuantidade + buttonToRemoveThisDiv;
        
        document.getElementById(divName).appendChild(newDiv);
        
        count++;
    }
}

function removeInputProduct(input) {
    
    input.parentNode.parentNode.removeChild(input.parentNode);
    
    count--;
}
$(function() {
    
    $('#cliente').mask('000.000.000-00', {reverse: true});

});