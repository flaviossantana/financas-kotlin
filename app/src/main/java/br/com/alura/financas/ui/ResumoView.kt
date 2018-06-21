package br.com.alura.financas.ui

import android.content.Context
import android.view.View
import br.com.alura.financas.extension.formatarReal
import br.com.alura.financas.model.Resumo
import br.com.alura.financas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private final val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    fun addReceita(){
        view.resumo_card_receita.setText(resumo.receita().formatarReal())
        view.resumo_card_receita.setTextColor(resumo.corReceita(context))
    }

    fun addDespesa(){
        view.resumo_card_despesa.setText(resumo.despesa().formatarReal())
        view.resumo_card_despesa.setTextColor(resumo.corDespesa(context))
    }

    fun calcularTotal() {
        view.resumo_card_total.setText(resumo.total().formatarReal())
        view.resumo_card_total.setTextColor(resumo.corTotal(context))
    }

}