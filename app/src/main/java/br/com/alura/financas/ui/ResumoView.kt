package br.com.alura.financas.ui

import android.view.View
import br.com.alura.financas.extension.formatarReal
import br.com.alura.financas.model.Resumo
import br.com.alura.financas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    fun addReceita(){
        view.resumo_card_receita.setText(resumo.receita().formatarReal())
    }

    fun addDespesa(){
        view.resumo_card_despesa.setText(resumo.despesa().formatarReal())
    }

    fun calcularTotal() {
        view.resumo_card_total.setText(resumo.total().formatarReal())
    }

}