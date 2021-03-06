package br.com.alura.financas.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financas.R
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.extension.diaMesAno
import br.com.alura.financas.extension.formatarReal
import br.com.alura.financas.extension.limitarEmAte
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListatTrancasoesAdapter(private val transacoes: List<Transacao>,
                              private val context: Context) : BaseAdapter() {

    private val TAMANHO_MAXIMO = 14

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {

        val transacaoView: View = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        val transacao : Transacao = getItem(posicao)

        transacaoView.transacao_icone.setBackgroundResource(transacao.icone())

        transacaoView.transacao_valor.text = transacao.valor.formatarReal()
        transacaoView.transacao_valor.setTextColor(ContextCompat.getColor(context, transacao.corValor()))

        transacaoView.transacao_categoria.text = transacao.categoria.limitarEmAte(TAMANHO_MAXIMO)
        transacaoView.transacao_data.text = transacao.data.diaMesAno()

        return  transacaoView

    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes.get(posicao)
    }

    override fun getItemId(posicao: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}