package com.example.demokotlinwebapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(val greetingService: GreetingService) {

    @GetMapping("/message")
    fun getMessage(
            @RequestParam(value = "name", defaultValue = "World") name: String,
            @RequestParam(value = "language", required = false) language: String? = null) : String {
        return if (language == null) {
            greetingService.getGreeting(name)
        }
        else {
            greetingService.getGreeting(name, GreetingService.Language.valueOf(language))
        }
    }
}