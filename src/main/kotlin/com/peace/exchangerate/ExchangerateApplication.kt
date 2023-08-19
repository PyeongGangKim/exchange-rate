package com.peace.exchangerate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan(basePackages = ["com.peace.exchangerate.properties"])
@SpringBootApplication
class ExchangerateApplication

fun main(args: Array<String>) {
	runApplication<ExchangerateApplication>(*args)
}
