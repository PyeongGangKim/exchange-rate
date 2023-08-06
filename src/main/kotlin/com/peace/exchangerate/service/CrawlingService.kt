package com.peace.exchangerate.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class CrawlingService {
    companion object {
        private const val NAVER_FINANCE_URL = "https://finance.naver.com/marketindex/exchangeList.nhn"
        private const val COUNTRY_DELIMITER = ".tit"
        private const val EXCHANGE_RATE_DELIMITER = ".sale"
        private val INTEREST_EXCHANGE_RATE = listOf("미국 USD", "유럽연합 EUR", "일본 JPY (100엔)")
    }

    fun crawlingExchangeRate(): MutableMap<String, String> {
        val scrappedData = Jsoup.connect(NAVER_FINANCE_URL).get()
        val countries = scrappedData.select(COUNTRY_DELIMITER)
        val sales = scrappedData.select(EXCHANGE_RATE_DELIMITER)
        val countryToSale = mutableMapOf<String, String>()
        getCountryToSaleInInterestExchangeRate(countries, sales, countryToSale)
        return countryToSale
    }

    private fun getCountryToSaleInInterestExchangeRate(
        countries: Elements,
        sales: Elements,
        countryToSale: MutableMap<String, String>
    ) {
        countries.forEachIndexed { idx, country ->
            if (isNotInterestExchangeRate(country)) return@forEachIndexed
            val sale = sales[idx].text()
            countryToSale[country.text()] = sale
        }
    }

    private fun isNotInterestExchangeRate(country: Element) = !INTEREST_EXCHANGE_RATE.contains(country.text())
}