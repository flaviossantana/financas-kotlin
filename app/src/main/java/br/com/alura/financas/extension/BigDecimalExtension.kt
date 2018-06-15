package br.com.alura.financas.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatarReal(): String {
    val formatroBrasil: NumberFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "bt"));
    return formatroBrasil.format(this).replace("BTN", "")
}