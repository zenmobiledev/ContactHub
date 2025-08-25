package com.mobbelldev.contacthub.presentation.screens.detail.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobbelldev.contacthub.R
import com.mobbelldev.contacthub.domain.model.User

@Composable
fun DetailContent(user: User) {
    with(user) {
        Text(text = stringResource(R.string.email, email))
        Text(text = stringResource(R.string.phone, phone))
        Text(text = stringResource(R.string.website, website))
        Text(text = stringResource(R.string.company, company.name))
        Text(text = stringResource(R.string.address, address.street, address.city))
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailContentPreview() {
    DetailContent(
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
        )
    )
}