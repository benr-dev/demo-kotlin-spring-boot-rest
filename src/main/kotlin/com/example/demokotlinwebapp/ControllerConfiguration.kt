package com.example.demokotlinwebapp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ControllerConfiguration {
    @Bean
    fun greetingService() = GreetingService()
}