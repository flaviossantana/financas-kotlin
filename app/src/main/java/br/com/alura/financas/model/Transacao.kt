package br.com.alura.financas.model

import br.com.alura.financas.enum.Tipo
import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val categoria: String = "INDEFINIDA",
                val tipo: Tipo,
                val data: Calendar = Calendar.getInstance()) {

}