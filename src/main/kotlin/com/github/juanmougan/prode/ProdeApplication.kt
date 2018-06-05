package com.github.juanmougan.prode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProdeApplication

fun main(args: Array<String>) {
    runApplication<ProdeApplication>(*args)
}
