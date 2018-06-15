package br.com.alura.financas.extension

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.diaMesAno(): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    return sdf.format(this.time)
}


