package com.example.demokotlinwebapp

class GreetingService() {
    enum class Language {English, Spanish}

    private val services = mapOf(
            Language.English to EnglishGreeting(),
            Language.Spanish to SpanishGreeting()
    )

    private val defaultGreeting = EnglishGreeting()

    fun getGreeting(name: String, language: Language = Language.English): String =
        services[language]?.getGreeting(name) ?: defaultGreeting.getGreeting(name)
}