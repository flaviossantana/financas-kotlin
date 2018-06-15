package br.com.alura.financas.adapter

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
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListatTrancasoesAdapter(transacoes: List<Transacao>,
                              context: Context) : BaseAdapter() {

    private val transacoes = transacoes;
    private val context = context

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val transacaoView: View = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao : Transacao = getItem(posicao)

        transacaoView.transacao_icone.setBackgroundResource(transacao.icone())
        transacaoView.transacao_valor.text = transacao.valor.formatarReal()
        transacaoView.transacao_valor.setTextColor(ContextCompat.getColor(context, transacao.corValor()))
        transacaoView.transacao_categoria.text = transacao.categoria
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