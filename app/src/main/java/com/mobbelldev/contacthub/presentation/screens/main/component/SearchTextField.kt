package com.mobbelldev.contacthub.presentation.screens.main.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobbelldev.contacthub.R
import com.mobbelldev.contacthub.presentation.theme.ContactHubTheme

@Composable
fun SearchTextField(
    value: String,
    onChange: (String) -> Unit,
    onClear: () -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        placeholder = {
            Text(text = stringResource(R.string.placeholder))
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { onClear() }) {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = stringResource(R.string.clear)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    ContactHubTheme {
        SearchTextField(
            value = "Zaenal Arif",
            onChange = {},
            onClear = {}
        )
    }
}