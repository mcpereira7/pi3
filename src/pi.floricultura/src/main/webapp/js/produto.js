//Funcao de pegar o nome(primeiro elemento da tr da table de conslta do produto)
$("#produtoTable tr#rowSelection").click(function(){
	
	//Pega o valor
	$(this).addClass('selected').siblings().removeClass('selected');    
	var value=$(this).find('td:first').html();
	
	//Seta o valor no input hidden
	$("#produtoSelecionado").val(value);
	
	//Mostra janela de confirmacao
	var confirmacao = window.confirm("Alterar produto?");
	
	if(!confirmacao) {
		confirmacao.preventDefault();
		return;
	}
	else {
		document.getElementById("produto-resultados").submit();
	}
	
});

//Funcao de preencher info da alteracao do produto
function produtoAlteracao() {
    var tipo = document.getElementById("produtoTipo").value;
    var descricao = document.getElementById("produtoDescricao").value;
    document.getElementById(tipo.toLowerCase()).setAttribute("checked", "true");
    document.getElementById("descricao").value = descricao;
}

produtoAlteracao();