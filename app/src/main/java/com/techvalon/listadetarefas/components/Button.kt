package com.techvalon.listadetarefas.components

import android.widget.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.techvalon.listadetarefas.ui.theme.LIGHT_BLUE
import com.techvalon.listadetarefas.ui.theme.White

@Composable
fun Button (
    onClick: () -> Unit,
    modifier: Modifier,
    texto: String
) {
    androidx.compose.material3.Button (
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = LIGHT_BLUE,
            contentColor = White
        )
    ) {
        Text(text = texto, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}