package com.techvalon.listadetarefas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.techvalon.listadetarefas.ui.theme.Black
import com.techvalon.listadetarefas.ui.theme.LIGHT_BLUE
import com.techvalon.listadetarefas.ui.theme.ShapeEditText
import kotlin.math.max

@Composable
fun InputText (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = LIGHT_BLUE,
            unfocusedTextColor = Black,
            cursorColor = LIGHT_BLUE
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

@Preview
@Composable
private fun PreviewInputText () {
    InputText(
        value = "Kataleko",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Descrição",
        maxLines = 1,
        keyboardType = KeyboardType.Text
    )
}