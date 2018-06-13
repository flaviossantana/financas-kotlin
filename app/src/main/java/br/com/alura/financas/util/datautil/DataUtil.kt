package br.com.alura.financas.util.datautil

import java.text.SimpleDateFormat
import java.util.*

fun diaMesAno(data: Date): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    return sdf.format(data)
}