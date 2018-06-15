package br.com.alura.financas.model

import br.com.alura.financas.R.color.despesa
import br.com.alura.financas.R.color.receita
import br.com.alura.financas.R.drawable.icone_transacao_item_despesa
import br.com.alura.financas.R.drawable.icone_transacao_item_receita
import br.com.alura.financas.enum.Tipo
import java.math.BigDecimal
import java.util.*

class Transacao(val tipo: Tipo,
                val valor: BigDecimal,
                val categoria: String = "INDEFINIDA",
                val data: Calendar = Calendar.getInstance()) {

    fun isReceita(): Boolean {
        return tipo == Tipo.RECEITA
    }

    fun corValor(): Int {
        return if(isReceita()) receita else  despesa
    }

    fun icone(): Int {
        return if(isReceita()) icone_transacao_item_receita else icone_transacao_item_despesa
    }
}