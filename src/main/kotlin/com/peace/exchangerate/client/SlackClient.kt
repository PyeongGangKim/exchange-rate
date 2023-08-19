package com.peace.exchangerate.client

import com.peace.exchangerate.properties.SlackProperties
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SlackClient(
    private val slackProperties: SlackProperties
) {

    fun sendMessage(message: String) {
        val slackMessage = HashMap<String, String>()
        slackMessage["text"] = message
        val restTemplate = RestTemplate()
        restTemplate.postForObject(slackProperties.token, slackMessage, String::class.java)
    }
}