package com.techvalon.listadetarefas.view

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.techvalon.listadetarefas.components.Button
import com.techvalon.listadetarefas.components.InputText
import com.techvalon.listadetarefas.ui.theme.Purple500
import com.techvalon.listadetarefas.ui.theme.Purple700
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_GREEN_DISABLED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_RED_DISABLED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_YELLOW_DISABLED
import com.techvalon.listadetarefas.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.techvalon.listadetarefas.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarTarefa (navController: NavController) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var semPrioridade by remember {
        mutableStateOf(false)
    }

    var prioridadeBaixa by remember {
        mutableStateOf(false)
    }

    var prioridadeMedia by remember {
        mutableStateOf(false)
    }

    var prioridadeAlta by remember {
        mutableStateOf(false)
    }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple700
                ),
                title = {
                    Text(
                        text = "Salvar tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        }
    ) { paddingValues ->

        Column (
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            InputText(
                value = title,
                onValueChange = {
                    title = it
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 10.dp),
                label = "Titulo da tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            InputText(
                value = description,
                onValueChange = {
                    description = it
                },
                modifier = Modifier.fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 10.dp),
                label = "Descrição da tarefa",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Nível de Prioridade")

                RadioButton(
                    selected = prioridadeBaixa,
                    onClick = {
                        prioridadeBaixa = !prioridadeBaixa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLED,
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED
                    )
                )

                RadioButton(
                    selected = prioridadeMedia,
                    onClick = {
                        prioridadeMedia = !prioridadeMedia
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLED,
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                    )
                )

                RadioButton(
                    selected = prioridadeAlta,
                    onClick = {
                        prioridadeAlta = !prioridadeAlta
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_RED_DISABLED,
                        selectedColor = RADIO_BUTTON_RED_SELECTED
                    )
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                texto = "Salvar"
            )
        }
    }
}