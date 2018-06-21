package br.com.alura.financas.model

import br.com.alura.financas.enum.Tipo
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita(): BigDecimal{
        return somar(RECEITA)
    }

    fun despesa(): BigDecimal {
        return somar(DESPESA)
    }

    fun total(): BigDecimal{
        return receita().subtract(despesa())
    }

    private fun somar(tipo: Tipo): BigDecimal {
        var total = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.isTipo(tipo)) {
                total = total.plus(transacao.valor)
            }
        }
        return total
    }

}