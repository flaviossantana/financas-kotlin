package br.com.alura.financas.model

import br.com.alura.financas.R.color.despesa
import br.com.alura.financas.R.color.receita
import br.com.alura.financas.R.drawable.icone_transacao_item_despesa
import br.com.alura.financas.R.drawable.icone_transacao_item_receita
import br.com.alura.financas.enum.Tipo
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import java.math.BigDecimal
import java.util.*

class Transacao(val tipo: Tipo,
                val valor: BigDecimal,
                val categoria: String = "CATEGORIA INDEFINIDA",
                val data: Calendar = Calendar.getInstance()) {

    fun isReceita(): Boolean {
        return RECEITA.equals(tipo)
    }

    fun isDespesa(): Boolean {
        return DESPESA.equals(tipo)
    }

    fun isTipo(tipo: Tipo): Boolean {
        return tipo.equals(this.tipo)
    }

    fun corValor(): Int {
        return if(isReceita()) receita else  despesa
    }

    fun icone(): Int {
        return if(isReceita()) icone_transacao_item_receita else icone_transacao_item_despesa
    }
}