package com.example.demokotlinwebapp

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class ControllerTests {

    private lateinit var greetingService: GreetingService

    @BeforeEach
    fun setup() {
        greetingService = GreetingService()
    }

    @Test
    fun `getMessage World returns Hello World`() {
        // given
        val controller = GreetingController(greetingService)

        // when
        val message = controller.getMessage("World!")

        // then
        assertThat(message, equalTo("Hello World!"))
    }

    @Test
    fun `getMessage John returns Hello John`() {
        // given
        val controller = GreetingController(greetingService)

        // when
        val message = controller.getMessage("John")

        // then
        assertThat(message, equalTo("Hello John"))
    }
}