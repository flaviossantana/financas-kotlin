package br.com.alura.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.financas.R
import br.com.alura.financas.adapter.ListatTrancasoesAdapter
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import br.com.alura.financas.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal


class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(valor = BigDecimal(20.50), categoria = "COMIDA", tipo = DESPESA),
                                Transacao(valor = BigDecimal(100.0), categoria = "ECONOMIA", tipo = RECEITA),
                                Transacao(valor = BigDecimal(99.40), tipo = DESPESA))

        lista_transacoes_listview.adapter = ListatTrancasoesAdapter(transacoes, this)
    }


}