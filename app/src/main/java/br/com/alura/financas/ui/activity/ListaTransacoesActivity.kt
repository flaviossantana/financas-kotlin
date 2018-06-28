package br.com.alura.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.alura.financas.R
import br.com.alura.financas.ui.adapter.ListatTrancasoesAdapter
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import br.com.alura.financas.extension.diaMesAno
import br.com.alura.financas.extension.formatarReal
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.ui.ResumoView
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal
import java.util.*


class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(valor = BigDecimal(20.50), categoria = "COMIDA", tipo = DESPESA),
                Transacao(valor = BigDecimal(100.0), categoria = "ECONOMIA", tipo = RECEITA),
                Transacao(valor = BigDecimal(99.40), tipo = DESPESA))

        configResumo(transacoes)

        lista_transacoes_listview.adapter = ListatTrancasoesAdapter(transacoes, this)

        addReceita()

        lista_transacoes_adiciona_despesa.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Adicionou Despesa!", Toast.LENGTH_LONG).show()
        })

    }

    private fun addReceita() {
        lista_transacoes_adiciona_receita.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Adicionou Receita!", Toast.LENGTH_LONG).show()

            val view = LayoutInflater.from(this).inflate(R.layout.form_transacao, it.parent as ViewGroup, false)

            val hoje = Calendar.getInstance()
            view.form_transacao_data.setText(hoje.diaMesAno())

            AlertDialog.Builder(this)
                    .setTitle(R.string.adiciona_receita)
                    .setView(view)
                    .show()

        })
    }

    private fun configResumo(transacoes: List<Transacao>) {
        val resumoView = ResumoView(this, window.decorView, transacoes)
        resumoView.atualiza()
    }


}