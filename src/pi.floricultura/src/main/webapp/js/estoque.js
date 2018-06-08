function alteraQuantidade(isSum) {
    
    //obtem o valor da quantidade atual
    var qntAtual = document.getElementById('quantidadeAtual').value
    console.log(qntAtual)
    
    //obtem a quantidade digitada
    var qntDigitada = document.getElementById('quantidadeAlterar').value
    
    //calcula de acordo com a necessidade
    var qntFinal;
    if(isSum) {
        //soma
        qntFinal = qntAtual + qntDigitada
    } else {
        //subtracao
        qntFinal = qntAtual - qntDigitada 
    }
    //adiciono o valor final ao input de quantidade final
    document.getElementById('quantidadeFinal').setAttribute('value', qntFinal)
    var final = document.getElementById('quantidadeFinal').value
    
    console.log(final)
    
    return
    
}