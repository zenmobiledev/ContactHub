package com.mobbelldev.contacthub.presentation.screens.main.component

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobbelldev.contacthub.R
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.presentation.theme.ContactHubTheme

@Composable
fun MainContent(
    user: User,
    onItemClick: (User) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                indication = LocalIndication.current,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onItemClick(user)
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.name, user.name),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.company, user.company.name),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainContentPreview() {
    ContactHubTheme {
        MainContent(
            user = User(
                id = 0,
                name = "Zaenal Arif",
                username = "zenmobiledev",
                email = "zaenalariftech@gmail.com",
                phone = "+62",
                website = "https://hai-zen.netlify.app/",
                address = User.Address(
                    zipcode = "12260",
                    geo = User.Geo(
                        lng = "",
                        lat = ""
                    ),
                    suite = "",
                    city = "South Jakarta",
                    street = "XX. XXXXXX"
                ),
                company = User.Company(
                    catchPhrase = "",
                    name = "Gencidev",
                    bs = "",
                )
            ),
            onItemClick = { }
        )
    }
}
