package br.com.alura.financas.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import br.com.alura.financas.R
import br.com.alura.financas.R.string.ano
import br.com.alura.financas.R.string.mes
import br.com.alura.financas.enum.Tipo.DESPESA
import br.com.alura.financas.enum.Tipo.RECEITA
import br.com.alura.financas.extension.diaMesAno
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.ui.ResumoView
import br.com.alura.financas.ui.adapter.ListatTrancasoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
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
            view.form_transacao_data.setOnClickListener {
                DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { datePicker: DatePicker, ano: Int, mes: Int, dia: Int ->
                            val dataSelecionada = Calendar.getInstance()
                            dataSelecionada.set(ano, mes, dia)
                            view.form_transacao_data.setText(dataSelecionada.diaMesAno())
                        },
                        hoje.get(Calendar.YEAR), hoje.get(Calendar.MONTH), hoje.get(Calendar.DATE))
                        .show()
            }

            val arrayAdapter = ArrayAdapter.createFromResource(this, R.array.categorias_de_receita, android.R.layout.simple_spinner_dropdown_item)
            view.form_transacao_categoria.adapter = arrayAdapter

            AlertDialog.Builder(this)
                    .setTitle(R.string.adiciona_receita)
                    .setView(view)
                    .setPositiveButton("Adicionar", null)
                    .setNegativeButton("Cancelar", null)
                    .show()

        })
    }

    private fun configResumo(transacoes: List<Transacao>) {
        val resumoView = ResumoView(this, window.decorView, transacoes)
        resumoView.atualiza()
    }


}