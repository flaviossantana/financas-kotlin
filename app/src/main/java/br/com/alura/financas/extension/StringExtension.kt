package br.com.alura.financas.extension

fun String.limitarEmAte(caracteres: Int): String {
    if(this.length > 14){
        return "${this.subSequence(0, caracteres)}..."
    }
    return this
}
