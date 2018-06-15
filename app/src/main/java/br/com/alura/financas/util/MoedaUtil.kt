package br.com.alura.financas.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MoedaUtil {

    companion object {
        fun formatarValor(valor: BigDecimal): String {
            val formatroBrasil: NumberFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "bt"));
            return formatroBrasil.format(valor).replace("BTN", "")
        }
    }

}