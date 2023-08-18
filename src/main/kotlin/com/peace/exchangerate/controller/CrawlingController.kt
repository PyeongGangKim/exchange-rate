package com.peace.exchangerate.controller

import com.peace.exchangerate.service.CrawlingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/crawling")
class CrawlingController(
    private val crawlingService: CrawlingService,
) {

    @GetMapping("/exchange-rate")
    fun crawlingExchangeRate(): ResponseEntity<Map<String,String>> {
        val response = crawlingService.crawlingExchangeRate()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/exchange-rate/slack")
    fun sendToExchangeRateInfoToSlack(): ResponseEntity<Unit> {
        crawlingService.sendExchangeRateInfoToSlack()
        return ResponseEntity.ok().build()
    }
}