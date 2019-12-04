package com.example.demokotlinwebapp

interface Greeting {
    fun getGreeting(name: String): String
}

class EnglishGreeting : Greeting{
    override fun getGreeting(name: String) = "Hello $name"

}

class SpanishGreeting : Greeting{
    override fun getGreeting(name: String) = "Hola $name"

}