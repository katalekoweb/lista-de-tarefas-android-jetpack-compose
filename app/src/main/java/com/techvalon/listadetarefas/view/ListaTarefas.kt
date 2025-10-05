package com.techvalon.listadetarefas.view

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.techvalon.listadetarefas.ui.theme.Purple700
import com.techvalon.listadetarefas.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ListaTarefas (navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple700
                ),
                title = {
                    Text(
                        "Lista de tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        },
        containerColor = White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvaTarefa")
                },
                containerColor = Purple700,
                contentColor = White
            ) {
                Image(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Nova Tarefa"
                )
            }
        }
    ) {

    }

}