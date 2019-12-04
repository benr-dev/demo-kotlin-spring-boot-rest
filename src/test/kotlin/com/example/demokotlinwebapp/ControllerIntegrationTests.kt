package com.example.demokotlinwebapp

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class ControllerIntegrationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var controller : GreetingController

    @Test
    fun contexLoads() {
        assertThat(controller, notNullValue())
    }

    @Test
    fun shouldReturnDefaultMessage() {
        mockMvc.perform(get("/message"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello World")))
    }

    @Test
    fun shouldReturnCustomMessage() {
        mockMvc.perform(get("/message").param("name", "Bob"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello Bob")))
    }

    @Test
    fun shouldReturnCustomSpanishMessage() {
        mockMvc.perform(get("/message").param("name", "Bob").param("language", "Spanish"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hola Bob")))
    }
}