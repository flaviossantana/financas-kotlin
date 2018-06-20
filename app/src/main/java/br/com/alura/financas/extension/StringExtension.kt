package br.com.alura.financas.extension

fun String.limitarEmAte(caracteres: Int): String {
    if(this.length > 14){
        val POSICAO_INICIAL = 0
        return "${this.subSequence(POSICAO_INICIAL, caracteres)}..."
    }
    return this
}
