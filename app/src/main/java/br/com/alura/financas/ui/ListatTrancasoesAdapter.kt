package br.com.alura.financas.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financas.R
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.util.datautil.DataUtil
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListatTrancasoesAdapter(transacoes: List<Transacao>,
                              context: Context) : BaseAdapter() {

    private val transacoes = transacoes;
    private val context = context

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val transacaoView: View = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = getItem(posicao)

        transacaoView.transacao_valor.setText(transacao.valor.toString())
        transacaoView.transacao_categoria.setText(transacao.categoria)
        transacaoView.transacao_data.setText(DataUtil.diaMesAno(transacao.data.time))

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