package br.com.alura.financas.model

import android.content.Context
import android.support.v4.content.ContextCompat
import br.com.alura.financas.R.color.despesa
import br.com.alura.financas.R.color.receita
import br.com.alura.financas.enum.Tipo
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita(): BigDecimal {
        return somar(RECEITA)
    }

    fun despesa(): BigDecimal {
        return somar(DESPESA)
    }

    fun total(): BigDecimal {
        return receita().subtract(despesa())
    }

    fun corDespesa(context: Context): Int {
        return getColor(context, despesa)
    }

    fun corReceita(context: Context): Int {
        return getColor(context, receita)
    }

    fun corTotal(context: Context): Int {
        if (total() >= BigDecimal.ZERO) {
            return corReceita(context)
        }

        return corDespesa(context)
    }

    private fun getColor(context: Context, cor: Int): Int {
        return ContextCompat.getColor(context, cor)
    }

    private fun somar(tipo: Tipo): BigDecimal {
        return BigDecimal(transacoes.filter { it.isTipo(tipo) }.sumByDouble { it.valor.toDouble() })
    }

}