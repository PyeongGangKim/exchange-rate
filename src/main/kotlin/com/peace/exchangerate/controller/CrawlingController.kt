package com.peace.exchangerate.controller

import com.peace.exchangerate.service.CrawlingService
import org.springframework.web.bind.annotation.RestController

@RestController
class CrawlingController(
    private val crawlingService: CrawlingService,
) {

}