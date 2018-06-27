package br.com.alura.financas.model

import android.content.Context
import android.support.v4.content.ContextCompat
import br.com.alura.financas.R
import br.com.alura.financas.R.color.despesa
import br.com.alura.financas.R.color.receita
import br.com.alura.financas.enum.Tipo
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    val receita get() = somar(RECEITA)

    val despesa get() = somar(DESPESA)

    val total get() = receita.subtract(despesa)

    private fun somar(tipo: Tipo): BigDecimal {
        return BigDecimal(transacoes.filter { it.isTipo(tipo) }.sumByDouble { it.valor.toDouble() })
    }

    fun corDespesa(context: Context): Int {
        return getColor(context, R.color.despesa)
    }

    fun corReceita(context: Context): Int {
        return getColor(context, R.color.receita)
    }

    private fun getColor(context: Context, cor: Int): Int {
        return ContextCompat.getColor(context, cor)
    }

    fun corTotal(context: Context): Int {
        if (total >= BigDecimal.ZERO) {
            return corReceita(context)
        }
        return corDespesa(context)
    }

}