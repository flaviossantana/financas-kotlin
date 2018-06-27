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

    fun atualiza() {
        addReceita()
        addDespesa()
        calcularTotal()
    }

    private fun addReceita(){
        with(view.resumo_card_receita){
            text = resumo.receita.formatarReal()
            setTextColor(resumo.corReceita(context))
        }
    }

    private fun addDespesa(){
        with(view.resumo_card_despesa){
            text = resumo.despesa.formatarReal()
            setTextColor(resumo.corDespesa(context))
        }
    }

    private fun calcularTotal() {
        with(view.resumo_card_total){
            text = resumo.total.formatarReal()
            setTextColor(resumo.corTotal(context))
        }
    }

}