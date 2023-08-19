package com.peace.exchangerate.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.beans.ConstructorProperties

@ConstructorBinding
@ConfigurationProperties(prefix = "slack")
class SlackProperties(
    val token: String
)