package com.example.grpahqldemo.data

import com.apollographql.apollo.ApolloClient
import com.example.grpahqldemo.CountriesQuery
import com.example.grpahqldemo.CountryQuery
import com.example.grpahqldemo.domain.CountryClient
import com.example.grpahqldemo.domain.DetailedCountry
import com.example.grpahqldemo.domain.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map { it.toSimpleCountry() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code)).execute().data?.country?.toDetailedCountry()
    }
}