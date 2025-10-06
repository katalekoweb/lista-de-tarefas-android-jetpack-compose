package com.techvalon.listadetarefas.repository

import com.techvalon.listadetarefas.datasource.DataSource
import com.techvalon.listadetarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefaRepository () {

    private val dataSource = DataSource()

    fun salvarTarefa (
        tarefa: String,
        descricao: String,
        prioridade: Int
    ) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }

    fun buscarTarefas (): Flow<MutableList<Tarefa>> {
        return dataSource.buscarTarefas()
    }

    fun deletarTarefa (tarefa: String) {
        dataSource.deletarTarefa(tarefa)
    }
}