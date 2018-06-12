package br.com.alura.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import br.com.alura.financas.R
import kotlinx.android.synthetic.main.activity_lista_transacoes.*


class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf("COMIDA - R$ 20,50", "ECONOMIA - R$ 100,00")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, transacoes);
        lista_transacoes_listview.setAdapter(adapter)
    }


}