package com.example.grpahqldemo.data

import com.example.grpahqldemo.CountriesQuery
import com.example.grpahqldemo.CountryQuery
import com.example.grpahqldemo.domain.DetailedCountry
import com.example.grpahqldemo.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        languages = languages.mapNotNull { it.name },
        continent = continent.name,
        currency = currency ?: "No currency"
    )
}


fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}