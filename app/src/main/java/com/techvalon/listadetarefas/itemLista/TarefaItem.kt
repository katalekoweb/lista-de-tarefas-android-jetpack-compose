package com.techvalon.listadetarefas.itemLista

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.techvalon.listadetarefas.R
import com.techvalon.listadetarefas.model.Tarefa
import com.techvalon.listadetarefas.repository.TarefaRepository
import com.techvalon.listadetarefas.ui.theme.Purple200
import com.techvalon.listadetarefas.ui.theme.Purple700
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.techvalon.listadetarefas.ui.theme.White
import com.techvalon.listadetarefas.ui.theme.shapePrioridade
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TarefaItem (
    position: Int,
    listaTarefas: MutableList<Tarefa>,
    context: Context,
    navController: NavController
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridadeTarefa = listaTarefas[position].prioridade

    val scope = rememberCoroutineScope()
    val tarefasRepositorio = TarefaRepository()

    fun dialogDeletar () {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar tarefa")
        alertDialog.setMessage("Deseja deletar a tarefa?")
        alertDialog.setPositiveButton("Sim") { _, _ ->
            tarefasRepositorio.deletarTarefa(tituloTarefa.toString())
            scope.launch(Dispatchers.Main) {
                listaTarefas.removeAt(position)
                navController.navigate("listaTarefas")
                Toast.makeText(context, "Sucesso ao excluir a tarefa", Toast.LENGTH_SHORT).show()
            }
        }.setNegativeButton("Não") { _, _ ->

        }.show()
    }

    val nivelDePrioridade: String = when (prioridadeTarefa) {
        0 -> {
            "Sem prioridade"
        }
        1 -> {
            "Prioridade baixa"
        }
        2 -> {
            "Prioridade Média"
        }
        else -> {
            "Prioridade Alta"
        }
    }

    val color = when (prioridadeTarefa) {
        0 -> {
            Color.Black
        }
        1 -> {
            RADIO_BUTTON_GREEN_SELECTED
        }
        2 -> {
            RADIO_BUTTON_YELLOW_SELECTED
        }
        else -> {
            RADIO_BUTTON_RED_SELECTED
        }
    }

    Card (
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        ConstraintLayout (
            modifier = Modifier.padding(20.dp)
        ) {
            val (textTitutlo, textDescricao,cardPrioridade,textPrioridade,btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(textTitutlo) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(textDescricao) {
                    top.linkTo(textTitutlo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = nivelDePrioridade,
                modifier = Modifier.constrainAs(textPrioridade) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom)
                }
            )

            Card (
                colors = CardDefaults.cardColors(
                    containerColor = color
                ),
                modifier = Modifier.size(15.dp).constrainAs(cardPrioridade) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(textPrioridade.end, 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                shape = shapePrioridade.small
            ) {  }

            IconButton(
                onClick = {
                    dialogDeletar()
                },
                modifier = Modifier.constrainAs(btDeletar) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.delete_icon), contentDescription = null)
            }
        }


    }
}

/*
@Preview
@Composable
fun PreviewTarefaItem () {
    TarefaItem()
}

 */