package com.techvalon.listadetarefas.datasource

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.techvalon.listadetarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class DataSource {

    private val db = FirebaseFirestore.getInstance()
    private val _todastarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todastarefas: MutableStateFlow<MutableList<Tarefa>> = _todastarefas


    fun salvarTarefa (
        tarefa: String,
        descricao: String,
        prioridade: Int
    ) {
        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas").document(tarefa)
            .set(tarefaMap).addOnCompleteListener {

            }.addOnFailureListener {

            }
    }

    fun buscarTarefas () : Flow<MutableList<Tarefa>> {
        val tarefas: MutableList<Tarefa> = mutableListOf<Tarefa>()

        db.collection("tarefas").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (document in querySnapshot.result) {
                    val tarefa = document.toObject(Tarefa::class.java)
                    tarefas.add(tarefa)
                    _todastarefas.value = tarefas
                }
            }
        }

        return todastarefas
    }

    fun deletarTarefa (tarefa: String) {
        db.collection("tarefas").document(tarefa).delete().addOnSuccessListener {

        }.addOnFailureListener {

        }
    }

}