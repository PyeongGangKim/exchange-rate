package com.peace.exchangerate.properties

import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
class SlackProperties(
    val token: String
)