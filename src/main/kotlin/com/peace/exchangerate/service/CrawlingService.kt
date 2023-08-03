package com.peace.exchangerate.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class CrawlingService {
    companion object {
        private const val NAVER_FINANCE_URL = "https://finance.naver.com/marketindex/exchangeList.nhn"
        private const val COUNTRY_DELIMITER = ".tit"
        private const val EXCHANGE_RATE_DELIMITER = ".sale"

    }


    fun crawling(): MutableMap<String, String> {
        val scrappedData = Jsoup.connect(NAVER_FINANCE_URL).get()
        val countries = scrappedData.select(COUNTRY_DELIMITER)
        val sales = scrappedData.select(EXCHANGE_RATE_DELIMITER)
        val countryToSale = mutableMapOf<String, String>()
        countries.forEachIndexed { idx, country ->
            val sale = sales[idx].text()
            countryToSale[country.text()] = sale
        }
        return countryToSale
    }
}