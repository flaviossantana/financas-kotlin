package br.com.alura.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.alura.financas.R
import br.com.alura.financas.ui.adapter.ListatTrancasoesAdapter
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import br.com.alura.financas.extension.formatarReal
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.ui.ResumoView
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal


class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(valor = BigDecimal(20.50), categoria = "COMIDA", tipo = DESPESA),
                                Transacao(valor = BigDecimal(100.0), categoria = "ECONOMIA", tipo = RECEITA),
                                Transacao(valor = BigDecimal(99.40), tipo = DESPESA))

        configResumo(transacoes)

        lista_transacoes_listview.adapter = ListatTrancasoesAdapter(transacoes, this)
    }

    private fun configResumo(transacoes: List<Transacao>) {
        val resumoView = ResumoView(this, window.decorView, transacoes)
        resumoView.addDespesa()
        resumoView.addReceita()
        resumoView.calcularTotal()
    }


}